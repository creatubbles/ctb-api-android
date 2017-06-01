package com.creatubbles.api.repository;

import com.creatubbles.api.Configuration;
import com.creatubbles.api.ContentType;
import com.creatubbles.api.ServiceGenerator;
import com.creatubbles.api.di.components.DaggerApiComponent;
import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.model.auth.AccessToken;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;

/**
 * This is meant for internal use only.
 */
public class PrivateRepositoryDependencyProvider {

    @Inject
    Configuration configuration;

    @Inject
    ObjectMapper objectMapper;

    @Inject
    ServiceGenerator serviceGenerator;


    public PrivateRepositoryDependencyProvider() {
        DaggerApiComponent.builder().apiModule(ApiModule.getInstance()).build().inject(this);
    }

    public Configuration provideConfiguration() {
        return configuration;
    }

    public ObjectMapper provideObjectMapper() {
        return objectMapper;
    }

    public <S> S provideService(Class<S> serviceClass, final ContentType contentType, AccessToken accessToken) {
        return serviceGenerator.createService(serviceClass, contentType, accessToken);
    }

    public <S> S provideService(Class<S> serviceClass, final ContentType contentType) {
        return serviceGenerator.createService(serviceClass, contentType);
    }

    public <S> S provideService(Class<S> serviceClass) {
        return serviceGenerator.createService(serviceClass);
    }
}
