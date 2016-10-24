package com.creatubbles.api.service;

import com.creatubbles.api.EndPoints;
import com.creatubbles.api.model.user.custom_style.CustomStyle;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Janek on 21.10.2016.
 */

public interface CustomStyleService {

    String PARAM_USER_ID = "user_id";
    String PATH_CUSTOM_STYLE = "{" + PARAM_USER_ID + "}/custom_style";

    @GET(EndPoints.USERS + "/" + PATH_CUSTOM_STYLE)
    Call<JSONAPIDocument<CustomStyle>> getCustomStyle(@Path(PARAM_USER_ID) String userId);

    @PUT(EndPoints.USERS + "/" + PATH_CUSTOM_STYLE)
    Call<JSONAPIDocument<CustomStyle>> updateCustomStyle(@Path(PARAM_USER_ID) String userId, @Body CustomStyle body);
}
