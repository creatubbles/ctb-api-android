package com.creatubbles.api.service;

import com.creatubbles.api.EndPoints;
import com.creatubbles.api.model.user.User;
import com.creatubbles.api.model.user.UserList;
import com.creatubbles.api.request.CreatorRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Janek on 05.02.2016.
 */
public interface UserService {

    @GET(EndPoints.USERS + "/{id}")
    Call<User> getUserById(@Path("id") String id);

    @GET(EndPoints.USERS + "/me")
    Call<User> getUser();

    @GET(EndPoints.USERS)
    Call<UserList> getUsers();

    @POST(EndPoints.CREATORS)
    Call<User> createUser(@Body CreatorRequest creatorRequest);

}
