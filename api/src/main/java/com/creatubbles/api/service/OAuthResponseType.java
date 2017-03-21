package com.creatubbles.api.service;

public enum OAuthResponseType {
    CODE;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
