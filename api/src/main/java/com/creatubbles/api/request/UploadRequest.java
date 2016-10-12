package com.creatubbles.api.request;

import com.creatubbles.api.ContentType;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Janek on 23.03.2016.
 */
public class UploadRequest {


    @JsonProperty("extension")
    private String extension;

    public UploadRequest(ContentType contentType) {
        this.extension = contentType.getRes();
    }

    public String getExtension() {
        return extension;
    }
}
