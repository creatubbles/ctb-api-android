package com.creatubbles.api.repository;

import android.content.Context;
import android.text.TextUtils;

import com.creatubbles.api.EndPoints;
import com.creatubbles.api.di.components.DaggerApiComponent;
import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.exception.InvalidParametersException;
import com.creatubbles.api.service.OAuthService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;

public class OAuthRepositoryBuilder {


    @Inject
    OAuthService oAuthService;

    @Inject
    ObjectMapper objectMapper;

    private String clientId;
    private String clientSecret;
    private Context context;

    public OAuthRepository build() {
        if (hasValidParameters()) {
            EndPoints.SET_STAGING = false;
            EndPoints.URL_BASE_STAGING = null;
            DaggerApiComponent.builder().apiModule(new ApiModule(context)).build().inject(this);
            OAuthRepository oAuthRepository = new OAuthRepositoryImpl(objectMapper, oAuthService);
            oAuthRepository.setClientId(clientId);
            oAuthRepository.setClientSecret(clientSecret);
            return oAuthRepository;
        }
        throw new InvalidParametersException("Missing application context, clientId or " +
                "clientSecret!");
    }

    public OAuthRepository build(String stagingUrl) {
        if (hasValidParameters() && stagingUrl != null && !TextUtils.isEmpty(stagingUrl)) {
            EndPoints.SET_STAGING = true;
            EndPoints.URL_BASE_STAGING = stagingUrl;
            DaggerApiComponent.builder().apiModule(new ApiModule(context)).build().inject(this);
            OAuthRepository oAuthRepository = new OAuthRepositoryImpl(objectMapper, oAuthService);
            oAuthRepository.setClientId(clientId);
            oAuthRepository.setClientSecret(clientSecret);
            return oAuthRepository;
        }
        throw new InvalidParametersException("Missing application context, clientId, clientSecret" +
                " or server URL!");
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
