package com.creatubbles.api.model.user;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("data")
    private Data data;

    @SerializedName("meta")
    private Meta meta;

    public Data getData() {
        return data;
    }

    public Meta getMeta() {
        return meta;
    }
}
