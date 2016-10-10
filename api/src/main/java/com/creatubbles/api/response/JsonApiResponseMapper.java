package com.creatubbles.api.response;

import com.creatubbles.api.exception.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JsonApiResponseMapper<T> implements Callback<JSONAPIDocument<T>> {
    private final ResponseCallback<T> responseCallback;

    public JsonApiResponseMapper(ResponseCallback<T> responseCallback) {
        this.responseCallback = responseCallback;
    }

    @Override
    public void onResponse(Call<JSONAPIDocument<T>> call, Response<JSONAPIDocument<T>> response) {
        if (responseCallback != null) {
            if (response.isSuccessful()) {
                responseCallback.onSuccess(response.body().get());
            } else if (response.message() != null) {
                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    ErrorResponse errorResponse = objectMapper.readValue(response.errorBody().byteStream(),
                            ErrorResponse.class);
                    responseCallback.onServerError(errorResponse);
                } catch (IOException e) {
                    responseCallback.onError(e.getMessage());
                }
            }
        }
    }

    @Override
    public void onFailure(Call<JSONAPIDocument<T>> call, Throwable t) {
        if (responseCallback != null) {
            responseCallback.onError(t.getMessage());
        }
    }
}
