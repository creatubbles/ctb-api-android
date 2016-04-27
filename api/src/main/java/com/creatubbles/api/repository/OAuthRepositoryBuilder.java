package com.creatubbles.api.repository;

import android.content.Context;

import com.creatubbles.api.di.components.DaggerApiComponent;
import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.exception.InvalidParametersException;
import com.creatubbles.api.service.OAuthService;

import javax.inject.Inject;

public class OAuthRepositoryBuilder {


    @Inject
    OAuthService oAuthService;

    private String clientId;
    private String clientSecret;
    private Context context;

    public OAuthRepository build() throws InvalidParametersException {
        if (hasValidParameters()) {
            DaggerApiComponent.builder().apiModule(new ApiModule(context)).build().inject(this);
            OAuthRepository oAuthRepository = new OAuthRepositoryImpl(oAuthService);
            oAuthRepository.setClientId(clientId);
            oAuthRepository.setClientSecret(clientSecret);
            return oAuthRepository;
        }
        throw new InvalidParametersException("Missing application context, clientId or " +
                "clientSecret!");
    }


    private boolean hasValidParameters() {
        return clientId != null && clientSecret != null && context != null;
    }

    public OAuthRepositoryBuilder setClientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    public OAuthRepositoryBuilder setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
        return this;
    }

    public OAuthRepositoryBuilder setContext(Context context) {
        this.context = context;
        return this;
    }
}
