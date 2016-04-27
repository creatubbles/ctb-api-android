package com.creatubbles.api.model;

import com.creatubbles.api.model.user.User;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Janek on 18.02.2016.
 */
public class UserListResponse {

    @SerializedName("data")
    private User[] users;

    public User[] getUsers() {
        return users;
    }
}
