package com.creatubbles.api.service;

import com.creatubbles.api.EndPoints;
import com.creatubbles.api.model.AuthToken;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Janek on 05.02.2016.
 */
public interface OAuthService {

    @FormUrlEncoded
    @POST(EndPoints.OAUTH_TOKEN)
    Call<AuthToken> getAccessToken(@Field("client_id") String id,
                                   @Field("client_secret") String secret,
                                   @Field("grant_type") GrantType grantType,
                                   @Field("username") String username,
                                   @Field("password") String password);

    @FormUrlEncoded
    @POST(EndPoints.OAUTH_TOKEN)
    Call<AuthToken> getAccessToken(@Field("client_id") String id,
                                   @Field("client_secret") String secret,
                                   @Field("grant_type") GrantType grantType);

    @FormUrlEncoded
    @POST(EndPoints.OAUTH_TOKEN)
    Call<AuthToken> switchUser(@Field("access_token") String currentToken,
                               @Field("grant_type") GrantType grantType,
                               @Field("target_user_id") String targetUserId,
                               @Field("group_id") String groupId);

}
