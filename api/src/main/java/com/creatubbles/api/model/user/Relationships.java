package com.creatubbles.api.model.user;

import com.creatubbles.api.model.school.School;
import com.creatubbles.api.model.user.custom_style.CustomStyle;
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
