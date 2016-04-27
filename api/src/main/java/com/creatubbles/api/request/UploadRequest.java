package com.creatubbles.api.request;

import com.creatubbles.api.ContentType;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Janek on 23.03.2016.
 */
public class UploadRequest {


    @SerializedName("extension")
    private String extension;

    public UploadRequest(ContentType contentType) {
        this.extension = contentType.getRes();
    }
}
