package com.creatubbles.api.repository;

import com.creatubbles.api.di.components.DaggerApiComponent;
import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.model.AuthToken;
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

    private final AuthToken authToken;

    public AbilityRepositoryBuilder(AuthToken authToken) {
        if (authToken == null) {
            throw new NullPointerException("AuthToken can't be null");
        }
        this.authToken = authToken;
    }

    public AbilityRepository build() {
        DaggerApiComponent.builder().apiModule(ApiModule.getInstance(authToken)).build()
                .inject(this);
        return new AbilityRepositoryImpl(objectMapper, abilityService);
    }
}
