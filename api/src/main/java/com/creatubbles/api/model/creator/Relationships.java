package com.creatubbles.api.model.creator;

import com.google.gson.annotations.SerializedName;

public class Relationships {

    @SerializedName("school")
    private School school;

    @SerializedName("custom_style")
    private CustomStyle customStyle;


    public School getSchool() {
        return school;
    }

    public CustomStyle getCustomStyle() {
        return customStyle;
    }
}
