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
                .baseUrl("baseUrl")
                .clientId("clientId")
                .clientSecret("clientSecret")
                .locale(Locale.JAPANESE)
                .build());
    }
}
