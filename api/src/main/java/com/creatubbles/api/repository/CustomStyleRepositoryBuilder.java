package com.creatubbles.api.repository;

import com.creatubbles.api.di.components.DaggerApiComponent;
import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.exception.InvalidParametersException;
import com.creatubbles.api.model.AuthToken;
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

    private AuthToken authToken;

    public CustomStyleRepository build() {
        if (hasValidParameters()) {
            DaggerApiComponent.builder().apiModule(ApiModule.getInstance(authToken)).build()
                    .inject(this);
            return new CustomStyleRepositoryImpl(objectMapper, customStyleService);
        }
        throw new InvalidParametersException("Missing authorization token!");
    }

    public boolean hasValidParameters() {
        return authToken != null;
    }

    public CustomStyleRepositoryBuilder setAuthToken(AuthToken authToken) {
        this.authToken = authToken;
        return this;
    }
}
