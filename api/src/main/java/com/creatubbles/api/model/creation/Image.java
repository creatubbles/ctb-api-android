package com.creatubbles.api.model.creation;

import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("links")
    private Links links;

    public Links getLinks() {
        return links;
    }

    @Override
    public String toString() {
        return "Image{" +
                "links=" + links +
                '}';
    }
}
