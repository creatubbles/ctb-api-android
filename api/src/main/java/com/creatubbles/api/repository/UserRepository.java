package com.creatubbles.api.repository;

import com.creatubbles.api.model.user.User;
import com.creatubbles.api.model.user.UserList;
import com.creatubbles.api.request.CreatorRequest;
import com.creatubbles.api.response.ResponseCallback;

/**
 * Created by Janek on 18.02.2016.
 */
public interface UserRepository {

    void getUserById(String id, ResponseCallback<User> callback);

    void getUser(ResponseCallback<User> callback);

    void getUsersList(ResponseCallback<UserList> callback);

    void createUser(CreatorRequest creatorRequest, ResponseCallback<User> callback);

}
