package com.creatubbles.api.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.notification.Notification;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.NotificationFilter;

import java.util.List;

/**
 * @author Pawel Szymanski
 */
public interface NotificationRepository {

    void getNotifications(@Nullable Integer page, @Nullable NotificationFilter filter,
                          @Nullable ResponseCallback<CreatubblesResponse<List<Notification>>> callback);

    void markRead(@NonNull String notificationId, @Nullable ResponseCallback<Void> callback);

    void updateLastViewedDate(@Nullable ResponseCallback<Void> callback);
}
