package com.creatubbles.api.model.notification;

import android.support.annotation.NonNull;

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
    MULTIPLE_CREATORS_CREATED("multiple_creators_created"),
    TRANSLATION_TIP("translation_tip"),
    CUSTOMIZE_TIP("customize_tip"),
    GALLERIES_TIP("galleries_tip"),
    BUBBLES_TIP("bubbles_tip"),
    UPLOAD_TIP("upload_tip"),
    RECEIVED_FAVORITE("received_favorite"),
    UNDEFINED("undefined");

    private String name;

    NotificationType(String name) {
        this.name = name;
    }

    @JsonCreator
    public static NotificationType forValue(String value) {
        for (NotificationType type : NotificationType.values()) {
            if (type.getName().equals(value)) {
                return type;
            }
        }
        return UNDEFINED;
    }

    @JsonValue
    @NonNull
    public String getName() {
        return name;
    }
}
