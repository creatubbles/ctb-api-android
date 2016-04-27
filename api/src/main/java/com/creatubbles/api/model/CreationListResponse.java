package com.creatubbles.api.model;

import com.creatubbles.api.model.creation.Creation;
import com.creatubbles.api.model.creation.Meta;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Janek on 11.02.2016.
 */
public class CreationListResponse {

    @SerializedName("data")
    private Creation[] creations;

    @SerializedName("meta")
    private Meta meta;

    public Creation[] getCreations() {
        return creations;
    }

    public Meta getMeta() {
        return meta;
    }
}
