package com.creatubbles.api;

import android.support.annotation.NonNull;

import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.exception.InitializationException;

/**
 * Created by Janek on 11.10.2016.
 */

public final class CreatubblesApi {

    private static Configuration apiConfiguration = null;

    public static synchronized void initialize(@NonNull Configuration configuration) {
        if (configuration == null) {
            throw new NullPointerException("Configuration can't be null");
        }
        if (apiConfiguration != null) {
            throw new InitializationException("Can't initialize CreatubblesApi twice!");
        } else {
            apiConfiguration = configuration;
            ApiModule.initialize(apiConfiguration);
        }

    }

    public static void reset() {
        apiConfiguration = null;
    }
}
