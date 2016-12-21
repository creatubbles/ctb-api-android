package com.creatubbles.api.repository;

import android.support.annotation.Nullable;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.activity.Activity;
import com.creatubbles.api.response.ResponseCallback;

import java.util.List;

/**
 * @author Pawel Szymanski
 */
public interface ActivityRepository {

    /**
     * Method used to obtain the list of activities. The activities returned by this method
     * correspond to the activities listed under the "For you" section of the web site.
     */
    void getActivities(@Nullable Integer page, @Nullable ResponseCallback<CreatubblesResponse<List<Activity>>> callback);
}
