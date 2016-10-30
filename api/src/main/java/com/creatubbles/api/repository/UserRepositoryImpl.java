package com.creatubbles.api.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.user.MultipleCreators;
import com.creatubbles.api.model.user.NewUser;
import com.creatubbles.api.model.user.User;
import com.creatubbles.api.response.JsonApiResponseMapper;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import java.util.List;

import retrofit2.Call;

/**
 * Created by Janek on 18.02.2016.
 */
class UserRepositoryImpl implements UserRepository {

    private UserService userService;
    private ObjectMapper objectMapper;

    UserRepositoryImpl(ObjectMapper objectMapper, UserService service) {
        this.objectMapper = objectMapper;
        this.userService = service;
    }

    @Override
    public void getUser(@NonNull String id, ResponseCallback<CreatubblesResponse<User>> callback) {
        Call<JSONAPIDocument<User>> call = userService.getUserById(id);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getUser(ResponseCallback<CreatubblesResponse<User>> callback) {
        Call<JSONAPIDocument<User>> call = userService.getUserById(CURRENT_USER);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getCreators(@Nullable Integer page, ResponseCallback<CreatubblesResponse<List<User>>> callback) {
        Call<JSONAPIDocument<List<User>>> call = userService.getCreators(CURRENT_USER, page);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getManagers(@Nullable Integer page, ResponseCallback<CreatubblesResponse<List<User>>> callback) {
        Call<JSONAPIDocument<List<User>>> call = userService.getManagers(CURRENT_USER, page);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getConnections(@Nullable Integer page, ResponseCallback<CreatubblesResponse<List<User>>> callback) {
        Call<JSONAPIDocument<List<User>>> call = userService.getConnections(CURRENT_USER, page);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getFollowedUsers(@Nullable Integer page, ResponseCallback<CreatubblesResponse<List<User>>> callback) {
        Call<JSONAPIDocument<List<User>>> call = userService.getFollowedUsers(CURRENT_USER, page);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getCreators(@NonNull String userId, @Nullable Integer page, ResponseCallback<CreatubblesResponse<List<User>>> callback) {
        Call<JSONAPIDocument<List<User>>> call = userService.getCreators(userId, page);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getManagers(@NonNull String userId, @Nullable Integer page, ResponseCallback<CreatubblesResponse<List<User>>> callback) {
        Call<JSONAPIDocument<List<User>>> call = userService.getManagers(userId, page);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getFollowedUsers(@NonNull String userId, @Nullable Integer page, ResponseCallback<CreatubblesResponse<List<User>>> callback) {
        Call<JSONAPIDocument<List<User>>> call = userService.getFollowedUsers(userId, page);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getConnections(@NonNull String userId, @Nullable Integer page, ResponseCallback<CreatubblesResponse<List<User>>> callback) {
        Call<JSONAPIDocument<List<User>>> call = userService.getConnections(userId, page);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void createUser(@NonNull NewUser newUser, ResponseCallback<CreatubblesResponse<User>> callback) {
        Call<JSONAPIDocument<User>> call = userService.createUser(newUser);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getUsersAvailableForSwitching(@Nullable Integer page, ResponseCallback<CreatubblesResponse<List<User>>> callback) {
        Call<JSONAPIDocument<List<User>>> call = userService.getSwitchUsers(page);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void createMultipleCreators(@NonNull MultipleCreators multipleCreators, ResponseCallback<CreatubblesResponse<MultipleCreators>> callback) {
        Call<JSONAPIDocument<MultipleCreators>> call = userService.createMultipleCreators(multipleCreators);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getCreatorsFromGroup(@NonNull String groupId, @Nullable Integer page, ResponseCallback<CreatubblesResponse<List<User>>> callback) {
        Call<JSONAPIDocument<List<User>>> call = userService.getCreatorsFromGroup(groupId, page);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

}
