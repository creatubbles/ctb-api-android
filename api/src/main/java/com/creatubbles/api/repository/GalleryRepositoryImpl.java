package com.creatubbles.api.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.GallerySubmission;
import com.creatubbles.api.model.creation.Creation;
import com.creatubbles.api.model.gallery.Gallery;
import com.creatubbles.api.response.BaseResponseMapper;
import com.creatubbles.api.response.JsonApiResponseMapper;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.GalleryFilter;
import com.creatubbles.api.service.GalleryService;
import com.creatubbles.api.service.GallerySortMode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

/**
 * Created by Janek on 07.03.2016.
 */
class GalleryRepositoryImpl implements GalleryRepository {

    private GalleryService galleryService;
    private ObjectMapper objectMapper;

    GalleryRepositoryImpl(ObjectMapper objectMapper, GalleryService galleryService) {
        this.objectMapper = objectMapper;
        this.galleryService = galleryService;
    }

    @Override
    public void getPublic(@Nullable Integer page, @Nullable GallerySortMode sort,
                          ResponseCallback<CreatubblesResponse<List<Gallery>>> callback) {
        String sortParam = sort != null ? sort.toString() : null;
        Call<JSONAPIDocument<List<Gallery>>> call = galleryService.getPublic(null, page, sortParam);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void searchPublic(@NonNull String query, @Nullable Integer page, @Nullable GallerySortMode sort, @Nullable ResponseCallback<CreatubblesResponse<List<Gallery>>> callback) {
        String sortParam = sort != null ? sort.toString() : null;
        Call<JSONAPIDocument<List<Gallery>>> call = galleryService.getPublic(query, page, sortParam);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getFavorite(@Nullable Integer page, ResponseCallback<CreatubblesResponse<List<Gallery>>> callback) {
        Call<JSONAPIDocument<List<Gallery>>> call = galleryService.getFavorite(page);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getFeatured(@Nullable Integer page, ResponseCallback<CreatubblesResponse<List<Gallery>>> callback) {
        Call<JSONAPIDocument<List<Gallery>>> call = galleryService.getFeatured(page);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getById(@Nullable Integer page, @NonNull String galleryId,
                        ResponseCallback<CreatubblesResponse<Gallery>> callback) {
        Call<JSONAPIDocument<Gallery>> call = galleryService.getById(galleryId);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void create(@NonNull Gallery gallery, ResponseCallback<CreatubblesResponse<Gallery>> callback) {
        Call<JSONAPIDocument<Gallery>> call = galleryService.create(gallery);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void update(@NonNull String galleryId, @NonNull Gallery gallery, ResponseCallback<Void> callback) {
        Call<Void> call = galleryService.update(galleryId, gallery);
        call.enqueue(new BaseResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getMine(@Nullable Integer page, @Nullable String query, @Nullable GalleryFilter filter,
                        ResponseCallback<CreatubblesResponse<List<Gallery>>> callback) {
        String filterParam = filter != null ? filter.toString() : null;
        Call<JSONAPIDocument<List<Gallery>>> call = galleryService.getByUser(UserRepository.CURRENT_USER, page, query, filterParam);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getByUser(@Nullable Integer page, @NonNull String userId, @Nullable String query,
                          ResponseCallback<CreatubblesResponse<List<Gallery>>> callback) {
        Call<JSONAPIDocument<List<Gallery>>> call = galleryService.getByUser(userId, page, query, null);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getByCreation(@Nullable Integer page, @NonNull String creationId,
                              ResponseCallback<CreatubblesResponse<List<Gallery>>> callback) {
        Call<JSONAPIDocument<List<Gallery>>> call = galleryService.getByCreation(creationId, page);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void submitCreation(@NonNull String galleryId, @NonNull String creationId, ResponseCallback<CreatubblesResponse<GallerySubmission>> callback) {
        Call<JSONAPIDocument<GallerySubmission>> call = galleryService.postSubmission(new GallerySubmission(galleryId, creationId));
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void submitCreations(@NonNull String galleryId, @NonNull List<String> creationIds, @Nullable ResponseCallback<CreatubblesResponse<Gallery>> callback) {
        List<Creation> creations = mapIdsToCreations(creationIds);
        Call<JSONAPIDocument<Gallery>> call = galleryService.submitCreations(galleryId, creations);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void removeCreations(@NonNull String galleryId, @NonNull List<String> creationIds, @Nullable ResponseCallback<Void> callback) {
        List<Creation> creations = mapIdsToCreations(creationIds);
        Call<Void> call = galleryService.removeCreations(galleryId, creations);
        call.enqueue(new BaseResponseMapper<>(objectMapper, callback));
    }

    @NonNull
    private List<Creation> mapIdsToCreations(@NonNull List<String> creationIds) {
        List<Creation> creations = new ArrayList<>(creationIds.size());
        for (String creationId : creationIds) {
            creations.add(new Creation(creationId));
        }
        return creations;
    }
}
