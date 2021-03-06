package com.creatubbles.api.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.Following;
import com.creatubbles.api.model.hashtag.Hashtag;
import com.creatubbles.api.model.user.User;
import com.creatubbles.api.response.JsonApiResponseMapper;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.response.SameResponseMapper;
import com.creatubbles.api.service.HashtagService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

class HashtagRepositoryImpl implements HashtagRepository {

    private HashtagService hashtagService;
    private ObjectMapper objectMapper;

    public HashtagRepositoryImpl(HashtagService hashtagService, ObjectMapper objectMapper) {
        this.hashtagService = hashtagService;
        this.objectMapper = objectMapper;
    }

    @Override
    public void getDetails(@NonNull String hashTag, @Nullable ResponseCallback<CreatubblesResponse<Hashtag>> callback) {
        hashtagService.get(hashTag).enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void follow(@NonNull String hashTag, @Nullable ResponseCallback<CreatubblesResponse<Following>> callback) {
        hashtagService.postFollow(hashTag).enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void unFollow(@NonNull String hashTag, @Nullable ResponseCallback<Void> callback) {
        hashtagService.deleteFollow(hashTag).enqueue(new SameResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getSuggested(@Nullable Integer page, @Nullable ResponseCallback<CreatubblesResponse<List<Hashtag>>> callback) {
        hashtagService.getSuggested(page).enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getFollowers(@NonNull String hashTag, @Nullable Integer page, @Nullable String query, @Nullable ResponseCallback<CreatubblesResponse<List<User>>> callback) {
        hashtagService.getFollowers(hashTag, page, query).enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getPopular(@Nullable String nameFilter, @Nullable Integer page, int perPage, @Nullable ResponseCallback<CreatubblesResponse<List<Hashtag>>> callback) {
        hashtagService.getPopular(nameFilter, page, perPage).enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }
}
