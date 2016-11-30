package com.creatubbles.api.repository;

import android.support.annotation.NonNull;

import com.creatubbles.api.di.components.DaggerApiComponent;
import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.model.auth.UserAccessToken;
import com.creatubbles.api.service.ReportService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;

/**
 * @author Pawel Szymanski
 */
public class ReportRepositoryBuilder {

    private final UserAccessToken accessToken;

    @Inject
    ReportService service;
    @Inject
    ObjectMapper mapper;

    public ReportRepositoryBuilder(UserAccessToken accessToken) {
        if (accessToken == null) {
            throw new NullPointerException("accessToken can't be null");
        }
        this.accessToken = accessToken;
    }

    @NonNull
    public ReportRepository build() {
        DaggerApiComponent.builder()
                .apiModule(ApiModule.getInstance(accessToken))
                .build()
                .inject(this);
        return new ReportRepositoryImpl(service, mapper);
    }
}

