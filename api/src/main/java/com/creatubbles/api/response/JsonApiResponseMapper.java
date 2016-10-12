package com.creatubbles.api.response;

import com.creatubbles.api.model.CtbResponse;
import com.creatubbles.api.model.Meta;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import retrofit2.Response;


public class JsonApiResponseMapper<T> extends BaseResponseMapper<JSONAPIDocument<T>, CtbResponse<T>> {


    public JsonApiResponseMapper(ObjectMapper objectMapper, ResponseCallback<CtbResponse<T>> responseCallback) {
        super(objectMapper, responseCallback);
    }

    @Override
    protected CtbResponse<T> processResponse(Response<JSONAPIDocument<T>> response) {
        JSONAPIDocument<T> jsonapiDocument = response.body();
        T data = jsonapiDocument.get();
        Meta meta = jsonapiDocument.getMeta(Meta.class);
        return new CtbResponse<>(data, meta, jsonapiDocument.getLinks());
    }
}
