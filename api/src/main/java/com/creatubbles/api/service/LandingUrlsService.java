package com.creatubbles.api.service;

import com.creatubbles.api.EndPoints;
import com.creatubbles.api.model.landing_url.LandingUrl;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Janek on 05.08.2016.
 */
public interface LandingUrlsService {

    @GET(EndPoints.LANDING_URLS)
    Call<JSONAPIDocument<List<LandingUrl>>> getLandingUrls();

    @GET(EndPoints.LANDING_URLS + "/{type}")
    Call<JSONAPIDocument<LandingUrl>> getLandingUrl(@Path("type") String urlType);

}
