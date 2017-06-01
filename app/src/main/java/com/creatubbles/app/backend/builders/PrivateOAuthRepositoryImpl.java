package com.creatubbles.app.backend.builders;

import android.support.annotation.NonNull;

import com.creatubbles.api.model.AuthToken;
import com.creatubbles.api.model.auth.UserAccessToken;
import com.creatubbles.api.response.AuthResponseMapper;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.GrantType;
import com.creatubbles.app.backend.services.PrivateOAuthService;
import com.fasterxml.jackson.databind.ObjectMapper;

import retrofit2.Call;

/**
 * @author Matthew Platek on 11.02.2016.
 */
class PrivateOAuthRepositoryImpl implements PrivateOAuthRepository {

    private PrivateOAuthService oAuthService;

    private String clientId;

    private String clientSecret;

    private ObjectMapper objectMapper;

    public PrivateOAuthRepositoryImpl(ObjectMapper objectMapper, PrivateOAuthService oAuthService, String clientId, String clientSecret) {
        this.objectMapper = objectMapper;
        this.oAuthService = oAuthService;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    @Override
    public void authorize(@NonNull String login, @NonNull String password, ResponseCallback<UserAccessToken> callback) {
        Call<AuthToken> call = oAuthService.getPasswordAccessToken(clientId, clientSecret, GrantType.PASSWORD, login,
                password);
        call.enqueue(new AuthResponseMapper<>(objectMapper, GrantType.PASSWORD, callback));
    }

}
