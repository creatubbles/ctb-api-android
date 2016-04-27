package com.creatubbles.api.repository;

import com.creatubbles.api.model.AuthToken;
import com.creatubbles.api.response.ResponseCallback;

/**
 * @author Matthew Platek on 11.02.2016.
 */
public interface OAuthRepository {

    void authorize(ResponseCallback<AuthToken> callback);

    void authorize(String login, String password, ResponseCallback<AuthToken> callback);

    void setClientId(String clientId);

    void setClientSecret(String clientSecret);
}
