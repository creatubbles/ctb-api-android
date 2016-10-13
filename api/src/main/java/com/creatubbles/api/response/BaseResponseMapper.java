package com.creatubbles.api.response;

import com.creatubbles.api.exception.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Class implementing basic response mapping from retrofit. Use this class on it's own only when
 * response is empty (Void). That's because this class always returns null as a result.
 *
 * @param <T> type returned from retrofit
 * @param <C> type returned to caller through {@link ResponseCallback}
 * @see JsonApiResponseMapper
 * @see SameResponseMapper
 */
public class BaseResponseMapper<T, C> implements Callback<T> {
    private final ResponseCallback<C> responseCallback;
    private final ObjectMapper objectMapper;

    public BaseResponseMapper(ObjectMapper objectMapper, ResponseCallback<C> responseCallback) {
        this.objectMapper = objectMapper;
        this.responseCallback = responseCallback;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (responseCallback != null) {
            if (response.isSuccessful()) {
                responseCallback.onSuccess(processResponse(response));
            } else if (response.message() != null) {
                handleUnsuccessfulResponse(response);
            }
        }
    }

    protected void handleUnsuccessfulResponse(Response<T> response) {
        try {
            ErrorResponse errorResponse = getErrorResponse(response);
            responseCallback.onServerError(errorResponse);
        } catch (IOException e) {
            responseCallback.onError(e.getMessage());
        }
    }

    protected ErrorResponse getErrorResponse(Response<T> response) throws IOException {
        return objectMapper.readValue(response.errorBody().byteStream(), ErrorResponse.class);
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
