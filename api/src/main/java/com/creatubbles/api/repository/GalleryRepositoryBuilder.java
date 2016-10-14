package com.creatubbles.api.repository;

import com.creatubbles.api.di.components.DaggerApiComponent;
import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.exception.InvalidParametersException;
import com.creatubbles.api.model.AuthToken;
import com.creatubbles.api.service.GalleryService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;

/**
 * Created by Janek on 07.03.2016.
 */
public class GalleryRepositoryBuilder {


    @Inject
    GalleryService galleryService;

    @Inject
    ObjectMapper objectMapper;

    private AuthToken authToken;

    public GalleryRepository build() {
        if (hasValidParameters()) {
            DaggerApiComponent.builder().apiModule(ApiModule.getInstance(authToken)).build()
                    .inject(this);
            return new GalleryRepositoryImpl(objectMapper, galleryService);
        }
        throw new InvalidParametersException("Missing application authorization token!");
    }

    public boolean hasValidParameters() {
        return authToken != null;
    }

    public GalleryRepositoryBuilder setAuthToken(AuthToken authToken) {
        this.authToken = authToken;
        return this;
    }

}



