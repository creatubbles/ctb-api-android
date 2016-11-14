package com.creatubbles.api.service;

/**
 * @author Pawel Szymanski
 */
public enum UserSortMode {
    DISPLAY_NAME_ASC("display_name"),
    DISPLAY_NAME_DESC("-display_name"),
    AGE_ASC("age"),
    AGE_DESC("-age"),
    CREATION_DATE_ASC("created_at"),
    CREATION_DATE_DESC("-created_at");

    private String param;

    UserSortMode(String param) {
        this.param = param;
    }

    public String getParam() {
        return param;
    }
}
