package com.creatubbles.api.repository;

import com.creatubbles.api.di.components.DaggerApiComponent;
import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.model.AuthToken;
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
    ObjectMapper objectMapper;

    private final AuthToken authToken;

    public AvatarRepositoryBuilder(AuthToken authToken) {
        if (authToken == null) {
            throw new NullPointerException("AuthToken can't be null");
        }
        this.authToken = authToken;
    }

    public AvatarRepository build() {
        DaggerApiComponent.builder().apiModule(ApiModule.getInstance(authToken)).build()
                .inject(this);
        return new AvatarRepositoryImpl(objectMapper, userService);
    }
}
