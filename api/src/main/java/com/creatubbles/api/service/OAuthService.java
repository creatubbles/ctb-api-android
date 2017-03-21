package com.creatubbles.api.service;

import com.creatubbles.api.EndPoints;
import com.creatubbles.api.model.AuthToken;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Janek on 05.02.2016.
 */
public interface OAuthService {

    @FormUrlEncoded
    @POST(EndPoints.OAUTH_TOKEN)
    Call<AuthToken> getPasswordAccessToken(@Field("client_id") String id,
                                           @Field("client_secret") String secret,
                                           @Field("grant_type") GrantType grantType,
                                           @Field("username") String username,
                                           @Field("password") String password);

    @FormUrlEncoded
    @POST(EndPoints.OAUTH_TOKEN)
    Call<AuthToken> getApplicationAccessToken(@Field("client_id") String id,
                                              @Field("client_secret") String secret,
                                              @Field("grant_type") GrantType grantType);

    @FormUrlEncoded
    @POST(EndPoints.OAUTH_TOKEN)
    Call<AuthToken> getOAuthAccessToken(@Field("client_id") String id,
                                        @Field("client_secret") String secret,
                                        @Field("grant_type") GrantType grantType,
                                        @Field("redirect_uri") String redirectUri,
                                        @Field("code") String code);

    @FormUrlEncoded
    @POST(EndPoints.OAUTH_TOKEN)
    Call<AuthToken> switchUser(@Field("access_token") String currentToken,
                               @Field("grant_type") GrantType grantType,
                               @Field("target_user_id") String targetUserId,
                               @Field("group_id") String groupId);

    /**
     * Never call this method. It is here for forming a proper url to redirect the user to.
     * The alternative would have been forming the url manually, but this way is more in line with
     * the rest of the code.
     */
    @GET(EndPoints.OAUTH_AUTHORIZE)
    Call<Void> getAuthRedirect(@Query("client_id") String id,
                               @Query("client_secret") String secret,
                               @Query("redirect_uri") String redirectUri,
                               @Query("response_type") OAuthResponseType responseType);

}
