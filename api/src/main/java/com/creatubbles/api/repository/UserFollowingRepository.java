package com.creatubbles.api.repository;

import android.support.annotation.NonNull;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.user.UserFollowing;
import com.creatubbles.api.response.ResponseCallback;

/**
 * Interface that allows to manage current user's followed users.
 *
 * @author Pawel Szymanski
 */
public interface UserFollowingRepository {

    void follow(@NonNull String userId, ResponseCallback<CreatubblesResponse<UserFollowing>> callback);

    void unfollow(@NonNull String userId, ResponseCallback<Void> callback);

}
