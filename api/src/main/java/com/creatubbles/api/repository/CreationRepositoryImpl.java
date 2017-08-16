package com.creatubbles.api.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.ContentType;
import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.creation.Creation;
import com.creatubbles.api.model.creation.ToybooDetails;
import com.creatubbles.api.model.image_manipulation.ImageManipulation;
import com.creatubbles.api.model.upload.UploadState;
import com.creatubbles.api.response.BaseResponseMapper;
import com.creatubbles.api.response.JsonApiResponseMapper;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.response.UploadResponseCallback;
import com.creatubbles.api.service.CreationService;
import com.creatubbles.api.service.GalleryService;
import com.creatubbles.api.service.UploadService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import java.io.File;
import java.util.List;

import retrofit2.Call;


/**
 * Created by Janek on 07.03.2016.
 */
class CreationRepositoryImpl implements CreationRepository {

    final CreationService creationService;
    final ObjectMapper objectMapper;
    final UploadService uploadService;
    final GalleryService galleryService;

    CreationRepositoryImpl(ObjectMapper objectMapper, CreationService creationService,
                           UploadService uploadService, GalleryService galleryService) {
        this.objectMapper = objectMapper;
        this.creationService = creationService;
        this.uploadService = uploadService;
        this.galleryService = galleryService;
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
    public void uploadCreation(@NonNull Creation creation, @NonNull File file,
                               @NonNull ContentType contentType, @Nullable List<String> galleryIds,
                               @Nullable UploadResponseCallback<Creation> callback) {
        new CreationRepositoryUploadCreationDelegate(objectMapper, creationService,
                uploadService, galleryService, creation, file, contentType, galleryIds,
                callback).upload();
    }

    @Override
    public void resumeUploadCreation(@NonNull Creation creation, @NonNull File file,
                                     @NonNull ContentType contentType, @Nullable List<String> galleryIds,
                                     @NonNull UploadState uploadState,
                                     @Nullable UploadResponseCallback<Creation> callback) {
        new CreationRepositoryUploadCreationDelegate(objectMapper, creationService,
                uploadService, galleryService, creation, file, contentType, galleryIds,
                callback).resume(uploadState);
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

    @Override
    public void updateViewsCount(@NonNull String creationId, @Nullable ResponseCallback<Void> callback) {
        Call<Void> call = creationService.updateViewsCount(creationId);
        call.enqueue(new BaseResponseMapper<>(objectMapper, callback));
    }
}
