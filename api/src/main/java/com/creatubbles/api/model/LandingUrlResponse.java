package com.creatubbles.api.model;

import com.creatubbles.api.model.url.Data;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Janek on 05.08.2016.
 */
public class LandingUrlResponse {

    @SerializedName("data")
    private List<Data> landingUrlList = new ArrayList<>();

    public List<Data> getLandingUrlList() {
        return landingUrlList;
    }
}
