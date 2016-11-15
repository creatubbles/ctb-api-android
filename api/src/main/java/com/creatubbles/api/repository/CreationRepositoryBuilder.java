package com.creatubbles.api.repository;

import com.creatubbles.api.di.components.DaggerApiComponent;
import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.model.auth.AccessToken;
import com.creatubbles.api.service.CreationService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;

/**
 * Created by Janek on 07.03.2016.
 */
public class CreationRepositoryBuilder {

    @Inject
    CreationService creationService;

    @Inject
    ObjectMapper objectMapper;

    private AccessToken accessToken;

    /**
     * <ul>
     * <li>With an application only access token you can only retrieve public data (public creations)</li>
     * <li>With an user access token you can list all owned creations, and get all data this user has access to</li>
     * </ul>
     */
    public CreationRepositoryBuilder(AccessToken accessToken) {
        if (accessToken == null) {
            throw new NullPointerException("accessToken can't be null!");
        }
        this.accessToken = accessToken;
    }

    public CreationRepository build() {
        DaggerApiComponent.builder().apiModule(ApiModule.getInstance(accessToken)).build()
                .inject(this);
        return new CreationRepositoryImpl(objectMapper, creationService);
    }

}
