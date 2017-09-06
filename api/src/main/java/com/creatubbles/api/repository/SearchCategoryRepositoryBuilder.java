package com.creatubbles.api.repository;

import android.support.annotation.NonNull;

import com.creatubbles.api.di.components.ApiComponent;
import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.model.auth.UserAccessToken;
import com.creatubbles.api.service.CategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;

public class SearchCategoryRepositoryBuilder {
    @Inject
    CategoryService categoryService;
    @Inject
    ObjectMapper objectMapper;

    private final UserAccessToken accessToken;

    public SearchCategoryRepositoryBuilder(@NonNull UserAccessToken accessToken) {
        if (accessToken == null) {
            throw new NullPointerException("accessToken can't be null");
        }
        this.accessToken = accessToken;
    }

    @NonNull
    public SearchCategoryRepository build() {
        ApiComponent.getInstance(ApiModule.getInstance(accessToken)).inject(this);
        return new SearchCategoryRepositoryImpl(categoryService, objectMapper);
    }
}
