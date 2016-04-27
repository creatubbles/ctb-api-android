package com.creatubbles.api.repository;

import com.creatubbles.api.model.CreationListResponse;
import com.creatubbles.api.model.CreationResponse;
import com.creatubbles.api.model.UploadResponse;
import com.creatubbles.api.request.CreationListRequest;
import com.creatubbles.api.request.CreationRequest;
import com.creatubbles.api.request.UploadRequest;
import com.creatubbles.api.response.CallbackMapper;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.CreationService;

import retrofit2.Call;


/**
 * Created by Janek on 07.03.2016.
 */
public class CreationRepositoryImpl implements CreationRepository {


    private CreationService creationService;

    public CreationRepositoryImpl(CreationService creationService) {
        this.creationService = creationService;
    }

    @Override
    public void getCretiationsList(CreationListRequest body, ResponseCallback<CreationListResponse>
            callback) {
        Call<CreationListResponse> call = creationService.getListOfCreation(body);
        call.enqueue(new CallbackMapper<CreationListResponse>().map(callback));
    }

    @Override
    public void getCreationById(String id, ResponseCallback<CreationResponse> callback) {
        Call<CreationResponse> call = creationService.getCreationById(id);
        call.enqueue(new CallbackMapper<CreationResponse>().map(callback));
    }

    @Override
    public void updateCreation(String id, CreationRequest body,
                               ResponseCallback<Void> callback) {
        Call<Void> call = creationService.updateCreation(id, body);
        call.enqueue(new CallbackMapper<Void>().map(callback));
    }

    @Override
    public void createCreation(CreationRequest body, ResponseCallback<CreationResponse>
            callback) {
        Call<CreationResponse> call = creationService.createCreation(body);
        call.enqueue(new CallbackMapper<CreationResponse>().map(callback));
    }

    @Override
    public void createUpload(String id, UploadRequest body, ResponseCallback<UploadResponse>
            callback) {
        Call<UploadResponse> call = creationService.createUpload(id, body);
        call.enqueue(new CallbackMapper<UploadResponse>().map(callback));
    }

    @Override
    public void updateCreationUpload(String pingUrl, ResponseCallback<String> callback) {
        String id = pingUrl.substring(pingUrl.lastIndexOf("/") + 1);
        Call<String> call = creationService.updateCreationUpload(id);
        call.enqueue(new CallbackMapper<String>().map(callback));
    }
}
