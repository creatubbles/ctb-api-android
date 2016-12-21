package com.creatubbles.api.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.bubble.Bubble;
import com.creatubbles.api.model.bubble.BubbleColor;
import com.creatubbles.api.response.BaseResponseMapper;
import com.creatubbles.api.response.JsonApiResponseMapper;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.BubbleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import java.util.List;

import retrofit2.Call;

/**
 * @author Pawel Szymanski
 */
class BubbleRepositoryImpl implements BubbleRepository {
    private final BubbleService service;
    private final ObjectMapper objectMapper;

    BubbleRepositoryImpl(BubbleService service, ObjectMapper objectMapper) {
        this.service = service;
        this.objectMapper = objectMapper;
    }

    @Override
    public void getForCreation(@Nullable Integer page, @NonNull String creationId, @Nullable ResponseCallback<CreatubblesResponse<List<Bubble>>> callback) {
        Call<JSONAPIDocument<List<Bubble>>> call = service.getForCreation(creationId, page);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getForGallery(@Nullable Integer page, @NonNull String galleryId, @Nullable ResponseCallback<CreatubblesResponse<List<Bubble>>> callback) {
        Call<JSONAPIDocument<List<Bubble>>> call = service.getForGallery(galleryId, page);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getForUser(@Nullable Integer page, @NonNull String userId, @Nullable ResponseCallback<CreatubblesResponse<List<Bubble>>> callback) {
        Call<JSONAPIDocument<List<Bubble>>> call = service.getForUser(userId, page);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void createForCreation(@NonNull String creationId, @NonNull Bubble bubble, @Nullable ResponseCallback<CreatubblesResponse<Bubble>> callback) {
        Call<JSONAPIDocument<Bubble>> call = service.postForCreation(creationId, bubble);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void createForGallery(@NonNull String galleryId, @NonNull Bubble bubble, @Nullable ResponseCallback<CreatubblesResponse<Bubble>> callback) {
        Call<JSONAPIDocument<Bubble>> call = service.postForGallery(galleryId, bubble);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void createForUser(@NonNull String userId, @NonNull Bubble bubble, @Nullable ResponseCallback<CreatubblesResponse<Bubble>> callback) {
        Call<JSONAPIDocument<Bubble>> call = service.postForUser(userId, bubble);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }


    @Override
    public void update(@NonNull String bubbleId, @NonNull Bubble bubble, @Nullable ResponseCallback<Void> callback) {
        Call<Void> call = service.putBubble(bubbleId, bubble);
        call.enqueue(new BaseResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void delete(@NonNull String bubbleId, @Nullable ResponseCallback<Void> callback) {
        Call<Void> call = service.deleteBubble(bubbleId);
        call.enqueue(new BaseResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getColors(@Nullable ResponseCallback<CreatubblesResponse<List<BubbleColor>>> callback) {
        Call<JSONAPIDocument<List<BubbleColor>>> call = service.getColors();
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }
}
