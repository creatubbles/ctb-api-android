package com.creatubbles.api.repository;

import com.creatubbles.api.di.components.DaggerApiComponent;
import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.model.auth.AccessToken;
import com.creatubbles.api.service.NotificationService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;

/**
 * @author Pawel Szymanski
 */
public class NotificationRepositoryBuilder {

    private final AccessToken accessToken;
    @Inject
    NotificationService service;
    @Inject
    ObjectMapper objectMapper;

    /**
     * <ul>
     * <li>With an application only access token you can’t retrieve any notifications data</li>
     * <li>With an user access token you can get all notifications addressed to this user</li>
     * </ul>
     */
    public NotificationRepositoryBuilder(AccessToken accessToken) {
        if (accessToken == null) {
            throw new NullPointerException("accessToken can't be null");
        }
        this.accessToken = accessToken;
    }

    public NotificationRepository build() {
        DaggerApiComponent.builder()
                .apiModule(ApiModule.getInstance(accessToken))
                .build()
                .inject(this);
        return new NotificationRepositoryImpl(service, objectMapper);
    }
}
