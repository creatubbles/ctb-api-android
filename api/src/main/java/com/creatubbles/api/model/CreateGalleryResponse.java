package com.creatubbles.api.model;

import com.creatubbles.api.model.gallery.response.Data;
import com.google.gson.annotations.SerializedName;

public class CreateGalleryResponse {

    @SerializedName("data")
    private Data data;

    public Data getData() {
        return data;
    }
}
