package com.creatubbles.api.repository;

import android.support.annotation.NonNull;

import com.creatubbles.api.di.components.ApiComponent;
import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.model.auth.UserAccessToken;
import com.creatubbles.api.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;

/**
 * Class used to construct an instance of UserFollowingRepository.
 *
 * @author Pawel Szymanski
 */
public class UserFollowingRepositoryBuilder {

    @Inject
    UserService userService;
    @Inject
    ObjectMapper objectMapper;

    private final UserAccessToken accessToken;

    public UserFollowingRepositoryBuilder(@NonNull UserAccessToken accessToken) {
        if (accessToken == null) {
            throw new NullPointerException("accessToken can't be null");
        }
        this.accessToken = accessToken;
    }

    @NonNull
    public UserFollowingRepository build() {
        ApiComponent.getInstance(ApiModule.getInstance(accessToken)).inject(this);
        return new UserFollowingRepositoryImpl(userService, objectMapper);
    }

}
