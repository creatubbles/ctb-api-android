package com.creatubbles.api.service;

import com.creatubbles.api.EndPoints;
import com.creatubbles.api.model.content.Content;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Mario Ostapowicz on 28.10.2016.
 */

public interface ContentService {

    @GET(EndPoints.CONTENTS)
    Call<JSONAPIDocument<List<Content>>> getContents(@Query("query") String query);
}
