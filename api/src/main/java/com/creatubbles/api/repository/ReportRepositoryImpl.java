package com.creatubbles.api.repository;

import android.support.annotation.NonNull;

import com.creatubbles.api.model.Report;
import com.creatubbles.api.response.BaseResponseMapper;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.ReportService;
import com.fasterxml.jackson.databind.ObjectMapper;

import retrofit2.Call;

/**
 * @author Pawel Szymanski
 */
class ReportRepositoryImpl implements ReportRepository {

    private final ReportService service;
    private final ObjectMapper objectMapper;

    ReportRepositoryImpl(ReportService service, ObjectMapper objectMapper) {
        this.service = service;
        this.objectMapper = objectMapper;
    }


    @Override
    public void reportUser(@NonNull String userId, @NonNull Report report, ResponseCallback<Void> callback) {
        Call<Void> call = service.postForUser(userId, report);
        call.enqueue(new BaseResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void reportCreation(@NonNull String creationId, @NonNull Report report, ResponseCallback<Void> callback) {
        Call<Void> call = service.postForCreation(creationId, report);
        call.enqueue(new BaseResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void reportGallery(@NonNull String galleryId, @NonNull Report report, ResponseCallback<Void> callback) {
        Call<Void> call = service.postForGallery(galleryId, report);
        call.enqueue(new BaseResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void reportComment(@NonNull String commentId, @NonNull Report report, ResponseCallback<Void> callback) {
        Call<Void> call = service.postForComment(commentId, report);
        call.enqueue(new BaseResponseMapper<>(objectMapper, callback));
    }
}
