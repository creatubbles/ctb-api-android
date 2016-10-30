package com.creatubbles.api.repository;

import android.support.annotation.NonNull;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.user.avatar.Avatar;
import com.creatubbles.api.model.user.avatar.AvatarSuggestion;
import com.creatubbles.api.response.ResponseCallback;

import java.util.List;

/**
 * Created by Janek on 26.10.2016.
 */

public interface AvatarRepository {

    void updateAvatar(@NonNull String userId, Avatar body, ResponseCallback<CreatubblesResponse<Avatar>> callback);

    void getSuggestedAvatars(ResponseCallback<CreatubblesResponse<List<AvatarSuggestion>>> callback);
}
