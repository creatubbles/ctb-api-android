package com.creatubbles.api.model.search;

import com.creatubbles.api.model.ImageLinks;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchCategoryImage {
    @JsonProperty("image")
    private ImageLinks image;

    public ImageLinks getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "Image{" +
                "image=" + image +
                '}';
    }
}
