package com.creatubbles.api.repository;

import android.support.annotation.NonNull;

import com.creatubbles.api.di.components.ApiComponent;
import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.model.auth.AccessToken;
import com.creatubbles.api.service.SchoolService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;

/**
 * @author Pawel Szymanski
 */
public class SchoolRepositoryBuilder {
    @Inject
    SchoolService service;
    @Inject
    ObjectMapper objectMapper;

    private final AccessToken accessToken;

    /**
     * With an application only access token you get the published schools.
     */
    public SchoolRepositoryBuilder(@NonNull AccessToken accessToken) {
        if (accessToken == null) {
            throw new NullPointerException("accessToken can't be null");
        }
        this.accessToken = accessToken;
    }

    @NonNull
    public SchoolRepository build() {
        ApiComponent.getInstance(ApiModule.getInstance(accessToken)).inject(this);
        return new SchoolRepositoryImpl(service, objectMapper);
    }
}
