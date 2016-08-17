package com.creatubbles.api.repository;

import android.content.Context;

import com.creatubbles.api.di.components.DaggerApiComponent;
import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.exception.InvalidParametersException;
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
    private Context context;

    public LandingUrlsRepository build() {
        if (context != null) {
            if (authToken != null) {
                DaggerApiComponent.builder().apiModule(new ApiModule(context, authToken)).build()
                        .inject(this);
            } else {
                DaggerApiComponent.builder().apiModule(new ApiModule(context)).build()
                        .inject(this);
            }
            return new LandingUrlsRepositoryImpl(landingUrlsService);
        }
        throw new InvalidParametersException("Missing application context!");
    }


    public LandingUrlsRepositoryBuilder setAuthToken(AuthToken authToken) {
        this.authToken = authToken;
        return this;
    }

    public LandingUrlsRepositoryBuilder setContext(Context context) {
        this.context = context;
        return this;
    }
}
