package com.creatubbles.app;

import android.app.Application;

import com.creatubbles.api.Configuration;
import com.creatubbles.api.CreatubblesApi;
import com.creatubbles.api.Locale;
import com.creatubbles.api.interceptor.ConsoleLogInterceptor;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Android Main Application
 */
public class CreatubblesApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        boolean isTablet = getResources().getBoolean(R.bool.is_tablet);
        CreatubblesApi.initialize(new Configuration.Builder()
                .application(this)
                .baseUrl("https://api.staging.creatubbles.com/")
                .clientId("54ddfc1b754637b9dc4f2e1e5fb34f8274d481c2cfc1de9df4fa74ef0f625f32") //ctboauthexample
                .clientSecret("41dbf6894b28e849e4ff2d29fe2ddf7f6dbef5fff5b4da39b5ff6545f05b5757") //ctboauthexample
                .clientCallbackUrl("ctboauthexample://testoauth")
                .locale(Locale.ENGLISH)
                .interceptor(ConsoleLogInterceptor.forLevel(HttpLoggingInterceptor.Level.BODY))
                .setClientDevice(isTablet ? Configuration.ClientDevice.TABLET : Configuration.ClientDevice.PHONE)
                .build());
    }
}
