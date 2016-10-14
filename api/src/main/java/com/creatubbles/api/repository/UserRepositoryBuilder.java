package com.creatubbles.api.repository;

import com.creatubbles.api.di.components.DaggerApiComponent;
import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.exception.InvalidParametersException;
import com.creatubbles.api.model.AuthToken;
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

    private AuthToken authToken;

    public UserRepository build() {
        if (hasValidParameters()) {
            DaggerApiComponent.builder().apiModule(ApiModule.getInstance(authToken)).build()
                    .inject(this);
            return new UserRepositoryImpl(objectMapper, userService);
        }
        throw new InvalidParametersException("Missing authorization token!");
    }

    public boolean hasValidParameters() {
        return authToken != null;
    }

    public UserRepositoryBuilder setAuthToken(AuthToken authToken) {
        this.authToken = authToken;
        return this;
    }
}
