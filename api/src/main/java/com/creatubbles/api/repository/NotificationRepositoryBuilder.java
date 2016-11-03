package com.creatubbles.api.repository;

import com.creatubbles.api.di.components.DaggerApiComponent;
import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.model.AuthToken;
import com.creatubbles.api.service.NotificationService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;

/**
 * @author Pawel Szymanski
 */
public class NotificationRepositoryBuilder {

    private final AuthToken authToken;
    @Inject
    NotificationService service;
    @Inject
    ObjectMapper objectMapper;

    public NotificationRepositoryBuilder(AuthToken authToken) {
        if (authToken == null) {
            throw new NullPointerException("authToken can't be null");
        }
        this.authToken = authToken;
    }

    public NotificationRepository build() {
        DaggerApiComponent.builder()
                .apiModule(ApiModule.getInstance(authToken))
                .build()
                .inject(this);
        return new NotificationRepositoryImpl(service, objectMapper);
    }
}
