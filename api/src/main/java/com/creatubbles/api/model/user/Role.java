package com.creatubbles.api.model.user;

public enum Role {
    CREATOR("creator"),
    PARENT("parent"),
    INSTRUCTOR("instructor");

    private String roleName;

    Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public static Role fromName(String roleName) {
        for (Role role : values()) {
            if (role.roleName.equals(roleName)) {
                return role;
            }
        }
        return null;
    }
}
