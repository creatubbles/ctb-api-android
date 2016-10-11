package com.creatubbles.api.response;

import com.fasterxml.jackson.databind.ObjectMapper;

import retrofit2.Response;

public class SameResponseMapper<T> extends BaseResponseMapper<T, T> {
    public SameResponseMapper(ObjectMapper objectMapper, ResponseCallback<T> responseCallback) {
        super(objectMapper, responseCallback);
    }

    @Override
    protected T processResponse(Response<T> response) {
        return response.body();
    }
}
