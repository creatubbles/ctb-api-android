package com.creatubbles.api.model.gallery.response;

import com.google.gson.annotations.SerializedName;

public class Owner {

    @SerializedName("data")
    private OwnerData data;

    public OwnerData getData() {
        return data;
    }
}
