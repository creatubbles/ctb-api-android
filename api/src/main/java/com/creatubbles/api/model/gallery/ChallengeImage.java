package com.creatubbles.api.model.gallery;

import com.creatubbles.api.model.ImageLinks;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ChallengeImage {

    @JsonProperty("links")
    private ImageLinks links;

    @JsonCreator
    public ChallengeImage() {
    }

    public ImageLinks getLinks() {
        return links;
    }

    @Override
    public String toString() {
        return "ChallengeImage{" +
                "links=" + links +
                '}';
    }
}
