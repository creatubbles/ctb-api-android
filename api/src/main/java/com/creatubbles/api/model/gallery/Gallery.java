package com.creatubbles.api.model.gallery;

import com.google.gson.annotations.SerializedName;

public class Gallery {

    @SerializedName("id")
    private String id;

    @SerializedName("type")
    private String type;

    @SerializedName("attributes")
    private Attributes attributes;

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }


    public Attributes getAttributes() {
        return attributes;
    }


}
