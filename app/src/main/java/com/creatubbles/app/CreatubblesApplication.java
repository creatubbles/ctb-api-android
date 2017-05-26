package com.creatubbles.app;

import android.app.Application;

import com.creatubbles.api.Configuration;
import com.creatubbles.api.CreatubblesApi;
import com.creatubbles.api.Locale;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Android Main Application
 */
public class CreatubblesApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        CreatubblesApi.initialize(new Configuration.Builder()
                .application(this)
                .baseUrl("https://api.staging.creatubbles.com/v2/")
                .clientId("acbf03d5084f0d97159587e819e27b688a19b313b93db09c19f72ee1577b244d") //ctboauthexample
                .clientSecret("4d666d5bb0f1bf5fec5efa31e2484cd11e2a57c0904d033506561b45a94d7ef0") //ctboauthexample
                .clientCallbackUrl("ctboauthexample://testoauth")
                .locale(Locale.ENGLISH)
                .httpLogLevel(HttpLoggingInterceptor.Level.BODY)
                .build());
    }
}
