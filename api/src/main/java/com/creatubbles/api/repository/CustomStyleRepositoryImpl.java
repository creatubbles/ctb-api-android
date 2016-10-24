package com.creatubbles.api.repository;

import android.support.annotation.NonNull;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.user.custom_style.CustomStyle;
import com.creatubbles.api.response.JsonApiResponseMapper;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.CustomStyleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import retrofit2.Call;

/**
 * Created by Janek on 21.10.2016.
 */

public class CustomStyleRepositoryImpl implements CustomStyleRepository {

    private final CustomStyleService customStyleService;
    private final ObjectMapper objectMapper;

    public CustomStyleRepositoryImpl(ObjectMapper objectMapper, CustomStyleService customStyleService) {
        this.customStyleService = customStyleService;
        this.objectMapper = objectMapper;
    }

    @Override
    public void getCustomStyle(@NonNull String userId, ResponseCallback<CreatubblesResponse<CustomStyle>> callback) {
        Call<JSONAPIDocument<CustomStyle>> call = customStyleService.getCustomStyle(userId);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void updateCustomStyle(@NonNull String userId, @NonNull CustomStyle body, ResponseCallback<CreatubblesResponse<CustomStyle>> callback) {
        Call<JSONAPIDocument<CustomStyle>> call = customStyleService.updateCustomStyle(userId, body);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }


}
