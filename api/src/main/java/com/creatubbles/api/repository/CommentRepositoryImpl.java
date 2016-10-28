package com.creatubbles.api.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.comment.Comment;
import com.creatubbles.api.response.BaseResponseMapper;
import com.creatubbles.api.response.JsonApiResponseMapper;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.CommentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import java.util.List;

import retrofit2.Call;

/**
 * @author Pawel Szymanski
 */
class CommentRepositoryImpl implements CommentRepository {

    private final CommentService service;
    private final ObjectMapper objectMapper;

    CommentRepositoryImpl(CommentService service, ObjectMapper objectMapper) {
        this.service = service;
        this.objectMapper = objectMapper;
    }

    @Override
    public void getForCreation(@Nullable Integer page, @NonNull String creationId,
                               ResponseCallback<CreatubblesResponse<List<Comment>>> callback) {
        Call<JSONAPIDocument<List<Comment>>> call = service.getForCreation(creationId, page);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getForGallery(@Nullable Integer page, @NonNull String galleryId,
                              ResponseCallback<CreatubblesResponse<List<Comment>>> callback) {
        Call<JSONAPIDocument<List<Comment>>> call = service.getForGallery(galleryId, page);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getForUser(@Nullable Integer page, @NonNull String userId,
                           ResponseCallback<CreatubblesResponse<List<Comment>>> callback) {
        Call<JSONAPIDocument<List<Comment>>> call = service.getForUser(userId, page);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void createForCreation(@NonNull Comment comment, @NonNull String creationId,
                                  ResponseCallback<CreatubblesResponse<Comment>> callback) {
        Call<JSONAPIDocument<Comment>> call = service.createForCreation(creationId, comment);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void createForGallery(@NonNull Comment comment, @NonNull String galleryId,
                                 ResponseCallback<CreatubblesResponse<Comment>> callback) {
        Call<JSONAPIDocument<Comment>> call = service.createForGallery(galleryId, comment);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void createForUser(@NonNull Comment comment, @NonNull String userId,
                              ResponseCallback<CreatubblesResponse<Comment>> callback) {
        Call<JSONAPIDocument<Comment>> call = service.createForUser(userId, comment);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void approve(@NonNull String commentId, ResponseCallback<Void> callback) {
        Call<Void> call = service.approve(commentId);
        call.enqueue(new BaseResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void decline(@NonNull String commentId, ResponseCallback<Void> callback) {
        Call<Void> call = service.decline(commentId);
        call.enqueue(new BaseResponseMapper<>(objectMapper, callback));
    }
}
