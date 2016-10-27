package com.creatubbles.api.repository;

import android.content.Context;

import com.creatubbles.api.response.CachedResponseMapper;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.UploadService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;


/**
 * Created by Mariusz Ostapowicz on 20.03.2016.
 */
class UploadRepositoryImpl implements UploadRepository {

    private UploadService uploadService;
    private ObjectMapper objectMapper;

    private Context context;

    UploadRepositoryImpl(ObjectMapper objectMapper, UploadService uploadService, Context context) {
        this.objectMapper = objectMapper;
        this.uploadService = uploadService;
        this.context = context;
    }

    @Override
    public void uploadFile(String url, MediaType contentType, File file, ResponseCallback<String>
            callback) {
        RequestBody requestBody = RequestBody.create(contentType, file);

        Call<String> call = uploadService.uploadFile(url, requestBody);
        call.enqueue(new CachedResponseMapper<>(objectMapper, url, contentType, file
                .getAbsolutePath(), context, callback));
    }

}
