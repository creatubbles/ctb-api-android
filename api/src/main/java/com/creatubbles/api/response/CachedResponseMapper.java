package com.creatubbles.api.response;

import android.content.Context;

import com.creatubbles.api.utils.UploadRepositoryCacheUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.MediaType;
import retrofit2.Call;
import retrofit2.Response;

public class CachedResponseMapper<T> extends SameResponseMapper<T> {
    private final String url;
    private final MediaType contentType;
    private final String fileName;
    private final Context context;
    private final ResponseCallback<T> responseCallback;

    public CachedResponseMapper(ObjectMapper objectMapper,final String url, final MediaType contentType,
                                final String fileName, final Context context,
                                ResponseCallback<T> responseCallback) {
        super(objectMapper, responseCallback);
        this.url = url;
        this.contentType = contentType;
        this.fileName = fileName;
        this.context = context;
        this.responseCallback = responseCallback;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (responseCallback != null) {
            if (response.isSuccessful()) {
                UploadRepositoryCacheUtil.removeFileFromSendCache(url, contentType, fileName, context);
                processResponse(response);
            } else if (response.message() != null) {
                UploadRepositoryCacheUtil.addFileToSendCache(url, contentType, fileName, context);
                handleUnsuccessfullResponse(response);
            }
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        UploadRepositoryCacheUtil.addFileToSendCache(url, contentType, fileName, context);
        super.onFailure(call, t);
    }
}
