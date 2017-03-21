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
    void authorize(@Nullable ResponseCallback<ApplicationAccessToken> callback);

    /**
     * Method used to obtain <strong>User access token</strong>. User access tokens extend your access rights to allow your
     * application to also access content and actions which have restricted visibility and are available
     * for the user the access token was issued for. The user access token basically allows you to retrieve
     * content and execute actions on behalf of the user the token was issued for.
     */
    void authorize(@NonNull String login, @NonNull String password, @Nullable ResponseCallback<UserAccessToken> callback);

    /**
     * Used to finish the OAuth flow. Call this method once you have the redirect uri. In order to obtain
     * this uri, you need to first open a browser for the URL returned by {@link #getOAuthAuthorizeUrl()}.
     * At the end of the flow, the browser redirects the user to the <strong>clientCallbackUrl</strong>
     * defined during API configuration.
     * <p>
     * <ul>
     * <li>clients that want to use this flow are obligated to provide <strong>clientCallbackUrl</strong> during configuration</li>
     * <li>Android clients also need to add an intent filter to their Manifest for the schema and domain in the <strong>clientCallbackUrl</strong></li>
     * </ul>
     *
     * @param oAuthRedirectUri uri received at the end of the OAuth flow started in the browser with {@link #getOAuthAuthorizeUrl()}.
     *                         This parameter is typically retrieved using {@link android.content.Intent#getData()}
     *                         in the activity that has the intent filter for <strong>clientCallbackUrl</strong> declared
     *                         in the Manifest.
     */
    void authorize(String oAuthRedirectUri, @Nullable ResponseCallback<UserAccessToken> callback);

    /**
     * Used to obtain the url that the application needs to open in a browser on the user's device. Do not call this url directly
     * as it starts an OAuth flow that the user needs to interact with. At the end of the flow, the user is redirected to the client
     * callback url used during configuration steps (using {@link com.creatubbles.api.Configuration.Builder#clientCallbackUrl(String)}).
     * For this reason clients that want to use this flow are obligated to provide <strong>clientCallbackUrl</strong> during configuration.
     * <p>
     * Android clients also need to add an intent filter to their Manifest for the schema and domain in the <strong>clientCallbackUrl</strong>
     * in order to receive the redirect Uri and then call {@link #authorize(String, ResponseCallback)} with it.
     *
     * @return Url to redirect the user to.
     * @throws RuntimeException if {@link com.creatubbles.api.Configuration.Builder#clientCallbackUrl(String)} was not used during configuration
     */
    String getOAuthAuthorizeUrl();

    void setClientId(@NonNull String clientId);

    void setClientSecret(@NonNull String clientSecret);

    void setClientCallbackUrl(@Nullable String clientCallbackUrl);

    /**
     * Method used to retrieve an access token for one of current user's managed creators without their password.
     *
     * @param currentToken current user's access token
     * @param targetUserId the user for which to obtain an access token
     * @param groupId      (optional) limits further user switching to the given group
     */
    void switchUser(@NonNull UserAccessToken currentToken, @NonNull String targetUserId, @Nullable String groupId, @Nullable ResponseCallback<UserAccessToken> callback);
}
