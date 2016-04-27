package com.creatubbles.api.repository;

import android.content.Context;

import com.creatubbles.api.di.components.DaggerApiComponent;
import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.exception.InvalidParametersException;
import com.creatubbles.api.model.AuthToken;
import com.creatubbles.api.service.GalleryService;

import javax.inject.Inject;

/**
 * Created by Janek on 07.03.2016.
 */
public class GalleryRepositoryBuilder {


    @Inject
    GalleryService galleryService;

    private AuthToken authToken;
    private Context context;

    public GalleryRepository build() {
        if (hasValidParameters()) {
            DaggerApiComponent.builder().apiModule(new ApiModule(context, authToken)).build()
                    .inject(this);
            GalleryRepository galleryRepository = new GalleryRepositoryImpl(galleryService);
            return galleryRepository;
        }
        throw new InvalidParametersException("Missing application context or authorization token!");
    }

    public boolean hasValidParameters() {
        return authToken != null && context != null;
    }

    public GalleryRepositoryBuilder setAuthToken(AuthToken authToken) {
        this.authToken = authToken;
        return this;
    }

    public GalleryRepositoryBuilder setContext(Context context) {
        this.context = context;
        return this;
    }
}



