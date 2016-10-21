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
     * <p>
     * Access Restrictions:
     * <ul>
     * <li>With an application only access token you’ll retrieve public activity.</li>
     * <li>With an user access token you’ll retrieve activity geared towards this user.</li>
     * </ul>
     * </p>
     */
    void getActivities(@Nullable Integer page, ResponseCallback<CreatubblesResponse<List<Activity>>> callback);
}
