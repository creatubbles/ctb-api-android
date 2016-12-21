package com.creatubbles.api.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.landing_url.LandingUrl;
import com.creatubbles.api.model.landing_url.LandingUrlType;
import com.creatubbles.api.response.ResponseCallback;

import java.util.List;

public interface LandingUrlsRepository {

    /**
     * Retrieve all landing URLs (besides creation landing URLs) for a specific application or user.
     * <p>Access Restrictions
     * <ul>
     * <li>With an application only access token you get the common landing URLs. Use this to retrieve the common landing URLs before a user has signed in.</li>
     * <li>With an user access token you get user specific landing URLs.</li>
     * </ul>
     * </p>
     */
    void getAll(@Nullable ResponseCallback<CreatubblesResponse<List<LandingUrl>>> callback);

    /**
     * Use this to retrieve a specific landing URL.
     */
    void getSpecific(@NonNull LandingUrlType type, @Nullable ResponseCallback<CreatubblesResponse<LandingUrl>> callback);

    /**
     * Use this to retrieve a specific landing URL for a creation with a given {@code creationId}.
     * This is usually used after uploading a creation, to allow the user to jump to the
     * Creatubbles website to see and adjust their creation there.
     */
    void getForCreation(@NonNull String creationId, @Nullable ResponseCallback<CreatubblesResponse<LandingUrl>> callback);
}
