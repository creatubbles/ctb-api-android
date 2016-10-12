package com.creatubbles.api.model.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Role {
    CREATOR("creator"),
    PARENT("parent"),
    INSTRUCTOR("instructor");

    private String roleName;

    Role(String roleName) {
        this.roleName = roleName;
    }

    @JsonValue
    public String getRoleName() {
        return roleName;
    }

    @JsonCreator
    public static Role fromName(String roleName) {
        for (Role role : values()) {
            if (role.roleName.equals(roleName)) {
                return role;
            }
        }
        return null;
    }
}
