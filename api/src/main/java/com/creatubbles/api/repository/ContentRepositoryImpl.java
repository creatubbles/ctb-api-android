package com.creatubbles.api.repository;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.content.Content;
import com.creatubbles.api.response.JsonApiResponseMapper;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.ContentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import java.util.List;

import retrofit2.Call;

/**
 * Created by Mario Ostapowicz on 28.10.2016.
 */
public class ContentRepositoryImpl implements ContentRepository {

    private final ContentService contentService;
    private final ObjectMapper objectMapper;

    ContentRepositoryImpl(ObjectMapper objectMapper, ContentService contentService) {
        this.objectMapper = objectMapper;
        this.contentService = contentService;
    }

    @Override
    public void getContents(String query, ResponseCallback<CreatubblesResponse<List<Content>>> callback) {
        Call<JSONAPIDocument<List<Content>>> call = contentService.getContents(query);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }
}
