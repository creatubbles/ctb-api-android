package com.creatubbles.api.model.activity;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.model.comment.Comment;
import com.creatubbles.api.model.creation.Creation;
import com.creatubbles.api.model.gallery.Gallery;
import com.creatubbles.api.model.user.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;

import java.util.Date;
import java.util.List;

/**
 * Class representing an activity of several type.
 * All possible types can be found in {@link ActivityType}. Depending on the type this class will
 * return non-null
 *
 * @author Pawel Szymanski
 */
@Type("activities")
public class Activity {
    @Id
    private String id;

    @JsonProperty("key")
    private ActivityType type;

    private Integer count;

    @JsonProperty("items_count")
    private Integer itemsCount;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("last_updated_at")
    private Date lastUpdatedAt;

    @Relationship("owners")
    private List<User> owners;

    @Relationship("creation")
    private Creation creation;

    @Relationship("gallery")
    private Gallery gallery;

    @Relationship("user")
    private User user;

    @Relationship("related_creations")
    private List<Creation> relatedCreations;

    @Relationship("related_comments")
    private List<Comment> relatedComments;

    @NonNull
    public String getId() {
        return id;
    }

    @NonNull
    public ActivityType getType() {
        return type;
    }

    /**
     * @return number of activities
     */
    @NonNull
    public Integer getCount() {
        return count;
    }

    /**
     * @return number of items (related creations / comments / bubbles)
     */
    @NonNull
    public Integer getItemsCount() {
        return itemsCount;
    }

    @NonNull
    public Date getCreatedAt() {
        return createdAt;
    }

    @NonNull
    public Date getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    /**
     * @return list of users which triggered this activity
     */
    @Nullable
    public List<User> getOwners() {
        return owners;
    }

    /**
     * @return object representing Creation for which this activity has been triggered. Return value is not null
     * only when {@link #getType()} is one of those prefixed with {@code CREATION_}.
     */
    @Nullable
    public Creation getCreation() {
        return creation;
    }

    /**
     * @return object representing Gallery for which this activity has been triggered. Return value is not null
     * only when {@link #getType()} is one of those prefixed with {@code GALLERY_}.
     */
    @Nullable
    public Gallery getGallery() {
        return gallery;
    }

    /**
     * @return object representing User for which this activity has been triggered. Return value is not null
     * only when {@link #getType()} is one of those prefixed with {@code USER_}.
     */
    @Nullable
    public User getUser() {
        return user;
    }

    /**
     * @return list of related Creations. This is not null only when {@link #getType()} is {@link ActivityType#GALLERY_CREATION_ADDED}.
     * In this case this list will contain Creations added to Gallery.
     */
    @Nullable
    public List<Creation> getRelatedCreations() {
        return relatedCreations;
    }

    /**
     * @return list of comments created for either of Creation, Gallery or User. When {@link #getType()} is not suffixed with {@code _COMMENTED} then null is returned.
     */
    @Nullable
    public List<Comment> getRelatedComments() {
        return relatedComments;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id='" + id + '\'' +
                ", type=" + type +
                ", count=" + count +
                ", itemsCount=" + itemsCount +
                ", createdAt=" + createdAt +
                ", lastUpdatedAt=" + lastUpdatedAt +
                ", owners=" + owners +
                ", creation=" + creation +
                ", gallery=" + gallery +
                ", user=" + user +
                ", relatedCreations=" + relatedCreations +
                ", relatedComments=" + relatedComments +
                '}';
    }
}
