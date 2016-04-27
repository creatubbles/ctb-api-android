package com.creatubbles.api.model.upload;

import com.google.gson.annotations.SerializedName;

public class Relationships {

    @SerializedName("creation")
    private Creation creation;

    public Creation getCreation() {
        return creation;
    }

}
