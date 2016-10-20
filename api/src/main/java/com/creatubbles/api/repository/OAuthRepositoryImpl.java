package com.creatubbles.api.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.model.AuthToken;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.response.SameResponseMapper;
import com.creatubbles.api.service.GrantType;
import com.creatubbles.api.service.OAuthService;
import com.fasterxml.jackson.databind.ObjectMapper;

import retrofit2.Call;

/**
 * @author Matthew Platek on 11.02.2016.
 */
public class OAuthRepositoryImpl implements OAuthRepository {

    private OAuthService oAuthService;

    private String clientId;

    private String clientSecret;

    private ObjectMapper objectMapper;

    public OAuthRepositoryImpl(ObjectMapper objectMapper, OAuthService oAuthService) {
        this.objectMapper = objectMapper;
        this.oAuthService = oAuthService;
    }

    @Override
    public void authorize(ResponseCallback<AuthToken> callback) {
        Call<AuthToken> call = oAuthService.getAccessToken(clientId, clientSecret, GrantType.CLIENT_CREDENTIALS);
        call.enqueue(new SameResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void authorize(String login, String password, ResponseCallback<AuthToken> callback) {
        Call<AuthToken> call = oAuthService.getAccessToken(clientId, clientSecret, GrantType.PASSWORD, login,
                password);
        call.enqueue(new SameResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void switchAccount(@NonNull AuthToken currentToken, @NonNull String targetUserId, @Nullable String groupId, ResponseCallback<AuthToken> callback) {
        Call<AuthToken> call = oAuthService.switchUser(currentToken.getAccessToken(), GrantType.USER_SWITCH, targetUserId, groupId);
        call.enqueue(new SameResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    @Override
    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

}
