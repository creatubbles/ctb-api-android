package com.creatubbles.api.repository;

import com.creatubbles.api.di.components.DaggerApiComponent;
import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.model.auth.AccessToken;
import com.creatubbles.api.service.ContentService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;

public class ContentRepositoryBuilder {

    @Inject
    ContentService contentService;

    @Inject
    ObjectMapper objectMapper;

    private final AccessToken accessToken;

    /**
     * <ul>
     * <li>With an application only access token you can only retrieve public content</li>
     * <li>With an user access token you can retrieve public content (recent content only include non-private content from other users)</li>
     * </ul>
     */
    public ContentRepositoryBuilder(AccessToken accessToken) {
        if (accessToken == null) {
            throw new NullPointerException("accessToken can't be null");
        }
        this.accessToken = accessToken;
    }

    public ContentRepository build() {
        DaggerApiComponent.builder().apiModule(ApiModule.getInstance(accessToken)).build()
                .inject(this);
        return new ContentRepositoryImpl(objectMapper, contentService);
    }
}
