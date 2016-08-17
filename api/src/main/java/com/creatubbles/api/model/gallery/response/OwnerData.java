package com.creatubbles.api.model.gallery.response;

import com.google.gson.annotations.SerializedName;

public class OwnerData {

    @SerializedName("id")
    private String id;

    @SerializedName("type")
    private String type;

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}
