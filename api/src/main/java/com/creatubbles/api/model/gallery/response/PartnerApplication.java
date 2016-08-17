package com.creatubbles.api.model.gallery.response;

import com.google.gson.annotations.SerializedName;

public class PartnerApplication {

    @SerializedName("data")
    private Object data;

    public Object getData() {
        return data;
    }
}
