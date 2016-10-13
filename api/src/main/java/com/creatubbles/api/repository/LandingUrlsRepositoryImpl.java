package com.creatubbles.api.repository;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.landing_url.LandingUrl;
import com.creatubbles.api.model.landing_url.LandingUrlType;
import com.creatubbles.api.response.JsonApiResponseMapper;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.LandingUrlsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import java.util.List;

import retrofit2.Call;

/**
 * Created by Janek on 05.08.2016.
 */
public class LandingUrlsRepositoryImpl implements LandingUrlsRepository {

    private LandingUrlsService landingUrlsService;
    private ObjectMapper objectMapper;

    public LandingUrlsRepositoryImpl(ObjectMapper objectMapper, LandingUrlsService landingUrlsService) {
        this.objectMapper = objectMapper;
        this.landingUrlsService = landingUrlsService;
    }

    @Override
    public void getLandingUrls(ResponseCallback<CreatubblesResponse<List<LandingUrl>>> callback) {
        Call<JSONAPIDocument<List<LandingUrl>>> call = landingUrlsService.getLandingUrls();
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getSpecificLandingUrl(LandingUrlType type, ResponseCallback<CreatubblesResponse<LandingUrl>> callback) {
        Call<JSONAPIDocument<LandingUrl>> call = landingUrlsService.getLandingUrl(type.getRes());
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }


}
