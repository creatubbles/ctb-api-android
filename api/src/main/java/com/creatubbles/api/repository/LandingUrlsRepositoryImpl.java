package com.creatubbles.api.repository;

import com.creatubbles.api.model.landing_url.LandingUrl;
import com.creatubbles.api.model.landing_url.LandingUrlType;
import com.creatubbles.api.response.JsonApiResponseMapper;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.LandingUrlsService;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import java.util.List;

import retrofit2.Call;

/**
 * Created by Janek on 05.08.2016.
 */
public class LandingUrlsRepositoryImpl implements LandingUrlsRepository {

    private LandingUrlsService landingUrlsService;

    public LandingUrlsRepositoryImpl(LandingUrlsService landingUrlsService) {
        this.landingUrlsService = landingUrlsService;
    }

    @Override
    public void getLandingUrls(ResponseCallback<List<LandingUrl>> callback) {
        Call<JSONAPIDocument<List<LandingUrl>>> call = landingUrlsService.getLandingUrls();
        call.enqueue(new JsonApiResponseMapper<>(callback));
    }

    @Override
    public void getSpecificLandingUrl(LandingUrlType type, ResponseCallback<LandingUrl> callback) {
        Call<JSONAPIDocument<LandingUrl>> call = landingUrlsService.getLandingUrl(type.getRes());
        call.enqueue(new JsonApiResponseMapper<>(callback));
    }


}
