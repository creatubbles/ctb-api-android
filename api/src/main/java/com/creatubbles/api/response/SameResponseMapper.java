package com.creatubbles.api.response;

import retrofit2.Response;

public class SameResponseMapper<T> extends BaseResponseMapper<T, T> {
    public SameResponseMapper(ResponseCallback<T> responseCallback) {
        super(responseCallback);
    }

    @Override
    protected T processResponse(Response<T> response) {
        return response.body();
    }
}
