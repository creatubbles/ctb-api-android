package com.creatubbles.api.repository;

import android.support.annotation.NonNull;

import com.creatubbles.api.di.components.DaggerApiComponent;
import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.model.auth.AccessToken;
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

    private final AccessToken accessToken;

    /**
     * Access Restrictions:
     * <ul>
     * <li>With an application only access token you’ll retrieve public activity.</li>
     * <li>With an user access token you’ll retrieve activity geared towards this user.</li>
     * </ul>
     */
    public ActivityRepositoryBuilder(@NonNull AccessToken accessToken) {
        if (accessToken == null) {
            throw new NullPointerException("accessToken can't be null");
        }
        this.accessToken = accessToken;
    }

    @NonNull
    public ActivityRepository build() {
        DaggerApiComponent.builder().apiModule(ApiModule.getInstance(accessToken)).build()
                .inject(this);
        return new ActivityRepositoryImpl(objectMapper, activityService);
    }
}
