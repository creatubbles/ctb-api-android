package com.creatubbles.api.model.user.custom_style;

import android.support.annotation.NonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author Pawel Szymanski
 */
public enum AgeDisplayType {
    DETAILED("detailed"),
    DECADE("decade"),
    DO_NOT_SHOW("dontshow");

    private String name;

    @JsonCreator
    AgeDisplayType(String name) {
        this.name = name;
    }

    @JsonValue
    @NonNull
    public String getName() {
        return name;
    }
}
