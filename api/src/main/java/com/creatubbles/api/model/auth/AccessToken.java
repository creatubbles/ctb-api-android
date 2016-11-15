package com.creatubbles.api.model.auth;

/**
 * @author Pawel Szymanski
 */
public abstract class AccessToken {
    private final String token;
    private final String type;

    AccessToken(String token, String type) {
        this.token = token;
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public String getType() {
        return type;
    }
}
