package com.creatubbles.api.model.creation;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("data")
    private Data data;

    public Data getData() {
        return data;
    }
}
