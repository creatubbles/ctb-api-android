package com.creatubbles.api.repository;

import android.support.annotation.NonNull;

import com.creatubbles.api.di.components.ApiComponent;
import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.model.auth.UserAccessToken;
import com.creatubbles.api.service.AvatarService;
import com.creatubbles.api.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;

/**
 * Created by Janek on 26.10.2016.
 */

public class AvatarRepositoryBuilder {

    @Inject
    UserService userService;

    @Inject
    AvatarService avatarService;

    @Inject
    ObjectMapper objectMapper;

    private final UserAccessToken authToken;

    public AvatarRepositoryBuilder(@NonNull UserAccessToken accessToken) {
        if (accessToken == null) {
            throw new NullPointerException("accessToken can't be null");
        }
        this.authToken = accessToken;
    }

    @NonNull
    public AvatarRepository build() {
        ApiComponent.getInstance(ApiModule.getInstance(authToken)).inject(this);
        return new AvatarRepositoryImpl(objectMapper, userService, avatarService);
    }
}
