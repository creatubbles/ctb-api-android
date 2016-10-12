package com.creatubbles.api.repository;

import com.creatubbles.api.di.components.DaggerApiComponent;
import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.model.AuthToken;
import com.creatubbles.api.service.LandingUrlsService;

import javax.inject.Inject;

/**
 * Created by Janek on 05.08.2016.
 */
public class LandingUrlsRepositoryBuilder {

    @Inject
    LandingUrlsService landingUrlsService;

    private AuthToken authToken;

    public LandingUrlsRepository build() {
        DaggerApiComponent.builder().apiModule(ApiModule.getInstance(authToken)).build()
                .inject(this);
        return new LandingUrlsRepositoryImpl(landingUrlsService);
    }


    public LandingUrlsRepositoryBuilder setAuthToken(AuthToken authToken) {
        this.authToken = authToken;
        return this;
    }

}
