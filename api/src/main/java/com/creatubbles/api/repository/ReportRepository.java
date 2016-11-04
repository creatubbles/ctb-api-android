package com.creatubbles.api.repository;

import android.support.annotation.NonNull;

import com.creatubbles.api.model.Report;
import com.creatubbles.api.response.ResponseCallback;

/**
 * @author Pawel Szymanski
 */
public interface ReportRepository {

    /**
     * Method used to create report on a user specified by {@code userId}.
     */
    void reportUser(@NonNull String userId, @NonNull Report report, ResponseCallback<Void> callback);

    /**
     * Method used to create report on a creation specified by {@code creationId}.
     */
    void reportCreation(@NonNull String creationId, @NonNull Report report, ResponseCallback<Void> callback);

    /**
     * Method used to create report on a gallery specified by {@code galleryId}.
     */
    void reportGallery(@NonNull String galleryId, @NonNull Report report, ResponseCallback<Void> callback);

    /**
     * Method used to create report on a comment specified by {@code commentId}.
     */
    void reportComment(@NonNull String commentId, @NonNull Report report, ResponseCallback<Void> callback);
}
