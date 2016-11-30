package com.creatubbles.api.repository;

import android.support.annotation.NonNull;

import com.creatubbles.api.Configuration;
import com.creatubbles.api.di.components.DaggerApiComponent;
import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.service.UploadService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;

/**
 * Created by Mariusz Ostapowicz on 20.03.2016.
 */
public class UploadRepositoryBuilder {

    @Inject
    UploadService uploadService;

    @Inject
    Configuration configuration;

    @Inject
    ObjectMapper objectMapper;

    @NonNull
    public UploadRepository build() {
        DaggerApiComponent.builder().apiModule(ApiModule.getInstance()).build().inject(this);
        return new UploadRepositoryImpl(objectMapper, uploadService, configuration.getContext());
    }


}
