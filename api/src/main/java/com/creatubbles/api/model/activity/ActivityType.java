package com.creatubbles.api.model.activity;

import android.support.annotation.NonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enum representing possible Activity types.
 *
 * @author Pawel Szymanski
 */
public enum ActivityType {
    /**
     * This value is indicating that an {@link Activity} represents one or more bubbles on a Creation referenced in {@link Activity#getCreation()}.
     * When it's a type of {@link Activity} then {@link Activity#getItemsCount()} will return number of bubbles.
     */
    CREATION_BUBBLED("creation.bubbled"),
    /**
     * This value is indicating that an {@link Activity} represents one or more Comment added to a Creation referenced in {@link Activity#getCreation()}.
     * When it's a type of {@link Activity} then {@link Activity#getItemsCount()} will return number of comments and {@link Activity#getRelatedComments()} will contain list of those.
     */
    CREATION_COMMENTED("creation.commented"),
    /**
     * Value indicating that an {@link Activity} having this type is representing publish event of Creation referenced in {@link Activity#getCreation()}.
     */
    CREATION_PUBLISHED("creation.published"),
    /**
     * This value is indicating that an {@link Activity} represents one or more bubbles on a Gallery referenced in {@link Activity#getGallery()}.
     * When it's a type of {@link Activity} then {@link Activity#getItemsCount()} will return number of bubbles.
     */
    GALLERY_BUBBLED("gallery.bubbled"),
    /**
     * This value is indicating that an {@link Activity} represents one or more Comment added to a Gallery referenced in {@link Activity#getGallery()}.
     * When it's a type of {@link Activity} then {@link Activity#getItemsCount()} will return number of comments and {@link Activity#getRelatedComments()} will contain list of those.
     */
    GALLERY_COMMENTED("gallery.commented"),
    /**
     * This value is indicating that an {@link Activity} represents an event of adding a Creation to a Gallery referenced in {@link Activity#getGallery()}.
     * When it's a type of {@link Activity} then {@link Activity#getItemsCount()} will return number of creations and {@link Activity#getRelatedCreations()} ()} will contain list of those.
     */
    GALLERY_CREATION_ADDED("gallery.creation_added"),
    /**
     * This value is indicating that an {@link Activity} represents one or more bubbles on a User referenced in {@link Activity#getUser()}.
     * When it's a type of {@link Activity} then {@link Activity#getItemsCount()} will return number of bubbles.
     */
    USER_BUBBLED("user.bubbled"),
    /**
     * This value is indicating that an {@link Activity} represents one or more Comment added to a User referenced in {@link Activity#getUser()}.
     * When it's a type of {@link Activity} then {@link Activity#getItemsCount()} will return number of comments and {@link Activity#getRelatedComments()} will contain list of those.
     */
    USER_COMMENTED("user.commented");


    private String name;

    @JsonCreator
    ActivityType(String name) {
        this.name = name;
    }

    @JsonValue
    @NonNull
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ActivityType{" +
                "name='" + name + '\'' +
                '}';
    }
}
