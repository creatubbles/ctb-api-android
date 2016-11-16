package com.creatubbles.api.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.ContentType;
import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.creation.Creation;
import com.creatubbles.api.model.creation.ToybooDetails;
import com.creatubbles.api.model.image_manipulation.ImageManipulation;
import com.creatubbles.api.model.upload.Upload;
import com.creatubbles.api.request.UploadRequest;
import com.creatubbles.api.response.BaseResponseMapper;
import com.creatubbles.api.response.JsonApiResponseMapper;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.CreationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import java.util.List;

import retrofit2.Call;


/**
 * Created by Janek on 07.03.2016.
 */
class CreationRepositoryImpl implements CreationRepository {

    private final CreationService creationService;
    private final ObjectMapper objectMapper;

    CreationRepositoryImpl(ObjectMapper objectMapper, CreationService creationService) {
        this.objectMapper = objectMapper;
        this.creationService = creationService;
    }

    @Override
    public void getRecent(@Nullable Integer page, @Nullable Boolean onlyPublic,
                          ResponseCallback<CreatubblesResponse<List<Creation>>> callback) {
        Call<JSONAPIDocument<List<Creation>>> call = creationService.getRecent(page, onlyPublic);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getFromGallery(@Nullable Integer page, @NonNull String galleryId, @Nullable Boolean onlyPublic,
                               ResponseCallback<CreatubblesResponse<List<Creation>>> callback) {
        Call<JSONAPIDocument<List<Creation>>> call = creationService.getFromGallery(page, galleryId, onlyPublic);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getByUser(@Nullable Integer page, @NonNull String userId, @Nullable Boolean onlyPublic,
                          ResponseCallback<CreatubblesResponse<List<Creation>>> callback) {
        Call<JSONAPIDocument<List<Creation>>> call = creationService.getByUser(page, userId, onlyPublic);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getByName(@Nullable Integer page, @NonNull String name, @Nullable Boolean onlyPublic,
                          ResponseCallback<CreatubblesResponse<List<Creation>>> callback) {
        Call<JSONAPIDocument<List<Creation>>> call = creationService.searchByName(page, name, onlyPublic);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getById(@NonNull String creationId, ResponseCallback<CreatubblesResponse<Creation>> callback) {
        Call<JSONAPIDocument<Creation>> call = creationService.getCreation(creationId);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getRecommendedByCreation(@Nullable Integer page, @NonNull String creationId, @Nullable Boolean onlyPublic,
                                         ResponseCallback<CreatubblesResponse<List<Creation>>> callback) {
        Call<JSONAPIDocument<List<Creation>>> call = creationService.getRecommendedByCreation(page, creationId, onlyPublic);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getRecommendedByUser(@Nullable Integer page, @NonNull String creationId, @Nullable Boolean onlyPublic,
                                     ResponseCallback<CreatubblesResponse<List<Creation>>> callback) {
        Call<JSONAPIDocument<List<Creation>>> call = creationService.getRecommendedByUser(page, creationId, onlyPublic);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getByPartnerApplication(@Nullable Integer page, @NonNull String partnerApplicationId,
                                        ResponseCallback<CreatubblesResponse<List<Creation>>> callback) {
        Call<JSONAPIDocument<List<Creation>>> call = creationService.getByPartnerApplication(page, partnerApplicationId);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void update(@NonNull String id, @NonNull Creation creation, ResponseCallback<Void> callback) {
        Call<Void> call = creationService.updateCreation(id, creation);
        call.enqueue(new BaseResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void create(@NonNull Creation creation, ResponseCallback<CreatubblesResponse<Creation>> callback) {
        Call<JSONAPIDocument<Creation>> call = creationService.createCreation(creation);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void remove(@NonNull String creationId, ResponseCallback<Void> callback) {
        Call<Void> call = creationService.removeCreation(creationId);
        call.enqueue(new BaseResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void startUpload(@NonNull String creationId, @NonNull ContentType contentType,
                            ResponseCallback<CreatubblesResponse<Upload>> callback) {
        UploadRequest request = new UploadRequest(contentType);
        Call<JSONAPIDocument<Upload>> call = creationService.createUpload(creationId, request);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void finishUpload(@NonNull Upload upload, @Nullable String abortReason, ResponseCallback<Void> callback) {
        Call<Void> call = creationService.updateCreationUpload(upload.getPingUrl(), abortReason);
        call.enqueue(new BaseResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void updateImage(@NonNull String creationId, @NonNull ImageManipulation imageManipulation, ResponseCallback<Void> callback) {
        Call<Void> call = creationService.putImageManipulation(creationId, imageManipulation);
        call.enqueue(new BaseResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getToybooDetails(@NonNull String creationId, ResponseCallback<CreatubblesResponse<ToybooDetails>> callback) {
        Call<JSONAPIDocument<ToybooDetails>> call = creationService.getToybooDetails(creationId);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

}
