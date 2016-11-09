package com.creatubbles.api.service;

import com.creatubbles.api.EndPoints;
import com.creatubbles.api.model.Ability;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Janek on 04.11.2016.
 */

public interface AbilityService {

    String PARAM_ID = "id";
    String PATH_ID = "{" + PARAM_ID + "}";

    @GET(EndPoints.ABILITIES + "/" + PATH_ID)
    Call<JSONAPIDocument<Ability>> getSpecific(@Path(PARAM_ID) String id);
}
