package com.creatubbles.api.service;

/**
 * Created by Janek on 11.02.2016.
 */
public enum GrantType {
    PASSWORD, CLIENT_CREDENTIALS;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
