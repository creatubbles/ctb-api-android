package com.creatubbles.api.repository;

import com.creatubbles.api.di.components.DaggerApiComponent;
import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.model.auth.AccessToken;
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

    private AccessToken accessToken;

    /**
     * <ul>
     * <li>With an application only access token you can only retrieve public galleries (public and non-empty galleries)</li>
     * <li>With an user access token you can list public galleries and the all galleries which belong to the user, including empty ones.</li>
     * </ul>
     */
    public GalleryRepositoryBuilder(AccessToken accessToken) {
        if (accessToken == null) {
            throw new NullPointerException("accessToken can't be null!");
        }
        this.accessToken = accessToken;
    }

    public GalleryRepository build() {
        DaggerApiComponent.builder().apiModule(ApiModule.getInstance(accessToken)).build()
                .inject(this);
        return new GalleryRepositoryImpl(objectMapper, galleryService);
    }

}



