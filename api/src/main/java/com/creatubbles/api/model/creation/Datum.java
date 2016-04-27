package com.creatubbles.api.model.creation;

import com.google.gson.annotations.SerializedName;

public class Datum {

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
