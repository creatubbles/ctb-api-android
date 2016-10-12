package com.creatubbles.api.repository;

import com.creatubbles.api.model.CtbResponse;
import com.creatubbles.api.model.user.NewUser;
import com.creatubbles.api.model.user.User;
import com.creatubbles.api.response.ResponseCallback;

import java.util.List;

/**
 * Created by Janek on 18.02.2016.
 */
public interface UserRepository {

    void getUserById(String id, ResponseCallback<CtbResponse<User>> callback);

    void getUser(ResponseCallback<CtbResponse<User>> callback);

    void getUsersList(ResponseCallback<CtbResponse<List<User>>> callback);

    void createUser(NewUser newUser, ResponseCallback<CtbResponse<User>> callback);

}
