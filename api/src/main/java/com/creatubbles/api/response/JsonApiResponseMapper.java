package com.creatubbles.api.response;

import com.github.jasminb.jsonapi.JSONAPIDocument;

import retrofit2.Response;

public class JsonApiResponseMapper<T> extends BaseResponseMapper<JSONAPIDocument<T>, T> {

    public JsonApiResponseMapper(ResponseCallback<T> responseCallback) {
        super(responseCallback);
    }

    @Override
    protected T processResponse(Response<JSONAPIDocument<T>> response) {
        return response.body().get();
    }
}
