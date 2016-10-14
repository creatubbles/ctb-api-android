package com.creatubbles.api.repository;

import android.app.Application;

import com.creatubbles.api.Configuration;
import com.creatubbles.api.CreatubblesApi;
import com.creatubbles.api.di.modules.ApiModule;

import java.lang.reflect.Method;

/**
 * Created by Janek on 14.10.2016.
 */

class TestUtils {

    @SuppressWarnings("NewApi")
    static void resetModule() {
        Method m = null;
        try {
            m = ApiModule.class.getDeclaredMethod("reset");
            m.setAccessible(true);
            m.invoke(null);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }

    static void initializeCreatubblesApi() {
        CreatubblesApi.initialize(new Configuration.Builder()
                .clientSecret("secret")
                .clientId("id")
                .baseUrl("http://url.com")
                .application(new Application())
                .build());
    }

}
