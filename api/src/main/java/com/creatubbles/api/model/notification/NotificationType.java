package com.creatubbles.api.model.notification;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author Pawel Szymanski
 */
public enum NotificationType {
    /**
     * New creation published
     * <p>
     * Included objects: creation
     * </p>
     */
    NEW_CREATION("new_creation"),
    /**
     * Creation was bubbled
     * <p>
     * Included objects: creation
     * </p>
     */
    BUBBLED_CREATION("bubbled_creation"),
    /**
     * New comment on either of: creation, gallery, user.
     * <p>
     * Included objects: comment and one of those: creation, gallery or user.
     * </p>
     */
    NEW_COMMENT("new_comment"),
    /**
     * New follower
     * <p>
     * Included objects: user
     * </p>
     */
    FOLLOWED_CREATOR("followed_creator"),
    /**
     * New submission to a gallery
     * <p>
     * Included objects: gallery, gallery_submission
     * </p>
     */
    NEW_SUBMISSION("new_submission"),
    ANOTHER_COMMENT("another_comment"),
    MULTIPLE_CREATORS_CREATED("multiple_creators_created");

    private String name;

    @JsonCreator
    NotificationType(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }
}
