package com.creatubbles.api.repository;

import com.creatubbles.api.di.components.DaggerApiComponent;
import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.exception.InvalidParametersException;
import com.creatubbles.api.model.AuthToken;
import com.creatubbles.api.service.CreationService;

import javax.inject.Inject;

/**
 * Created by Janek on 07.03.2016.
 */
public class CreationRepositoryBuilder {

    @Inject
    CreationService creationService;

    private AuthToken authToken;

    public CreationRepository build() {
        if (hasValidParameters()) {
            DaggerApiComponent.builder().apiModule(ApiModule.getInstance(authToken)).build()
                    .inject(this);
            return new CreationRepositoryImpl(creationService);
        }
        throw new InvalidParametersException("Missing authorization token!");
    }

    private boolean hasValidParameters() {
        return authToken != null;
    }

    public CreationRepositoryBuilder setAuthToken(AuthToken authToken) {
        this.authToken = authToken;
        return this;
    }

}
