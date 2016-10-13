package com.creatubbles.api.model.creation;

public class Image {

    private CreationImageLinks links;

    public CreationImageLinks getLinks() {
        return links;
    }

    @Override
    public String toString() {
        return "Image{" +
                "links=" + links +
                '}';
    }
}
