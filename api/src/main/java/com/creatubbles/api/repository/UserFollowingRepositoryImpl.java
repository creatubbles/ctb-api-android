package com.creatubbles.api.repository;

import android.support.annotation.NonNull;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.user.UserFollowing;
import com.creatubbles.api.response.BaseResponseMapper;
import com.creatubbles.api.response.JsonApiResponseMapper;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import retrofit2.Call;

/**
 * @author Pawel Szymanski
 */
public class UserFollowingRepositoryImpl implements UserFollowingRepository {

    private final UserService userService;
    private final ObjectMapper objectMapper;

    UserFollowingRepositoryImpl(UserService userService, ObjectMapper objectMapper) {
        this.userService = userService;
        this.objectMapper = objectMapper;
    }

    @Override
    public void follow(@NonNull String userId, ResponseCallback<CreatubblesResponse<UserFollowing>> callback) {
        Call<JSONAPIDocument<UserFollowing>> call = userService.postFollowing(userId);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void unfollow(@NonNull String userId, ResponseCallback<Void> callback) {
        Call<Void> call = userService.deleteFollowing(userId);
        call.enqueue(new BaseResponseMapper<>(objectMapper, callback));
    }
}
