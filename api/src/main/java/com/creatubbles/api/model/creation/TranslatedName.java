package com.creatubbles.api.model.creation;

import android.support.annotation.NonNull;

public class TranslatedName {

    private String code;

    private String name;

    private boolean original;

    /**
     * @return language code
     */
    @NonNull
    public String getCode() {
        return code;
    }

    /**
     * @return name in given language
     */
    @NonNull
    public String getName() {
        return name;
    }

    /**
     * @return value indicating whether this is the original entered by user (true) or translated (false) version
     */
    public boolean isOriginal() {
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
