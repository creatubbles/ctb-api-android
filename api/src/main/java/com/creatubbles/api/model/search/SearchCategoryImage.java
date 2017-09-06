package com.creatubbles.api.model.search;

import com.creatubbles.api.model.ImageLinks;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchCategoryImage {
    @JsonProperty("links")
    private ImageLinks links;

    public ImageLinks getLinks() {
        return links;
    }

    @Override
    public String toString() {
        return "Image{" +
                "links=" + links +
                '}';
    }
}
