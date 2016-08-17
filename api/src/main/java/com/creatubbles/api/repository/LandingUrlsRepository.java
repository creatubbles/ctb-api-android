package com.creatubbles.api.repository;

import com.creatubbles.api.model.LandingUrlResponse;
import com.creatubbles.api.model.url.LandingUrl;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.LandingUrlType;

/**
 * Created by Janek on 05.08.2016.
 */
public interface LandingUrlsRepository {

    void getLandingUrls(ResponseCallback<LandingUrlResponse> callback);

    void getSpecificLandingUrl(LandingUrlType type, ResponseCallback<LandingUrl> callback);
}
