package com.creatubbles.api.repository;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.content.Content;
import com.creatubbles.api.response.ResponseCallback;

import java.util.List;

/**
 * Created by Mario Ostapowicz on 28.10.2016.
 */

public interface ContentRepository {

    void getContents(String query, ResponseCallback<CreatubblesResponse<List<Content>>> callback);
}
