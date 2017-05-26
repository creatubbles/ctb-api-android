package com.creatubbles.api;

import android.app.Application;

import com.creatubbles.api.di.modules.ApiModule;

import java.lang.reflect.Method;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Janek on 14.10.2016.
 */

public class TestUtils {

    @SuppressWarnings("NewApi")
    public static void resetModule() {
        try {
            Method m = ApiModule.class.getDeclaredMethod("reset");
            m.setAccessible(true);
            m.invoke(null);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }

    public static void initializeCreatubblesApi() {
        CreatubblesApi.initialize(new Configuration.Builder()
                .clientSecret("secret")
                .clientId("id")
                .baseUrl("http://url.com")
                .application(new Application())
                .interceptor(Configuration.Builder.Interceptors.getLoggingInterceptor(HttpLoggingInterceptor.Level.BODY))
                .build());
    }

}
