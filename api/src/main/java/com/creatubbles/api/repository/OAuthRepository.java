package com.creatubbles.api.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

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

    /**
     * Method used to retrieve an access token for one of current user's managed creators without their password.
     *
     * @param currentToken current user's access token
     * @param targetUserId the user for which to obtain an access token
     * @param groupId      (optional) limits further user switching to the given group
     */
    void switchAccount(@NonNull AuthToken currentToken, @NonNull String targetUserId, @Nullable String groupId, ResponseCallback<AuthToken> callback);
}
