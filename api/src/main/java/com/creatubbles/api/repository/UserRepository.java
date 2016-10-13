package com.creatubbles.api.repository;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.user.NewUser;
import com.creatubbles.api.model.user.User;
import com.creatubbles.api.response.ResponseCallback;

import java.util.List;

/**
 * Created by Janek on 18.02.2016.
 */
public interface UserRepository {

    void getUserById(String id, ResponseCallback<CreatubblesResponse<User>> callback);

    void getUser(ResponseCallback<CreatubblesResponse<User>> callback);

    void getUsersList(ResponseCallback<CreatubblesResponse<List<User>>> callback);

    void createUser(NewUser newUser, ResponseCallback<CreatubblesResponse<User>> callback);

}
