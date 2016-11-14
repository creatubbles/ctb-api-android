package com.creatubbles.api.service;

public enum GallerySortMode {

    POPULAR, RECENT;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
