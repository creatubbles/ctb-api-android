package com.creatubbles.api.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.gallery.Gallery;
import com.creatubbles.api.response.BaseResponseMapper;
import com.creatubbles.api.response.JsonApiResponseMapper;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.GalleryFilter;
import com.creatubbles.api.service.GalleryService;
import com.creatubbles.api.service.Sort;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jasminb.jsonapi.JSONAPIDocument;

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
    public void getPublic(@Nullable Integer page, @Nullable Sort sort,
                          ResponseCallback<CreatubblesResponse<List<Gallery>>> callback) {
        String sortParam = sort != null ? sort.toString() : null;
        Call<JSONAPIDocument<List<Gallery>>> call = galleryService.getPublic(page, sortParam);
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
    public void getMine(@Nullable Integer page, @Nullable GalleryFilter filter,
                        ResponseCallback<CreatubblesResponse<List<Gallery>>> callback) {
        String filterParam = filter != null ? filter.toString() : null;
        Call<JSONAPIDocument<List<Gallery>>> call = galleryService.getByUser(UserRepository.CURRENT_USER, page, filterParam);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getByUser(@Nullable Integer page, @NonNull String userId,
                          ResponseCallback<CreatubblesResponse<List<Gallery>>> callback) {
        Call<JSONAPIDocument<List<Gallery>>> call = galleryService.getByUser(userId, page, null);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getByCreation(@Nullable Integer page, @NonNull String creationId,
                              ResponseCallback<CreatubblesResponse<List<Gallery>>> callback) {
        Call<JSONAPIDocument<List<Gallery>>> call = galleryService.getByCreation(creationId, page);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

}
