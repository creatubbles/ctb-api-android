package com.creatubbles.api.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.Following;
import com.creatubbles.api.model.hashtag.Hashtag;
import com.creatubbles.api.response.ResponseCallback;

import java.util.List;

public interface HashtagRepository {

    void getDetails(@NonNull String hashTag, @Nullable ResponseCallback<CreatubblesResponse<Hashtag>> callback);

    void follow(@NonNull String hashTag, @Nullable ResponseCallback<CreatubblesResponse<Following>> callback);

    void unFollow(@NonNull String hashTag, @Nullable ResponseCallback<Void> callback);

    void getSuggested(@Nullable Integer page, @Nullable ResponseCallback<CreatubblesResponse<List<Hashtag>>> callback);

}
