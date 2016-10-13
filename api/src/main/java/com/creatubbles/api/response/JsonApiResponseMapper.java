package com.creatubbles.api.response;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.Meta;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import retrofit2.Response;


public class JsonApiResponseMapper<T> extends BaseResponseMapper<JSONAPIDocument<T>, CreatubblesResponse<T>> {


    public JsonApiResponseMapper(ObjectMapper objectMapper, ResponseCallback<CreatubblesResponse<T>> responseCallback) {
        super(objectMapper, responseCallback);
    }

    @Override
    protected CreatubblesResponse<T> processResponse(Response<JSONAPIDocument<T>> response) {
        JSONAPIDocument<T> jsonapiDocument = response.body();
        T data = jsonapiDocument.get();
        Meta meta = jsonapiDocument.getMeta(Meta.class);
        return new CreatubblesResponse<>(data, meta, jsonapiDocument.getLinks());
    }
}
