package com.creatubbles.api.model.creation;

import com.google.gson.annotations.SerializedName;

public class TranslatedName {

    @SerializedName("code")
    private String code;

    @SerializedName("name")
    private String name;

    @SerializedName("original")
    private Boolean original;

    /**
     * @return language code
     */
    public String getCode() {
        return code;
    }

    /**
     * @return name in given language
     */
    public String getName() {
        return name;
    }

    /**
     * @return value indicating whether this is the original entered by user (true) or translated (false) version
     */
    public Boolean getOriginal() {
        return original;
    }

    @Override
    public String toString() {
        return "TranslatedName{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", original=" + original +
                '}';
    }
}
