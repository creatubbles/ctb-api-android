package com.creatubbles.api.service;

import com.creatubbles.api.EndPoints;
import com.creatubbles.api.model.activity.Activity;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author Pawel Szymanski
 */
public interface ActivityService {

    @GET(EndPoints.ACTIVITIES)
    Call<JSONAPIDocument<List<Activity>>> getActivities(@Query("page") Integer page);
}
