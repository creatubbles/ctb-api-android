package com.creatubbles.api;

import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.exception.InvalidParametersException;

/**
 * Created by Janek on 11.10.2016.
 */

public final class CreatubblesApi {

    private static Configuration apiConfiguration = null;

    public static void initialize(Configuration configuration) {
        if (apiConfiguration == null) {
            apiConfiguration = configuration;
            ApiModule.initialize(apiConfiguration);
        } else {
            throw new InvalidParametersException("Can't initialize CreatubblesApi twice!");
        }

    }
}
