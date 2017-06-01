package com.creatubbles.app.backend.services;

import com.creatubbles.api.EndPoints;
import com.creatubbles.api.model.AuthToken;
import com.creatubbles.api.service.GrantType;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface PrivateOAuthService {

    @FormUrlEncoded
    @POST(EndPoints.OAUTH_TOKEN)
    Call<AuthToken> getPasswordAccessToken(@Field("client_id") String id,
                                           @Field("client_secret") String secret,
                                           @Field("grant_type") GrantType grantType,
                                           @Field("username") String username,
                                           @Field("password") String password);

}
