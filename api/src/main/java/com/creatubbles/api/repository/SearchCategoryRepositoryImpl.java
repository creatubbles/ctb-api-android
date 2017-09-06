package com.creatubbles.api.repository;

import android.support.annotation.Nullable;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.search.SearchCategory;
import com.creatubbles.api.response.JsonApiResponseMapper;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.CategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import java.util.List;

import retrofit2.Call;

class SearchCategoryRepositoryImpl implements SearchCategoryRepository {
    private final CategoryService service;
    private final ObjectMapper objectMapper;

    SearchCategoryRepositoryImpl(CategoryService service, ObjectMapper objectMapper) {
        this.service = service;
        this.objectMapper = objectMapper;
    }

    @Override
    public void getCategories(@Nullable Integer page, @Nullable ResponseCallback<CreatubblesResponse<List<SearchCategory>>> callback) {
        Call<JSONAPIDocument<List<SearchCategory>>> call = service.getCategories(page);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }
}
