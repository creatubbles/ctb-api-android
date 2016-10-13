package com.creatubbles.api.service;

import com.creatubbles.api.EndPoints;
import com.creatubbles.api.model.user.NewUser;
import com.creatubbles.api.model.user.User;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import java.util.List;

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
    Call<JSONAPIDocument<User>> getUserById(@Path("id") String id);

    @GET(EndPoints.USERS + "/me")
    Call<JSONAPIDocument<User>> getUser();

    @GET(EndPoints.USERS)
    Call<JSONAPIDocument<List<User>>> getUsers();

    @POST(EndPoints.CREATORS)
    Call<JSONAPIDocument<User>> createUser(@Body NewUser newUser);

}
