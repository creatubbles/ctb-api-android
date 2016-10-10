package com.creatubbles.api.model.user.custom_style;

import com.google.gson.annotations.SerializedName;

public class Data {
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
