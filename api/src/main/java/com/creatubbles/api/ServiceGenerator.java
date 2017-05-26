package com.creatubbles.api;

import com.creatubbles.api.interceptor.CreatubbleInterceptor;
import com.creatubbles.api.model.Ability;
import com.creatubbles.api.model.GallerySubmission;
import com.creatubbles.api.model.PasswordChange;
import com.creatubbles.api.model.Report;
import com.creatubbles.api.model.activity.Activity;
import com.creatubbles.api.model.auth.AccessToken;
import com.creatubbles.api.model.bubble.Bubble;
import com.creatubbles.api.model.bubble.BubbleColor;
import com.creatubbles.api.model.comment.Comment;
import com.creatubbles.api.model.content.Content;
import com.creatubbles.api.model.creation.Creation;
import com.creatubbles.api.model.creation.ToybooDetails;
import com.creatubbles.api.model.gallery.Gallery;
import com.creatubbles.api.model.group.Group;
import com.creatubbles.api.model.image_manipulation.ImageManipulation;
import com.creatubbles.api.model.landing_url.LandingUrl;
import com.creatubbles.api.model.notification.CreationEntity;
import com.creatubbles.api.model.notification.GalleryEntity;
import com.creatubbles.api.model.notification.Notification;
import com.creatubbles.api.model.notification.UserEntity;
import com.creatubbles.api.model.partner_application.AppScreenshot;
import com.creatubbles.api.model.partner_application.PartnerApplication;
import com.creatubbles.api.model.school.School;
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

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by Janek on 08.02.2016.
 */
public class ServiceGenerator {

    private Configuration configuration;
    private final Class[] jsonApiModels = {Creation.class, User.class, NewUser.class, Upload.class,
            Gallery.class, LandingUrl.class, MultipleCreators.class, Activity.class, Comment.class,
            CustomStyle.class, UserFollowing.class, Group.class, Bubble.class, BubbleColor.class,
            GallerySubmission.class, ImageManipulation.class, AccountDetails.class, School.class,
            PasswordChange.class, Notification.class, CreationEntity.class, GalleryEntity.class,
            UserEntity.class, Avatar.class, AvatarSuggestion.class, Report.class, Ability.class,
            ToybooDetails.class, PartnerApplication.class, AppScreenshot.class, Content.class};


    private Retrofit.Builder builder;

    private ObjectMapper objectMapper;

    public ServiceGenerator(Configuration configuration, ObjectMapper objectMapper) {
        this.configuration = configuration;
        this.objectMapper = objectMapper;
        initialize();
    }

    public void initialize() {
        OkHttpClient client = new OkHttpClient.Builder()
                .cookieJar(getAcceptAllCookieJar())
                .addInterceptor(CreatubbleInterceptor.getLoggingInterceptor(configuration.getHttpLogLevel()))
                .build();

        builder = new Retrofit.Builder()
                .baseUrl(configuration.getBaseUrl())
                .client(client);

        ResourceConverter resourceConverter = new ResourceConverter(objectMapper, jsonApiModels);
        resourceConverter.enableDeserializationOption(DeserializationFeature.ALLOW_UNKNOWN_INCLUSIONS);
        JSONAPIConverterFactory converterFactory = new JSONAPIConverterFactory(resourceConverter);
        converterFactory.setAlternativeFactory(JacksonConverterFactory.create(objectMapper));
        builder.addConverterFactory(converterFactory);

    }

    public <S> S createService(Class<S> serviceClass, final ContentType contentType) {
        Map<String, String> headerParamMap = new HashMap<>();
        headerParamMap.put("Accept", "application/vnd.api+json");
        headerParamMap.put("Content-Type", contentType.getRes());
        if (configuration.getLocale() != null) {
            headerParamMap.put("Accept-Language", configuration.getLocale().getRes());
        }

        OkHttpClient client = new OkHttpClient.Builder()
                .cookieJar(getAcceptAllCookieJar())
                .addInterceptor(CreatubbleInterceptor.getHeaderInterceptor(headerParamMap))
                .addInterceptor(CreatubbleInterceptor.getLoggingInterceptor(configuration.getHttpLogLevel()))
                .build();

        Retrofit retrofit = builder
                .client(client)
                .build();

        return retrofit.create(serviceClass);
    }

    public <S> S createService(Class<S> serviceClass) {

        Map<String, String> headerParamMap = new HashMap<>();
        if (configuration.getLocale() != null) {
            headerParamMap.put("Accept-Language", configuration.getLocale().getRes());
        }

        OkHttpClient client = new OkHttpClient.Builder()
                .cookieJar(getAcceptAllCookieJar())
                .addInterceptor(CreatubbleInterceptor.getHeaderInterceptor(headerParamMap))
                .addInterceptor(CreatubbleInterceptor.getLoggingInterceptor(configuration.getHttpLogLevel()))
                .build();

        Retrofit retrofit = builder
                .client(client)
                .build();

        return retrofit.create(serviceClass);
    }

    public <S> S createService(Class<S> serviceClass, final ContentType contentType, final
    AccessToken token) {

        Map<String, String> headerParamMap = new HashMap<>();
        headerParamMap.put("Accept", "application/vnd.api+json");
        headerParamMap.put("Content-Type", contentType.getRes());
        if (token != null) {
            headerParamMap.put("Authorization", token.getType() + " " + token.getToken());
        }
        if (configuration.getLocale() != null) {
            headerParamMap.put("Accept-Language", configuration.getLocale().getRes());
        }


        OkHttpClient client = new OkHttpClient.Builder()
                .cookieJar(getAcceptAllCookieJar())
                .addInterceptor(CreatubbleInterceptor.getHeaderInterceptor(headerParamMap))
                .addInterceptor(CreatubbleInterceptor.getLoggingInterceptor(configuration.getHttpLogLevel()))
                .build();

        builder.client(client);

        return builder.build().create(serviceClass);
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
}

