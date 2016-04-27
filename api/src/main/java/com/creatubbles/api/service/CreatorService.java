package com.creatubbles.api.service;

import com.creatubbles.api.EndPoints;
import com.creatubbles.api.model.user.User;
import com.creatubbles.api.request.CreatorRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


/**
 * Created by Janek on 05.02.2016.
 */
public interface CreatorService {

    @POST(EndPoints.CREATORS)
    Call<User> createCreator(@Body CreatorRequest request);

}
