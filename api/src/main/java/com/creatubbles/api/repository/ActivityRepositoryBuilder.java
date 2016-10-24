package com.creatubbles.api.repository;

import com.creatubbles.api.di.components.DaggerApiComponent;
import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.model.AuthToken;
import com.creatubbles.api.service.ActivityService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;

/**
 * @author Pawel Szymanski
 */
public class ActivityRepositoryBuilder {

    @Inject
    ActivityService activityService;

    @Inject
    ObjectMapper objectMapper;

    private final AuthToken authToken;

    public ActivityRepositoryBuilder(AuthToken authToken) {
        if (authToken == null) {
            throw new NullPointerException("AuthToken can't be null");
        }
        this.authToken = authToken;
    }

    public ActivityRepository build() {
        DaggerApiComponent.builder().apiModule(ApiModule.getInstance(authToken)).build()
                .inject(this);
        return new ActivityRepositoryImpl(objectMapper, activityService);
    }
}
