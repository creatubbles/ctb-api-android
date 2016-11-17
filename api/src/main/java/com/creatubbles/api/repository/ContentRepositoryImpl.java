package com.creatubbles.api.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.content.Content;
import com.creatubbles.api.response.JsonApiResponseMapper;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.ContentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import java.util.List;

import retrofit2.Call;

class ContentRepositoryImpl implements ContentRepository {

    private final ContentService contentService;
    private final ObjectMapper objectMapper;

    ContentRepositoryImpl(ObjectMapper objectMapper, ContentService contentService) {
        this.objectMapper = objectMapper;
        this.contentService = contentService;
    }

    @Override
    public void search(@NonNull String query, @Nullable Integer page, ResponseCallback<CreatubblesResponse<List<Content>>> callback) {
        Call<JSONAPIDocument<List<Content>>> call = contentService.getContents(page, query);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getRecent(@Nullable Integer page, ResponseCallback<CreatubblesResponse<List<Content>>> callback) {
        Call<JSONAPIDocument<List<Content>>> call = contentService.getRecent(page);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getTrending(@Nullable Integer page, ResponseCallback<CreatubblesResponse<List<Content>>> callback) {
        Call<JSONAPIDocument<List<Content>>> call = contentService.getTrending(page);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getConnected(@Nullable Integer page, ResponseCallback<CreatubblesResponse<List<Content>>> callback) {
        Call<JSONAPIDocument<List<Content>>> call = contentService.getConnected(page);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getFollowed(@Nullable Integer page, ResponseCallback<CreatubblesResponse<List<Content>>> callback) {
        Call<JSONAPIDocument<List<Content>>> call = contentService.getFollowed(page);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getByUser(@Nullable Integer page, @NonNull String userId, ResponseCallback<CreatubblesResponse<List<Content>>> callback) {
        Call<JSONAPIDocument<List<Content>>> call = contentService.getByUser(userId, page);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getBubbledByUser(@Nullable Integer page, @NonNull String userId, ResponseCallback<CreatubblesResponse<List<Content>>> callback) {
        Call<JSONAPIDocument<List<Content>>> call = contentService.getBubbledByUser(userId, page);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }
}