package com.creatubbles.api.repository;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.creation.Creation;
import com.creatubbles.api.model.upload.Upload;
import com.creatubbles.api.request.CreationListRequest;
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
public class CreationRepositoryImpl implements CreationRepository {


    private CreationService creationService;
    private ObjectMapper objectMapper;

    public CreationRepositoryImpl(ObjectMapper objectMapper, CreationService creationService) {
        this.objectMapper = objectMapper;
        this.creationService = creationService;
    }

    @Override
    public void getCretiationsList(CreationListRequest body, ResponseCallback<CreatubblesResponse<List<Creation>>>
            callback) {
        Call<JSONAPIDocument<List<Creation>>> call = creationService.getListOfCreation(body);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getCreationById(String id, ResponseCallback<CreatubblesResponse<Creation>> callback) {
        Call<JSONAPIDocument<Creation>> call = creationService.getCreationById(id);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void updateCreation(String id, Creation creation,
                               ResponseCallback<Void> callback) {
        Call<Void> call = creationService.updateCreation(id, creation);
        call.enqueue(new BaseResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void createCreation(Creation creation, ResponseCallback<CreatubblesResponse<Creation>>
            callback) {
        Call<JSONAPIDocument<Creation>> call = creationService.createCreation(creation);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void createUpload(String id, UploadRequest body, ResponseCallback<CreatubblesResponse<Upload>> callback) {
        Call<JSONAPIDocument<Upload>> call = creationService.createUpload(id, body);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void updateCreationUpload(String pingUrl, ResponseCallback<Void> callback) {
        String id = pingUrl.substring(pingUrl.lastIndexOf("/") + 1);
        Call<Void> call = creationService.updateCreationUpload(id);
        call.enqueue(new BaseResponseMapper<>(objectMapper, callback));
    }
}
