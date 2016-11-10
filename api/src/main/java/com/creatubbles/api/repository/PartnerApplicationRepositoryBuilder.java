package com.creatubbles.api.repository;

import com.creatubbles.api.di.components.DaggerApiComponent;
import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.model.auth.AccessToken;
import com.creatubbles.api.service.PartnerApplicationService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;

/**
 * @author Pawel Szymanski
 */
public class PartnerApplicationRepositoryBuilder {

    private final AccessToken accessToken;
    @Inject
    PartnerApplicationService service;
    @Inject
    ObjectMapper objectMapper;

    public PartnerApplicationRepositoryBuilder(AccessToken accessToken) {
        if (accessToken == null) {
            throw new NullPointerException("accessToken can't be null!");
        }
        this.accessToken = accessToken;
    }

    public PartnerApplicationRepository build() {
        DaggerApiComponent.builder().apiModule(ApiModule.getInstance(accessToken))
                .build()
                .inject(this);
        return new PartnerApplicationRepositoryImpl(service, objectMapper);
    }
}
