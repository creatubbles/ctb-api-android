package com.creatubbles.api;

import com.creatubbles.api.interceptor.CreatubbleInterceptor;
import com.creatubbles.api.model.Ability;
import com.creatubbles.api.model.Following;
import com.creatubbles.api.model.GallerySubmission;
import com.creatubbles.api.model.PasswordChange;
import com.creatubbles.api.model.Report;
import com.creatubbles.api.model.activity.Activity;
import com.creatubbles.api.model.auth.AccessToken;
import com.creatubbles.api.model.bubble.Bubble;
import com.creatubbles.api.model.bubble.BubbleColor;
import com.creatubbles.api.model.comment.Comment;
import com.creatubbles.api.model.comment.Mention;
import com.creatubbles.api.model.content.Content;
import com.creatubbles.api.model.creation.Creation;
import com.creatubbles.api.model.creation.ToybooDetails;
import com.creatubbles.api.model.gallery.Gallery;
import com.creatubbles.api.model.gallery.HowToSection;
import com.creatubbles.api.model.group.Group;
import com.creatubbles.api.model.hashtag.Hashtag;
import com.creatubbles.api.model.image_manipulation.ImageManipulation;
import com.creatubbles.api.model.landing_url.LandingUrl;
import com.creatubbles.api.model.notification.CreationEntity;
import com.creatubbles.api.model.notification.GalleryEntity;
import com.creatubbles.api.model.notification.Notification;
import com.creatubbles.api.model.notification.UserEntity;
import com.creatubbles.api.model.partner_application.AppScreenshot;
import com.creatubbles.api.model.partner_application.PartnerApplication;
import com.creatubbles.api.model.school.School;
import com.creatubbles.api.model.search.SearchCategory;
import com.creatubbles.api.model.upload.Upload;
import com.creatubbles.api.model.user.AccountDetails;
import com.creatubbles.api.model.user.MultipleCreators;
import com.creatubbles.api.model.user.NewUser;
import com.creatubbles.api.model.user.User;
import com.creatubbles.api.model.user.UserFollowing;
import com.creatubbles.api.model.user.avatar.Avatar;
import com.creatubbles.api.model.user.avatar.AvatarSuggestion;
import com.creatubbles.api.model.user.custom_style.CustomStyle;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jasminb.jsonapi.DeserializationFeature;
import com.github.jasminb.jsonapi.ResourceConverter;
import com.github.jasminb.jsonapi.retrofit.JSONAPIConverterFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Janek on 08.02.2016.
 */
public class ServiceGenerator {

    private static final String HEADER_ACCEPT = "Accept";
    private static final String HEADER_CONTENT_TYPE = "Content-Type";
    private static final String HEADER_AUTHORIZATION = "Authorization";
    private static final String HEADER_ACCEPT_LANGUAGE = "Accept-Language";
    private static final String HEADER_DEVICE_TYPE = "X-Device-Type";
    private static final String CONTENT_TYPE_JSON = "application/vnd.api+json";
    private Configuration configuration;

    private static final Class[] defaultApiModels = {Creation.class, User.class, NewUser.class, Upload.class,
            Gallery.class, LandingUrl.class, MultipleCreators.class, Activity.class, Comment.class,
            CustomStyle.class, UserFollowing.class, Group.class, Bubble.class, BubbleColor.class,
            GallerySubmission.class, ImageManipulation.class, AccountDetails.class, School.class,
            PasswordChange.class, Notification.class, CreationEntity.class, GalleryEntity.class,
            UserEntity.class, Avatar.class, AvatarSuggestion.class, Report.class, Ability.class,
            ToybooDetails.class, PartnerApplication.class, AppScreenshot.class, Content.class,
            SearchCategory.class, HowToSection.class, Mention.class, Hashtag.class, Following.class};


    private Retrofit.Builder builder;

    private ObjectMapper objectMapper;

    public ServiceGenerator(Configuration configuration, ObjectMapper objectMapper) {
        this.configuration = configuration;
        this.objectMapper = objectMapper;
        initialize();
    }

    public void initialize() {

        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        clientBuilder.cookieJar(getAcceptAllCookieJar())
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS);
        addInterceptorFromConfiguration(clientBuilder);

        OkHttpClient client = clientBuilder.build();

        builder = new Retrofit.Builder()
                .baseUrl(configuration.getBaseUrl())
                .client(client);

