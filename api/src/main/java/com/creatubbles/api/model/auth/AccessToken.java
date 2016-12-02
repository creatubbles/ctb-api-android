package com.creatubbles.api.model.auth;

import android.support.annotation.NonNull;

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

    @NonNull
    public String getToken() {
        return token;
    }

    @NonNull
    public String getType() {
        return type;
    }
}
