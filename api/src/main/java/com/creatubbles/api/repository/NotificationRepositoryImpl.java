package com.creatubbles.api.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.notification.Notification;
import com.creatubbles.api.response.BaseResponseMapper;
import com.creatubbles.api.response.JsonApiResponseMapper;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.NotificationFilter;
import com.creatubbles.api.service.NotificationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import java.util.List;

import retrofit2.Call;

/**
 * @author Pawel Szymanski
 */
class NotificationRepositoryImpl implements NotificationRepository {
    private final NotificationService service;
    private final ObjectMapper objectMapper;

    NotificationRepositoryImpl(NotificationService service, ObjectMapper objectMapper) {
        this.service = service;
        this.objectMapper = objectMapper;
    }

    @Override
    public void getNotifications(@Nullable Integer page, @Nullable NotificationFilter filter, ResponseCallback<CreatubblesResponse<List<Notification>>> callback) {
        String filterValue = filter == null ? null : filter.getName();
        Call<JSONAPIDocument<List<Notification>>> call = service.getNotifications(page, filterValue);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void markRead(@NonNull String notificationId, ResponseCallback<Void> callback) {
        Call<Void> call = service.postReadNotification(notificationId);
        call.enqueue(new BaseResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void updateLastViewedDate(ResponseCallback<Void> callback) {
        Call<Void> call = service.putLastViewedAt();
        call.enqueue(new BaseResponseMapper<>(objectMapper, callback));
    }
}
