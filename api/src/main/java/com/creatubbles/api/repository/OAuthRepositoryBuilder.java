package com.creatubbles.api.repository;

import android.support.annotation.NonNull;

import com.creatubbles.api.Configuration;
import com.creatubbles.api.di.components.ApiComponent;
import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.service.OAuthService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;

public class OAuthRepositoryBuilder {


    @Inject
    OAuthService oAuthService;

    @Inject
    Configuration configuration;

    @Inject
    ObjectMapper objectMapper;


    @NonNull
    public OAuthRepository build() {
        ApiComponent.getInstance(ApiModule.getInstance()).inject(this);
        OAuthRepository oAuthRepository = new OAuthRepositoryImpl(objectMapper, oAuthService);
        oAuthRepository.setClientId(configuration.getClientId());
        oAuthRepository.setClientSecret(configuration.getClientSecret());
        oAuthRepository.setClientCallbackUrl(configuration.getClientCallbackUrl());
        return oAuthRepository;
    }

}
