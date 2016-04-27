package com.creatubbles.api.repository;

import com.creatubbles.api.model.UserListResponse;
import com.creatubbles.api.model.user.User;
import com.creatubbles.api.request.CreatorRequest;
import com.creatubbles.api.response.CallbackMapper;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.UserService;

import retrofit2.Call;

/**
 * Created by Janek on 18.02.2016.
 */
public class UserRepositoryImpl implements UserRepository {

    public UserService userService;

    public UserRepositoryImpl(UserService service) {
        this.userService = service;
    }

    @Override
    public void getUserById(String id, ResponseCallback<User> callback) {
        Call<User> call = userService.getUserById(id);
        call.enqueue(new CallbackMapper<User>().map(callback));
    }

    @Override
    public void getUser(ResponseCallback<User> callback) {
        Call<User> call = userService.getUser();
        call.enqueue(new CallbackMapper<User>().map(callback));
    }

    @Override
    public void getUsersList(ResponseCallback<UserListResponse> callback) {
        Call<UserListResponse> call = userService.getUsers();
        call.enqueue(new CallbackMapper<UserListResponse>().map(callback));
    }

    @Override
    public void createUser(CreatorRequest creatorRequest, ResponseCallback<User> callback) {
        Call<User> call = userService.createUser(creatorRequest);
        call.enqueue(new CallbackMapper<User>().map(callback));
    }


}
