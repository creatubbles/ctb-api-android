package com.creatubbles.api.repository;

import android.support.annotation.NonNull;

import com.creatubbles.api.di.components.DaggerApiComponent;
import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.model.auth.AccessToken;
import com.creatubbles.api.service.BubbleService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;

/**
 * Class used to create an instance of {@link BubbleRepository}.
 *
 * @author Pawel Szymanski
 */
public class BubbleRepositoryBuilder {
    private final AccessToken accessToken;
    @Inject
    BubbleService service;
    @Inject
    ObjectMapper objectMapper;

    /**
     * User access token is required to create, update or delete a bubble.
     */
    public BubbleRepositoryBuilder(AccessToken accessToken) {
        if (accessToken == null) {
            throw new NullPointerException("accessToken can't be null");
        }
        this.accessToken = accessToken;
    }

    @NonNull
    public BubbleRepository build() {
        DaggerApiComponent.builder()
                .apiModule(ApiModule.getInstance(accessToken))
                .build()
                .inject(this);
        return new BubbleRepositoryImpl(service, objectMapper);
    }
}
