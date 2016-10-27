package com.creatubbles.api.repository;

import com.creatubbles.api.di.components.DaggerApiComponent;
import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.model.AuthToken;
import com.creatubbles.api.service.GroupService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;

/**
 * Class used to create an instance of {@link GroupRepository}.
 *
 * @author Pawel Szymanski
 */
public class GroupRepositoryBuilder {

    private final AuthToken authToken;
    @Inject
    GroupService service;
    @Inject
    ObjectMapper objectMapper;

    /**
     * @param authToken instance of user access token.
     */
    public GroupRepositoryBuilder(AuthToken authToken) {
        if (authToken == null) {
            throw new NullPointerException("authToken can't be null");
        }
        this.authToken = authToken;
    }

    public GroupRepository build() {
        DaggerApiComponent.builder()
                .apiModule(ApiModule.getInstance(authToken))
                .build()
                .inject(this);
        return new GroupRepositoryImpl(service, objectMapper);
    }
}
