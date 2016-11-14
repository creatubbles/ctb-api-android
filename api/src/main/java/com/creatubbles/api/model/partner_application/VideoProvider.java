package com.creatubbles.api.model.partner_application;

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
    public String getName() {
        return name;
    }
}
