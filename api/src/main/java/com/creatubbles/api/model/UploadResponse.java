package com.creatubbles.api.model;

import com.creatubbles.api.model.upload.Data;
import com.google.gson.annotations.SerializedName;

public class UploadResponse {

    @SerializedName("data")
    private Data data;

    public Data getData() {
        return data;
    }

}
