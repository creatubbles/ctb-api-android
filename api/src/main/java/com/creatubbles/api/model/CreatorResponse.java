package com.creatubbles.api.model;

import com.creatubbles.api.model.creation.Data;
import com.creatubbles.api.model.creation.Meta;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Janek on 11.02.2016.
 */
public class CreatorResponse {

    @SerializedName("data")
    private Data creator;

    @SerializedName("meta")
    private Meta meta;

    public Data getCreator() {
        return creator;
    }

    public Meta getMeta() {
        return meta;
    }
}
