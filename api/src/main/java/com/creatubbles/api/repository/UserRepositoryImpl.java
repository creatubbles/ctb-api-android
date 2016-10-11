package com.creatubbles.api.repository;

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
    public void getUserById(String id, ResponseCallback<User> callback) {
        Call<JSONAPIDocument<User>> call = userService.getUserById(id);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getUser(ResponseCallback<User> callback) {
        Call<JSONAPIDocument<User>> call = userService.getUser();
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getUsersList(ResponseCallback<List<User>> callback) {
        Call<JSONAPIDocument<List<User>>> call = userService.getUsers();
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void createUser(NewUser newUser, ResponseCallback<User> callback) {
        Call<JSONAPIDocument<User>> call = userService.createUser(newUser);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }


}