        Class[] additionalModels = configuration.getAdditionalApiModels();
        Class[] allModels = concatArrays(additionalModels, defaultApiModels);
        ResourceConverter resourceConverter = new ResourceConverter(objectMapper, allModels);
        resourceConverter.enableDeserializationOption(DeserializationFeature.ALLOW_UNKNOWN_INCLUSIONS);
        resourceConverter.enableDeserializationOption(DeserializationFeature.IGNORE_UNREGISTERED_TYPES);
        JSONAPIConverterFactory converterFactory = new JSONAPIConverterFactory(resourceConverter);
        converterFactory.setAlternativeFactory(JacksonConverterFactory.create(objectMapper));
        builder.addConverterFactory(ScalarsConverterFactory.create());
        builder.addConverterFactory(converterFactory);

    }

    private Class[] concatArrays(Class[] a, Class[] b) {
        if (a == null && b == null) {
            return null;
        } else if (a == null) {
            return b;
        } else if (b == null) {
            return a;
        } else {
            Class[] result = new Class[b.length + a.length];
            System.arraycopy(b, 0, result, 0, b.length);
            System.arraycopy(a, 0, result, b.length, a.length);
            return result;
        }
    }

    public <S> S createService(Class<S> serviceClass, final ContentType contentType) {
        Map<String, String> headerParamMap = new HashMap<>();
        headerParamMap.put(HEADER_ACCEPT, CONTENT_TYPE_JSON);
        headerParamMap.put(HEADER_CONTENT_TYPE, contentType.getRes());
        addLanguageHeader(headerParamMap);
        addClientHeader(headerParamMap);

        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        clientBuilder
                .cookieJar(getAcceptAllCookieJar())
                .addInterceptor(CreatubbleInterceptor.getHeaderInterceptor(headerParamMap))
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS);
        addInterceptorFromConfiguration(clientBuilder);

        OkHttpClient client = clientBuilder.build();

        Retrofit retrofit = builder
                .client(client)
                .build();

        return retrofit.create(serviceClass);
    }

    public <S> S createService(Class<S> serviceClass) {

        Map<String, String> headerParamMap = new HashMap<>();
        addLanguageHeader(headerParamMap);
        addClientHeader(headerParamMap);

        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        clientBuilder
                .cookieJar(getAcceptAllCookieJar())
                .addInterceptor(CreatubbleInterceptor.getHeaderInterceptor(headerParamMap))
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS);
        addInterceptorFromConfiguration(clientBuilder);

        OkHttpClient client = clientBuilder.build();

        Retrofit retrofit = builder
                .client(client)
                .build();

        return retrofit.create(serviceClass);
    }

    public <S> S createService(Class<S> serviceClass, final ContentType contentType, final
    AccessToken token) {

        Map<String, String> headerParamMap = new HashMap<>();
        headerParamMap.put(HEADER_ACCEPT, CONTENT_TYPE_JSON);
        headerParamMap.put(HEADER_CONTENT_TYPE, contentType.getRes());
        if (token != null) {
            headerParamMap.put(HEADER_AUTHORIZATION, token.getType() + " " + token.getToken());
        }
        addLanguageHeader(headerParamMap);
        addClientHeader(headerParamMap);

        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        clientBuilder
                .cookieJar(getAcceptAllCookieJar())
                .addInterceptor(CreatubbleInterceptor.getHeaderInterceptor(headerParamMap))
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS);
        addInterceptorFromConfiguration(clientBuilder);

        OkHttpClient client = clientBuilder.build();

        builder.client(client);

        return builder.build().create(serviceClass);
    }

    private void addLanguageHeader(Map<String, String> headerParamMap) {
        if (configuration.getLocale() != null) {
            headerParamMap.put(HEADER_ACCEPT_LANGUAGE, configuration.getLocale().getRes());
        }
    }

    private void addClientHeader(Map<String, String> headerParamMap) {
        if (configuration.getClientDevice() != null) {
            headerParamMap.put(HEADER_DEVICE_TYPE, configuration.getClientDevice().getType());
        }
    }

    private CookieJar getAcceptAllCookieJar() {
        return new CookieJar() {
            private final HashMap<HttpUrl, List<Cookie>> cookieStore = new HashMap<>();

            @Override
            public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                cookieStore.put(url, cookies);
            }

            @Override
            public List<Cookie> loadForRequest(HttpUrl url) {
                List<Cookie> cookies = cookieStore.get(url);
                return cookies != null ? cookies : new ArrayList<>();
            }
        };
    }

    private void addInterceptorFromConfiguration(OkHttpClient.Builder clientBuilder) {
        if (configuration.getInterceptor() != null) {
            clientBuilder.addNetworkInterceptor(configuration.getInterceptor());
        }
    }
}

