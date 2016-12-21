package com.creatubbles.api.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.user.custom_style.CustomStyle;
import com.creatubbles.api.response.ResponseCallback;

/**
 * Created by Janek on 21.10.2016.
 */

public interface CustomStyleRepository {

    /**
     * Method used to obtain current user's custom style.
     *
     * @param userId the ID of the user for which we want to get the results
     */
    void getCustomStyle(@NonNull String userId, @Nullable ResponseCallback<CreatubblesResponse<CustomStyle>> callback);

    /**
     * Method used to update current user's custom style.
     *
     * @param userId the ID of the user for which we want to update custom style
     * @param body,  CustomStyle object with values to update.
     *               To create this object use {@link com.creatubbles.api.model.user.custom_style.CustomStyle}
     *               and set only the properties you want to update.
     */
    void updateCustomStyle(@NonNull String userId, @NonNull CustomStyle body, @Nullable ResponseCallback<CreatubblesResponse<CustomStyle>> callback);
}
