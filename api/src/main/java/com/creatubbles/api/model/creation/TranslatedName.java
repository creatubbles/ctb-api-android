package com.creatubbles.api.model.creation;

import com.google.gson.annotations.SerializedName;

public class TranslatedName {

    @SerializedName("code")
    private String code;

    @SerializedName("name")
    private String name;

    @SerializedName("original")
    private Boolean original;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Boolean getOriginal() {
        return original;
    }
}
