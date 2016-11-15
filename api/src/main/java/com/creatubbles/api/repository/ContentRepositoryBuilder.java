package com.creatubbles.api.repository;

import com.creatubbles.api.di.components.DaggerApiComponent;
import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.model.AuthToken;
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

    private final AuthToken authToken;

    public ContentRepositoryBuilder(AuthToken authToken) {
        if (authToken == null) {
            throw new NullPointerException("AuthToken can't be null");
        }
        this.authToken = authToken;
    }

    public ContentRepository build() {
        DaggerApiComponent.builder().apiModule(ApiModule.getInstance(authToken)).build()
                .inject(this);
        return new ContentRepositoryImpl(objectMapper, contentService);
    }
}
