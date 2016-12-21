package com.creatubbles.app;

import android.app.Application;

import com.creatubbles.api.Configuration;
import com.creatubbles.api.CreatubblesApi;
import com.creatubbles.api.Locale;

/**
 * Android Main Application
 */
public class CreatubblesApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        CreatubblesApi.initialize(new Configuration.Builder()
                .application(this)
                .baseUrl("https://staging.creatubbles.com/api/v2/")
                .clientId("274af44ed7c74b2daf680de6363fd9590800200c9a66483a81a0841d11e5a837")
                .clientSecret("a3b6ec42ce884f8eadadf5ddb9c7038c4062e707c29e4c27a44ff84c754a3485")
                .locale(Locale.ENGLISH)
                .build());
    }
}
