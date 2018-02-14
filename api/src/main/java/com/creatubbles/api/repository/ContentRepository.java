package com.creatubbles.api.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.content.Content;
import com.creatubbles.api.response.ResponseCallback;

import java.util.List;

/**
 * Created by Mario Ostapowicz on 28.10.2016.
 */

public interface ContentRepository {

    /**
     * Method used to find content.
     */
    void search(@NonNull String query, @Nullable Integer page, @Nullable ResponseCallback<CreatubblesResponse<List<Content>>> callback);

    /**
     * Method used to obtain a list of recent content.
     */
    void getRecent(@Nullable Integer page, @Nullable ResponseCallback<CreatubblesResponse<List<Content>>> callback);

    /**
     * Method used to obtain list of trending content.
     */
    void getTrending(@Nullable Integer page, @Nullable ResponseCallback<CreatubblesResponse<List<Content>>> callback);

    /**
     * Method used to obtain list of contents based on 'My Connections'.
     */
    void getConnected(@Nullable Integer page, @Nullable ResponseCallback<CreatubblesResponse<List<Content>>> callback);

    /**
     * Method used to obtain list of contents based on followed users.
     */
    void getFollowed(@Nullable Integer page, @Nullable ResponseCallback<CreatubblesResponse<List<Content>>> callback);

    /**
     * Method used to obtain list of contents by a user.
     */
    void getByUser(@Nullable Integer page, @NonNull String userId, @Nullable ResponseCallback<CreatubblesResponse<List<Content>>> callback);

    /**
     * Method used to obtain list of contents bubbled by a user.
     */
    void getBubbledByUser(@Nullable Integer page, @NonNull String userId, @Nullable ResponseCallback<CreatubblesResponse<List<Content>>> callback);

    void getByHashTag(@Nullable Integer page, @NonNull String hashTag, @Nullable ResponseCallback<CreatubblesResponse<List<Content>>> callback);
}
