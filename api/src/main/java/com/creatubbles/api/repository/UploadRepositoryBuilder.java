package com.creatubbles.api.repository;

import com.creatubbles.api.Configuration;
import com.creatubbles.api.di.components.DaggerApiComponent;
import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.service.UploadService;

import javax.inject.Inject;

/**
 * Created by Mariusz Ostapowicz on 20.03.2016.
 */
public class UploadRepositoryBuilder {

    @Inject
    UploadService uploadService;

    @Inject
    Configuration configuration;

    public UploadRepository build() {
        DaggerApiComponent.builder().apiModule(ApiModule.getInstance()).build().inject(this);
        return new UploadRepositoryImpl(uploadService, configuration.getContext());
    }


}
