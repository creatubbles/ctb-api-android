package com.creatubbles.api.model;

import com.creatubbles.api.ImageStatus;
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

    public ImageStatus getImageStatus() {
        return ImageStatus.getStatus(creation.getAttributes().getImageStatus());
    }
}
