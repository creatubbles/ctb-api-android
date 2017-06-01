package com.creatubbles.app.backend.builders;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.model.auth.UserAccessToken;
import com.creatubbles.api.response.ResponseCallback;

/**
 * @author Matthew Platek on 11.02.2016.
 */
public interface PrivateOAuthRepository {

    /**
     * Method used to obtain <strong>User access token</strong>. User access tokens extend your access rights to allow your
     * application to also access content and actions which have restricted visibility and are available
     * for the user the access token was issued for. The user access token basically allows you to retrieve
     * content and execute actions on behalf of the user the token was issued for.
     */
    void authorize(@NonNull String login, @NonNull String password, @Nullable ResponseCallback<UserAccessToken> callback);

}
