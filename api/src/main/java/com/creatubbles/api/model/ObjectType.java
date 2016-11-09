package com.creatubbles.api.model;

/**
 * Created by Janek on 04.11.2016.
 */

public enum ObjectType {

    CREATION("creation"),
    GALLERY("gallery"),
    USER("user"),
    ACCOUNT("account"),
    COMMENT("comment"),
    BUBBLE("bubble");

    private String typeName;

    ObjectType(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

}
