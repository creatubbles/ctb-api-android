package com.creatubbles.api.model;

import com.creatubbles.api.model.gallery.Gallery;
import com.creatubbles.api.model.gallery.Meta;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Janek on 10.02.2016.
 */
public class GalleryResponse {

    @SerializedName("data")
    private Gallery[] galleries;

    @SerializedName("meta")
    private Meta meta;

    public Meta getMeta() {
        return meta;
    }

    public Gallery[] getGalleries() {
        return galleries;
    }

}
