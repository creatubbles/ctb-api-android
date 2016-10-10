package com.creatubbles.api.repository;

import com.creatubbles.api.model.user.NewUser;
import com.creatubbles.api.model.user.User;
import com.creatubbles.api.response.ResponseCallback;

import java.util.List;

/**
 * Created by Janek on 18.02.2016.
 */
public interface UserRepository {

    void getUserById(String id, ResponseCallback<User> callback);

    void getUser(ResponseCallback<User> callback);

    void getUsersList(ResponseCallback<List<User>> callback);

    void createUser(NewUser newUser, ResponseCallback<User> callback);

}
