package com.creatubbles.api.model.partner_application;

import android.support.annotation.NonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author Pawel Szymanski
 */
public enum VideoProvider {
    NONE(""),
    YOUTUBE("youtube"),
    VIMEO("vimeo");

    private String name;

    @JsonCreator
    VideoProvider(String name) {
        this.name = name;
    }

    @JsonValue
    @NonNull
    public String getName() {
        return name;
    }
}
