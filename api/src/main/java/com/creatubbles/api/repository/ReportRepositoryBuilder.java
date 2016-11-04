package com.creatubbles.api.repository;

import com.creatubbles.api.di.components.DaggerApiComponent;
import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.model.AuthToken;
import com.creatubbles.api.service.ReportService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;

/**
 * @author Pawel Szymanski
 */
public class ReportRepositoryBuilder {

    private final AuthToken authToken;

    @Inject
    ReportService service;
    @Inject
    ObjectMapper mapper;

    public ReportRepositoryBuilder(AuthToken authToken) {
        if (authToken == null) {
            throw new NullPointerException("authToken can't be null");
        }
        this.authToken = authToken;
    }

    public ReportRepository build() {
        DaggerApiComponent.builder()
                .apiModule(ApiModule.getInstance(authToken))
                .build()
                .inject(this);
        return new ReportRepositoryImpl(service, mapper);
    }
}

