package com.creatubbles.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by Janek on 04.11.2016.
 */

public enum ObjectType {

    CREATION("creation"),
    GALLERY("gallery"),
    USER("user"),
    ACCOUNT("account"),
    COMMENT("comment"),
    BUBBLE("bubble"),
    PARTNER_APPLICATION("partner_application");

    private String typeName;

    @JsonCreator
    ObjectType(String typeName) {
        this.typeName = typeName;
    }

    @JsonValue
    public String getTypeName() {
        return typeName;
    }

}
