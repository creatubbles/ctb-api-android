package com.creatubbles.api.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.model.auth.ApplicationAccessToken;
import com.creatubbles.api.model.auth.UserAccessToken;
import com.creatubbles.api.response.ResponseCallback;

/**
 * @author Matthew Platek on 11.02.2016.
 */
public interface OAuthRepository {

    /**
     * Method used to obtain <strong>Application only access token</strong>.
     * This token will give you access to publicly available information and actions.
     * Use this type of access token if you want to retrieve content independent from any users.
     */
    void authorize(ResponseCallback<ApplicationAccessToken> callback);

    /**
     * Method used to obtain <strong>User access token</strong>. User access tokens extend your access rights to allow your
     * application to also access content and actions which have restricted visibility and are available
     * for the user the access token was issued for. The user access token basically allows you to retrieve
     * content and execute actions on behalf of the user the token was issued for.
     */
    void authorize(String login, String password, ResponseCallback<UserAccessToken> callback);

    void setClientId(String clientId);

    void setClientSecret(String clientSecret);

    /**
     * Method used to retrieve an access token for one of current user's managed creators without their password.
     *
     * @param currentToken current user's access token
     * @param targetUserId the user for which to obtain an access token
     * @param groupId      (optional) limits further user switching to the given group
     */
    void switchUser(@NonNull UserAccessToken currentToken, @NonNull String targetUserId, @Nullable String groupId, ResponseCallback<UserAccessToken> callback);
}
