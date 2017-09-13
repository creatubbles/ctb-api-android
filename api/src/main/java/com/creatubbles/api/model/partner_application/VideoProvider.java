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
    VIMEO("vimeo"),
    DIRECT("ctbs3");

    private String name;

    VideoProvider(String name) {
        this.name = name;
    }

    @JsonCreator
    public static VideoProvider fromName(String name) {
        for (VideoProvider videoProvider : values()) {
            if (videoProvider.name.equals(name)) {
                return videoProvider;
            }
        }
        return NONE;
    }

    @JsonValue
    @NonNull
    public String getName() {
        return name;
    }
}
