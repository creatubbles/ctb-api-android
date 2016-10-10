package com.creatubbles.api;

import android.content.Context;

import com.creatubbles.api.converter.GsonUTCDateAdapter;
import com.creatubbles.api.converter.NullOnEmptyConverterFactory;
import com.creatubbles.api.converter.RoleTypeAdapter;
import com.creatubbles.api.interceptor.CreatubbleInterceptor;
import com.creatubbles.api.model.AuthToken;
import com.creatubbles.api.model.creation.Creation;
import com.creatubbles.api.model.gallery.Gallery;
import com.creatubbles.api.model.upload.Upload;
import com.creatubbles.api.model.user.NewUser;
import com.creatubbles.api.model.user.Role;
import com.creatubbles.api.model.user.User;
import com.creatubbles.api.service.CreationService;
import com.creatubbles.api.service.GalleryService;
import com.creatubbles.api.service.UserService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jasminb.jsonapi.retrofit.JSONAPIConverterFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by Janek on 08.02.2016.
 */
public class ServiceGenerator {

    private static final List<Class<?>> MIGRATED_SERVICES = Arrays.asList(CreationService.class, UserService.class, GalleryService.class);

    private Context appContext;

    private Retrofit.Builder builder;

    public ServiceGenerator(Context context) {
        appContext = context;
        initialize();
    }

    public void initialize() {
        OkHttpClient client = new OkHttpClient.Builder()
                .cookieJar(getAcceptAllCookieJar())
                .addInterceptor(CreatubbleInterceptor.getFileUploadInterceptor(appContext))
                .addInterceptor(CreatubbleInterceptor.getLogginInterceptor())
                .build();

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, new GsonUTCDateAdapter())
                .registerTypeAdapter(Role.class, new RoleTypeAdapter())
                .create();

        builder = new Retrofit.Builder()
                .baseUrl(EndPoints.URL_BASE)
                .addConverterFactory(new NullOnEmptyConverterFactory())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client);

        if (EndPoints.SET_STAGING) {
            builder.baseUrl(EndPoints.URL_BASE_STAGING);
        }
    }

    public <S> S createService(Class<S> serviceClass, final ContentType contentType) {
        Map<String, String> headerParamMap = new HashMap<>();
        headerParamMap.put("Accept", "application/vnd.api+json");
        headerParamMap.put("Content-Type", contentType.getRes());

        OkHttpClient client = new OkHttpClient.Builder()
                .cookieJar(getAcceptAllCookieJar())
                .addInterceptor(CreatubbleInterceptor.getHeaderInterceptor(headerParamMap))
                .addInterceptor(CreatubbleInterceptor.getFileUploadInterceptor(appContext))
                .addInterceptor(CreatubbleInterceptor.getLogginInterceptor())
                .build();

        Retrofit retrofit = builder
                .addConverterFactory(new NullOnEmptyConverterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit.create(serviceClass);
    }

    public <S> S createService(Class<S> serviceClass) {

        Map<String, String> headerParamMap = new HashMap<>();

        OkHttpClient client = new OkHttpClient.Builder()
                .cookieJar(getAcceptAllCookieJar())
                .addInterceptor(CreatubbleInterceptor.getHeaderInterceptor(headerParamMap))
                .addInterceptor(CreatubbleInterceptor.getLogginInterceptor())
                .build();

        Retrofit retrofit = builder
                .addConverterFactory(new NullOnEmptyConverterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit.create(serviceClass);
    }

    public <S> S createService(Class<S> serviceClass, final ContentType contentType, final
    AuthToken token) {

        Map<String, String> headerParamMap = new HashMap<>();
        headerParamMap.put("Accept", "application/vnd.api+json");
        headerParamMap.put("Content-Type", contentType.getRes());
        if (token != null) {
            headerParamMap.put("Authorization", token.getTokenType() + " " + token.getAccessToken());
        }

        OkHttpClient client = new OkHttpClient.Builder()
                .cookieJar(getAcceptAllCookieJar())
                .addInterceptor(CreatubbleInterceptor.getHeaderInterceptor(headerParamMap))
                .addInterceptor(CreatubbleInterceptor.getFileUploadInterceptor(appContext))
                .addInterceptor(CreatubbleInterceptor.getLogginInterceptor())
                .build();

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://staging.creatubbles.com/api/v2/")
                .addConverterFactory(new NullOnEmptyConverterFactory())
                .client(client);
        if (MIGRATED_SERVICES.contains(serviceClass)) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.setTimeZone(TimeZone.getTimeZone("UTC"));
            JSONAPIConverterFactory converterFactory = new JSONAPIConverterFactory(objectMapper, Creation.class, User.class, NewUser.class, Upload.class, Gallery.class);
            converterFactory.setAlternativeFactory(JacksonConverterFactory.create(objectMapper));
            builder.addConverterFactory(converterFactory);
        } else {
            builder.addConverterFactory(GsonConverterFactory.create());
        }

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
                return cookies != null ? cookies : new ArrayList<Cookie>();
            }
        };
    }
}

