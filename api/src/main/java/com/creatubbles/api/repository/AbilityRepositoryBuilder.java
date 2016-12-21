package com.creatubbles.api.repository;

import android.support.annotation.NonNull;

import com.creatubbles.api.di.components.DaggerApiComponent;
import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.model.auth.UserAccessToken;
import com.creatubbles.api.service.AbilityService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;

/**
 * Created by Janek on 04.11.2016.
 */

public class AbilityRepositoryBuilder {

    @Inject
    AbilityService abilityService;

    @Inject
    ObjectMapper objectMapper;

    private final UserAccessToken accessToken;

    public AbilityRepositoryBuilder(@NonNull UserAccessToken accessToken) {
        if (accessToken == null) {
            throw new NullPointerException("accessToken can't be null");
        }
        this.accessToken = accessToken;
    }

    @NonNull
    public AbilityRepository build() {
        DaggerApiComponent.builder().apiModule(ApiModule.getInstance(accessToken)).build()
                .inject(this);
        return new AbilityRepositoryImpl(objectMapper, abilityService);
    }
}
