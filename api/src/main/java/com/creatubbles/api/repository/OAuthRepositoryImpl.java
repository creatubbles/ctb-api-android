package com.creatubbles.api.repository;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.model.AuthToken;
import com.creatubbles.api.model.auth.ApplicationAccessToken;
import com.creatubbles.api.model.auth.UserAccessToken;
import com.creatubbles.api.response.AuthResponseMapper;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.GrantType;
import com.creatubbles.api.service.OAuthResponseType;
import com.creatubbles.api.service.OAuthService;
import com.fasterxml.jackson.databind.ObjectMapper;

import retrofit2.Call;

/**
 * @author Matthew Platek on 11.02.2016.
 */
class OAuthRepositoryImpl implements OAuthRepository {

    private OAuthService oAuthService;

    private String clientId;

    private String clientSecret;

    private String clientCallbackUrl;

    private ObjectMapper objectMapper;

    OAuthRepositoryImpl(ObjectMapper objectMapper, OAuthService oAuthService) {
        this.objectMapper = objectMapper;
        this.oAuthService = oAuthService;
    }

    @Override
    public void authorize(ResponseCallback<ApplicationAccessToken> callback) {
        Call<AuthToken> call = oAuthService.getApplicationAccessToken(clientId, clientSecret, GrantType.CLIENT_CREDENTIALS);
        call.enqueue(new AuthResponseMapper<>(objectMapper, GrantType.CLIENT_CREDENTIALS, callback));
    }

    @Override
    public void authorize(@NonNull String login, @NonNull String password, ResponseCallback<UserAccessToken> callback) {
        Call<AuthToken> call = oAuthService.getPasswordAccessToken(clientId, clientSecret, GrantType.PASSWORD, login,
                password);
        call.enqueue(new AuthResponseMapper<>(objectMapper, GrantType.PASSWORD, callback));
    }

    @Override
    public void authorize(String oAuthRedirectUri, @Nullable ResponseCallback<UserAccessToken> callback) {
        Uri callbackUri = Uri.parse(oAuthRedirectUri);
        String oAuthCode = callbackUri.getQueryParameter("code");
        Call<AuthToken> call = oAuthService.getOAuthAccessToken(clientId, clientSecret, GrantType.AUTHORIZATION_CODE, clientCallbackUrl, oAuthCode);
        call.enqueue(new AuthResponseMapper<>(objectMapper, GrantType.AUTHORIZATION_CODE, callback));
    }

    @Override
    public String getOAuthAuthorizeUrl() {
        if (clientCallbackUrl == null) {
            throw new RuntimeException("For using the code OAuth flow, please first set the clientCallbackUrl on Configuration when initializing the API.");
        }
        Call<Void> call = oAuthService.getAuthRedirect(clientId, clientSecret, clientCallbackUrl, OAuthResponseType.CODE);
        return call.request().url().toString();
    }

    @Override
    public void switchUser(@NonNull UserAccessToken currentToken, @NonNull String targetUserId, @Nullable String groupId, @Nullable ResponseCallback<UserAccessToken> callback) {
        Call<AuthToken> call = oAuthService.switchUser(currentToken.getToken(), GrantType.USER_SWITCH, targetUserId, groupId);
        call.enqueue(new AuthResponseMapper<>(objectMapper, GrantType.USER_SWITCH, callback));
    }

    @Override
    public void setClientId(@NonNull String clientId) {
        this.clientId = clientId;
    }

    @Override
    public void setClientSecret(@NonNull String clientSecret) {
        this.clientSecret = clientSecret;
    }

    @Override
    public void setClientCallbackUrl(@Nullable String clientCallbackUrl) {
        this.clientCallbackUrl = clientCallbackUrl;
    }

}
