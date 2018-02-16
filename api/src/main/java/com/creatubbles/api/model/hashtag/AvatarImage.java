package com.creatubbles.api.model.hashtag;

import android.support.annotation.Nullable;

import com.creatubbles.api.model.ImageLinks;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AvatarImage {
    @JsonProperty("links")
    private ImageLinks links;

    @Nullable
    public ImageLinks getLinks() {
        return links;
    }
}
