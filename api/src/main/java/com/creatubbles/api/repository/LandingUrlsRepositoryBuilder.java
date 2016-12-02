package com.creatubbles.api.repository;

import android.support.annotation.NonNull;

import com.creatubbles.api.di.components.DaggerApiComponent;
import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.model.auth.AccessToken;
import com.creatubbles.api.service.LandingUrlsService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;

/**
 * Created by Janek on 05.08.2016.
 */
public class LandingUrlsRepositoryBuilder {

    @Inject
    LandingUrlsService landingUrlsService;

    @Inject
    ObjectMapper objectMapper;

    private AccessToken accessToken;

    /**
     * <ul>
     * <li>With an application only access token you get the common landing URLs.
     * Use this to retrieve the common landing URLs before a user has signed in.</li>
     * <li>With an user access token you get user specific landing URLs.</li>
     * </ul>
     */
    public LandingUrlsRepositoryBuilder(AccessToken accessToken) {
        if (accessToken == null) {
            throw new NullPointerException("accessToken can't be null!");
        }
        this.accessToken = accessToken;
    }

    @NonNull
    public LandingUrlsRepository build() {
        DaggerApiComponent.builder().apiModule(ApiModule.getInstance(accessToken)).build()
                .inject(this);
        return new LandingUrlsRepositoryImpl(objectMapper, landingUrlsService);
    }

}
