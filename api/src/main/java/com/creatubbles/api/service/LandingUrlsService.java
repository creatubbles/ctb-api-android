package com.creatubbles.api.service;

import com.creatubbles.api.EndPoints;
import com.creatubbles.api.model.LandingUrlResponse;
import com.creatubbles.api.model.url.LandingUrl;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Janek on 05.08.2016.
 */
public interface LandingUrlsService {

    @GET(EndPoints.LANDING_URLS)
    Call<LandingUrlResponse> getLandingUrls();

    @GET(EndPoints.LANDING_URLS + "/{type}")
    Call<LandingUrl> getLandingUrl(@Path("type") String urlType);

}
