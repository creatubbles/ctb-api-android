package com.creatubbles.api.repository;

import com.creatubbles.api.di.components.DaggerApiComponent;
import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.model.AuthToken;
import com.creatubbles.api.service.BubbleService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;

/**
 * Class used to create an instance of {@link BubbleRepository}.
 *
 * @author Pawel Szymanski
 */
public class BubbleRepositoryBuilder {
    private final AuthToken authToken;
    @Inject
    BubbleService service;
    @Inject
    ObjectMapper objectMapper;

    public BubbleRepositoryBuilder(AuthToken authToken) {
        if (authToken == null) {
            throw new NullPointerException("authToken can't be null");
        }
        this.authToken = authToken;
    }

    public BubbleRepository build() {
        DaggerApiComponent.builder()
                .apiModule(ApiModule.getInstance(authToken))
                .build()
                .inject(this);
        return new BubbleRepositoryImpl(service, objectMapper);
    }
}
