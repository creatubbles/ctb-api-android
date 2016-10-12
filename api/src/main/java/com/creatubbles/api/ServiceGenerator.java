package com.creatubbles.api;

import com.creatubbles.api.converter.ApprovalStatusTypeAdapter;
import com.creatubbles.api.converter.GsonUTCDateAdapter;
import com.creatubbles.api.converter.ImageStatusTypeAdapter;
import com.creatubbles.api.converter.NullOnEmptyConverterFactory;
import com.creatubbles.api.converter.RoleTypeAdapter;
import com.creatubbles.api.interceptor.CreatubbleInterceptor;
import com.creatubbles.api.model.AuthToken;
import com.creatubbles.api.model.creation.ApprovalStatus;
import com.creatubbles.api.model.creation.ImageStatus;
import com.creatubbles.api.model.user.Role;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Janek on 08.02.2016.
 */
public class ServiceGenerator {

    Configuration configuration;

    private Retrofit.Builder builder;

    public ServiceGenerator(Configuration configuration) {
        this.configuration = configuration;
        initialize();
    }

    public void initialize() {
        OkHttpClient client = new OkHttpClient.Builder()
                .cookieJar(getAcceptAllCookieJar())
                .addInterceptor(CreatubbleInterceptor.getFileUploadInterceptor(configuration.getContext()))
                .addInterceptor(CreatubbleInterceptor.getLogginInterceptor())
                .build();

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(ImageStatus.class, new ImageStatusTypeAdapter())
                .registerTypeAdapter(ApprovalStatus.class, new ApprovalStatusTypeAdapter())
                .registerTypeAdapter(Date.class, new GsonUTCDateAdapter())
                .registerTypeAdapter(Role.class, new RoleTypeAdapter())
                .create();

        builder = new Retrofit.Builder()
                .baseUrl(configuration.getBaseUrl())
                .addConverterFactory(new NullOnEmptyConverterFactory())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client);
    }

    public <S> S createService(Class<S> serviceClass, final ContentType contentType) {

        Map<String, String> headerParamMap = new HashMap<>();
        headerParamMap.put("Accept", "application/vnd.api+json");
        headerParamMap.put("Content-Type", contentType.getRes());

        OkHttpClient client = new OkHttpClient.Builder()
                .cookieJar(getAcceptAllCookieJar())
                .addInterceptor(CreatubbleInterceptor.getHeaderInterceptor(headerParamMap))
                .addInterceptor(CreatubbleInterceptor.getFileUploadInterceptor(configuration.getContext()))
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
                .addInterceptor(CreatubbleInterceptor.getFileUploadInterceptor(configuration.getContext()))
                .addInterceptor(CreatubbleInterceptor.getLogginInterceptor())
                .build();

        Retrofit retrofit = builder
                .addConverterFactory(new NullOnEmptyConverterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit.create(serviceClass);
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

