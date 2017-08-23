package com.creatubbles.api.repository;

import android.support.annotation.NonNull;

import com.creatubbles.api.di.components.ApiComponent;
import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.model.auth.AccessToken;
import com.creatubbles.api.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;

/**
 * Created by Janek on 18.02.2016.
 */
public class UserRepositoryBuilder {

    @Inject
    UserService userService;

    @Inject
    ObjectMapper objectMapper;

    private final AccessToken accessToken;

    /**
     * <ul>
     * <li>With an application only access token you can only retrieve public data</li>
     * <li>With an user access token you can list users, and get all data this user has access to</li>
     * </ul>
     */
    public UserRepositoryBuilder(@NonNull AccessToken accessToken) {
        if (accessToken == null) {
            throw new NullPointerException("accessToken can't be null!");
        }
        this.accessToken = accessToken;
    }

    @NonNull
    public UserRepository build() {
        ApiComponent.getInstance(ApiModule.getInstance(accessToken)).inject(this);
        return new UserRepositoryImpl(objectMapper, userService);
    }

}
