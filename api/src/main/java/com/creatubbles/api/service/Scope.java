package com.creatubbles.api.service;

/**
 * Created by Janek on 10.02.2016.
 */
public enum Scope {
    MANAGERS, CREATORS;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
