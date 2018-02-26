package com.creatubbles.api.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.Following;
import com.creatubbles.api.model.user.UserFollowing;
import com.creatubbles.api.response.ResponseCallback;

import java.util.List;

/**
 * Interface that allows to manage current user's followed users.
 *
 * @author Pawel Szymanski
 */
public interface UserFollowingRepository {

    void follow(@NonNull String userId, @Nullable ResponseCallback<CreatubblesResponse<UserFollowing>> callback);

    void unfollow(@NonNull String userId, @Nullable ResponseCallback<Void> callback);

    void follow(@NonNull List<String> userIds, @Nullable ResponseCallback<CreatubblesResponse<List<Following>>> callback);

}
