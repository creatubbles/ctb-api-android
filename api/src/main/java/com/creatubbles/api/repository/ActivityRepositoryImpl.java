package com.creatubbles.api.repository;

import android.support.annotation.Nullable;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.activity.Activity;
import com.creatubbles.api.response.JsonApiResponseMapper;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.ActivityService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import java.util.List;

import retrofit2.Call;

/**
 * @author Pawel Szymanski
 */
public class ActivityRepositoryImpl implements ActivityRepository {
    private final ActivityService activityService;
    private final ObjectMapper objectMapper;

    public ActivityRepositoryImpl(ObjectMapper objectMapper, ActivityService activityService) {
        this.objectMapper = objectMapper;
        this.activityService = activityService;
    }

    @Override
    public void getActivities(@Nullable Integer page, ResponseCallback<CreatubblesResponse<List<Activity>>> callback) {
        Call<JSONAPIDocument<List<Activity>>> call = activityService.getActivities(page);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }
}
