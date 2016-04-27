package com.creatubbles.api.service;

/**
 * Created by Janek on 10.02.2016.
 */
public enum Sort {

    POPULAR, RECENT;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
