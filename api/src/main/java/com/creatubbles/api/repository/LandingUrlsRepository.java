package com.creatubbles.api.repository;

import com.creatubbles.api.model.CtbResponse;
import com.creatubbles.api.model.landing_url.LandingUrl;
import com.creatubbles.api.model.landing_url.LandingUrlType;
import com.creatubbles.api.response.ResponseCallback;

import java.util.List;

/**
 * Created by Janek on 05.08.2016.
 */
public interface LandingUrlsRepository {

    void getLandingUrls(ResponseCallback<CtbResponse<List<LandingUrl>>> callback);

    void getSpecificLandingUrl(LandingUrlType type, ResponseCallback<CtbResponse<LandingUrl>> callback);
}
