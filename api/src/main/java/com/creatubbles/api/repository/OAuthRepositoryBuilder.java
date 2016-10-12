package com.creatubbles.api.repository;

import com.creatubbles.api.Configuration;
import com.creatubbles.api.di.components.DaggerApiComponent;
import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.service.OAuthService;

import javax.inject.Inject;

public class OAuthRepositoryBuilder {


    @Inject
    OAuthService oAuthService;

    @Inject
    Configuration configuration;

    public OAuthRepository build() {
        DaggerApiComponent.builder().apiModule(ApiModule.getInstance()).build().inject(this);
        OAuthRepository oAuthRepository = new OAuthRepositoryImpl(oAuthService);
        oAuthRepository.setClientId(configuration.getClientId());
        oAuthRepository.setClientSecret(configuration.getClientSecret());
        return oAuthRepository;
    }

}
