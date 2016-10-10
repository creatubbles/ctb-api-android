package com.creatubbles.api.response;

import com.creatubbles.api.exception.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @param <T> type returned from retrofit
 * @param <C> type returned to caller through {@link ResponseCallback}
 */
public class BaseResponseMapper<T, C> implements Callback<T> {
    private final ResponseCallback<C> responseCallback;

    public BaseResponseMapper(ResponseCallback<C> responseCallback) {
        this.responseCallback = responseCallback;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (responseCallback != null) {
            if (response.isSuccessful()) {
                responseCallback.onSuccess(processResponse(response));
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

    protected C processResponse(Response<T> response) {
        return null;
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        if (responseCallback != null) {
            responseCallback.onError(t.getMessage());
        }
    }


}
