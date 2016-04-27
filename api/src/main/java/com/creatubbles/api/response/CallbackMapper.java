package com.creatubbles.api.response;

import android.content.Context;

import com.creatubbles.api.exception.ErrorResponse;
import com.creatubbles.api.utils.UploadRepositoryCacheUtil;
import com.google.gson.Gson;

import okhttp3.MediaType;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author Matthew Platek on 11.02.2016.
 */
public class CallbackMapper<T> {

    public Callback<T> map(final ResponseCallback<T> responseCallback) {
        return new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                if (responseCallback != null) {
                    if(response.isSuccess()) {
                        responseCallback.onSuccess(response.body());
                    } else if(response.message() != null) {
                        Gson gson = new Gson();
                        ErrorResponse responseError = gson.fromJson(response.errorBody().charStream(), ErrorResponse.class);
                        responseCallback.onServerError(responseError);
                    }
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                if (responseCallback != null) {
                    responseCallback.onError(t.getMessage());
                }
            }
        };
    }

    public Callback<T> mapWithCache(final String url, final MediaType contentType, final String fileName, final Context context, final ResponseCallback<T> responseCallback) {
        return new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                if (responseCallback != null) {
                    if(response.isSuccess()) {
                        UploadRepositoryCacheUtil.removeFileFromSendCache(url, contentType, fileName, context);
                        responseCallback.onSuccess(response.body());
                    } else if(response.message() != null) {
                        UploadRepositoryCacheUtil.addFileToSendCache(url, contentType, fileName, context);
                        Gson gson = new Gson();
                        ErrorResponse responseError = gson.fromJson(response.errorBody().charStream(), ErrorResponse.class);
                        responseCallback.onServerError(responseError);
                    }
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                UploadRepositoryCacheUtil.addFileToSendCache(url, contentType, fileName, context);
                if (responseCallback != null) {
                    responseCallback.onError(t.getMessage());
                }
            }
        };
    }
}
