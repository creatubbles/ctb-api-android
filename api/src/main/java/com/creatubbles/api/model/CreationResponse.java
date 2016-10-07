package com.creatubbles.api.model;

import com.creatubbles.api.model.creation.Creation;
import com.creatubbles.api.model.creation.Meta;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Janek on 11.02.2016.
 */
public class CreationResponse {

    @SerializedName("data")
    private Creation creation;

    @SerializedName("meta")
    private Meta meta;

    public Creation getCreation() {
        return creation;
    }

    public Meta getMeta() {
        return meta;
    }

    @Override
    public String toString() {
        return "CreationResponse{" +
                "creation=" + creation +
                ", meta=" + meta +
                '}';
    }
}
