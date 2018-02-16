package com.creatubbles.api.repository;

import android.support.annotation.NonNull;

import com.creatubbles.api.di.components.ApiComponent;
import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.model.auth.UserAccessToken;
import com.creatubbles.api.service.HashtagService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;

public class HashtagRepositoryBuilder {
    private final UserAccessToken accessToken;
    @Inject
    HashtagService service;
    @Inject
    ObjectMapper objectMapper;

    /**
     * GroupRepository requires {@link com.creatubbles.api.model.auth.UserAccessToken}.
     */
    public HashtagRepositoryBuilder(@NonNull UserAccessToken accessToken) {
        if (accessToken == null) {
            throw new NullPointerException("accessToken can't be null");
        }
        this.accessToken = accessToken;
    }

    @NonNull
    public HashtagRepository build() {
        ApiComponent.getInstance(ApiModule.getInstance(accessToken)).inject(this);
        return new HashtagRepositoryImpl(service, objectMapper);
    }
}
