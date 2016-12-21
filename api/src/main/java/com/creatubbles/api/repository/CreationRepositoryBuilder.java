package com.creatubbles.api.repository;

import android.os.Handler;
import android.support.annotation.NonNull;

import com.creatubbles.api.di.components.DaggerApiComponent;
import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.model.auth.AccessToken;
import com.creatubbles.api.service.CreationService;
import com.creatubbles.api.service.UploadService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Inject;

/**
 * Created by Janek on 07.03.2016.
 */
public class CreationRepositoryBuilder {

    @Inject
    CreationService creationService;

    @Inject
    ObjectMapper objectMapper;

    @Inject
    UploadService uploadService;

    private AccessToken accessToken;

    /**
     * <ul>
     * <li>With an application only access token you can only retrieve public data (public creations)</li>
     * <li>With an user access token you can list all owned creations, and get all data this user has access to</li>
     * </ul>
     */
    public CreationRepositoryBuilder(@NonNull AccessToken accessToken) {
        if (accessToken == null) {
            throw new NullPointerException("accessToken can't be null!");
        }
        this.accessToken = accessToken;
    }

    @NonNull
    public CreationRepository build() {
        DaggerApiComponent.builder().apiModule(ApiModule.getInstance(accessToken)).build()
                .inject(this);

        Executor uploadAsyncExecutor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler();
        Executor uploadCallbackExecutor = handler::post;
        return new CreationRepositoryImpl(objectMapper, creationService, uploadService,
                uploadAsyncExecutor, uploadCallbackExecutor);
    }

}
