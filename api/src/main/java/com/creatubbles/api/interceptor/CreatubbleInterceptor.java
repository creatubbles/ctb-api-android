package com.creatubbles.api.interceptor;

import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by mariuszostapowicz on 03.03.2016.
 */
public class CreatubbleInterceptor {

    public static Interceptor getHeaderInterceptor(final Map<String, String> headerParamrMap) {
        return chain -> {

            Request.Builder builder = chain.request().newBuilder();

            for (Map.Entry<String, String> headerParam : headerParamrMap.entrySet()) {
                builder.addHeader(headerParam.getKey(), headerParam.getValue());
            }

            return chain.proceed(builder.build());
        };
    }

    public static Interceptor getLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return interceptor;
    }
}
