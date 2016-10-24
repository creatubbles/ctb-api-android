package com.creatubbles.api.service;

/**
 * @author Pawel Szymanski
 */
public enum GalleryFilter {
    /**
     * only list galleries this user created.
     */
    ONLY_OWNED,
    /**
     * only list galleries shared with the user (only available for own users).
     */
    ONLY_SHARED;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
