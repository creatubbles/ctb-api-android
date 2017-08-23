package com.creatubbles.api.repository;

import android.support.annotation.NonNull;

import com.creatubbles.api.di.components.ApiComponent;
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
    public NotificationRepositoryBuilder(@NonNull AccessToken accessToken) {
        if (accessToken == null) {
            throw new NullPointerException("accessToken can't be null");
        }
        this.accessToken = accessToken;
    }

    @NonNull
    public NotificationRepository build() {
        ApiComponent.getInstance(ApiModule.getInstance(accessToken)).inject(this);
        return new NotificationRepositoryImpl(service, objectMapper);
    }
}
