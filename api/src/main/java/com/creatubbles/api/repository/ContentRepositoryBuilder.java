package com.creatubbles.api.repository;

import com.creatubbles.api.di.components.DaggerApiComponent;
import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.model.auth.AccessToken;
import com.creatubbles.api.service.ContentService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;

/**
 * Created by Mario Ostapowicz on 28.10.2016.
 */

public class ContentRepositoryBuilder {

    @Inject
    ContentService contentService;

    @Inject
    ObjectMapper objectMapper;

    private final AccessToken accessToken;

    public ContentRepositoryBuilder(AccessToken accessToken) {
        if (accessToken == null) {
            throw new NullPointerException("accessToken can't be null");
        }
        this.accessToken = accessToken;
    }

    public ContentRepository build() {
        DaggerApiComponent.builder().apiModule(ApiModule.getInstance(accessToken)).build()
                .inject(this);
        return new ContentRepositoryImpl(objectMapper, contentService);
    }
}
