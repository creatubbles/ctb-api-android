package com.creatubbles.api.model.creation;

import android.support.annotation.NonNull;

public class Image {

    private CreationImageLinks links;

    @NonNull
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
