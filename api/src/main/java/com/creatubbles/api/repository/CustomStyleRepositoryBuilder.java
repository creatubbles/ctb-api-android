package com.creatubbles.api.repository;

import android.support.annotation.NonNull;

import com.creatubbles.api.di.components.DaggerApiComponent;
import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.model.auth.AccessToken;
import com.creatubbles.api.service.CustomStyleService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;

/**
 * Created by Janek on 21.10.2016.
 */

public class CustomStyleRepositoryBuilder {

    @Inject
    CustomStyleService customStyleService;

    @Inject
    ObjectMapper objectMapper;

    private final AccessToken accessToken;

    /**
     * Either user or application access token is required.
     */
    public CustomStyleRepositoryBuilder(@NonNull AccessToken accessToken) {
        if (accessToken == null) {
            throw new NullPointerException("accessToken can't be null!");
        }
        this.accessToken = accessToken;
    }

    @NonNull
    public CustomStyleRepository build() {
        DaggerApiComponent.builder().apiModule(ApiModule.getInstance(accessToken)).build()
                .inject(this);
        return new CustomStyleRepositoryImpl(objectMapper, customStyleService);
    }

}
