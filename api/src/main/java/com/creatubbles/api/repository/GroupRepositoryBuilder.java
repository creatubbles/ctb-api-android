package com.creatubbles.api.repository;

import android.support.annotation.NonNull;

import com.creatubbles.api.di.components.ApiComponent;
import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.model.auth.UserAccessToken;
import com.creatubbles.api.service.GroupService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;

/**
 * Class used to create an instance of {@link GroupRepository}.
 *
 * @author Pawel Szymanski
 */
public class GroupRepositoryBuilder {

    private final UserAccessToken accessToken;
    @Inject
    GroupService service;
    @Inject
    ObjectMapper objectMapper;

    /**
     * GroupRepository requires {@link com.creatubbles.api.model.auth.UserAccessToken}.
     */
    public GroupRepositoryBuilder(@NonNull UserAccessToken accessToken) {
        if (accessToken == null) {
            throw new NullPointerException("accessToken can't be null");
        }
        this.accessToken = accessToken;
    }

    @NonNull
    public GroupRepository build() {
        ApiComponent.getInstance(ApiModule.getInstance(accessToken)).inject(this);
        return new GroupRepositoryImpl(service, objectMapper);
    }
}
