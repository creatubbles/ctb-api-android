package com.creatubbles.api.repository;

import com.creatubbles.api.model.LandingUrlResponse;
import com.creatubbles.api.model.url.LandingUrl;
import com.creatubbles.api.response.CallbackMapper;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.LandingUrlType;
import com.creatubbles.api.service.LandingUrlsService;

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
    public void getLandingUrls(ResponseCallback<LandingUrlResponse> callback) {
        Call<LandingUrlResponse> call = landingUrlsService.getLandingUrls();
        call.enqueue(new CallbackMapper<LandingUrlResponse>().map(callback));
    }

    @Override
    public void getSpecificLandingUrl(LandingUrlType type, ResponseCallback<LandingUrl> callback) {
        Call<LandingUrl> call = landingUrlsService.getLandingUrl(type.getRes());
        call.enqueue(new CallbackMapper<LandingUrl>().map(callback));
    }
}
