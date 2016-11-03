package com.creatubbles.api.repository;

import android.support.annotation.NonNull;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.user.avatar.Avatar;
import com.creatubbles.api.model.user.avatar.AvatarSuggestion;
import com.creatubbles.api.response.JsonApiResponseMapper;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import java.util.List;

import retrofit2.Call;

/**
 * Created by Janek on 26.10.2016.
 */

public class AvatarRepositoryImpl implements AvatarRepository {

    private final ObjectMapper objectMapper;
    private final UserService userService;


    AvatarRepositoryImpl(ObjectMapper objectMapper, UserService userService) {
        this.objectMapper = objectMapper;
        this.userService = userService;
    }


    @Override
    public void updateAvatar(@NonNull String userId, Avatar body, ResponseCallback<CreatubblesResponse<Avatar>> callback) {
        Call<JSONAPIDocument<Avatar>> call = userService.updateAvatar(userId, body);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getSuggestedAvatars(ResponseCallback<CreatubblesResponse<List<AvatarSuggestion>>> callback) {
        Call<JSONAPIDocument<List<AvatarSuggestion>>> call = userService.getSuggestedAvatars();
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }
}
