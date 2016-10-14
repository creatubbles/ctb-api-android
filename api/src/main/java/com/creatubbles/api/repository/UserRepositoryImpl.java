package com.creatubbles.api.repository;

import android.support.annotation.NonNull;

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
public class UserRepositoryImpl implements UserRepository {

    private UserService userService;
    private ObjectMapper objectMapper;

    public UserRepositoryImpl(ObjectMapper objectMapper, UserService service) {
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
    public void getCreators(ResponseCallback<CreatubblesResponse<List<User>>> callback) {
        Call<JSONAPIDocument<List<User>>> call = userService.getCreators(CURRENT_USER);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getManagers(ResponseCallback<CreatubblesResponse<List<User>>> callback) {
        Call<JSONAPIDocument<List<User>>> call = userService.getManagers(CURRENT_USER);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getConnections(ResponseCallback<CreatubblesResponse<List<User>>> callback) {
        Call<JSONAPIDocument<List<User>>> call = userService.getConnections(CURRENT_USER);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getFollowedUsers(ResponseCallback<CreatubblesResponse<List<User>>> callback) {
        Call<JSONAPIDocument<List<User>>> call = userService.getFollowedUsers(CURRENT_USER);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getCreators(@NonNull String userId, ResponseCallback<CreatubblesResponse<List<User>>> callback) {
        Call<JSONAPIDocument<List<User>>> call = userService.getCreators(userId);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getManagers(@NonNull String userId, ResponseCallback<CreatubblesResponse<List<User>>> callback) {
        Call<JSONAPIDocument<List<User>>> call = userService.getManagers(userId);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getFollowedUsers(@NonNull String userId, ResponseCallback<CreatubblesResponse<List<User>>> callback) {
        Call<JSONAPIDocument<List<User>>> call = userService.getFollowedUsers(userId);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getConnections(@NonNull String userId, ResponseCallback<CreatubblesResponse<List<User>>> callback) {
        Call<JSONAPIDocument<List<User>>> call = userService.getConnections(userId);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void createUser(@NonNull NewUser newUser, ResponseCallback<CreatubblesResponse<User>> callback) {
        Call<JSONAPIDocument<User>> call = userService.createUser(newUser);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getUsersAvailableForSwitching(ResponseCallback<CreatubblesResponse<List<User>>> callback) {
        Call<JSONAPIDocument<List<User>>> call = userService.getSwitchUsers();
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void createMultipleCreators(@NonNull MultipleCreators multipleCreators, ResponseCallback<CreatubblesResponse<MultipleCreators>> callback) {
        Call<JSONAPIDocument<MultipleCreators>> call = userService.createMultipleCreators(multipleCreators);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

}
