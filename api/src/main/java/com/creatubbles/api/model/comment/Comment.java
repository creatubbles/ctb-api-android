package com.creatubbles.api.model.comment;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.model.creation.Creation;
import com.creatubbles.api.model.gallery.Gallery;
import com.creatubbles.api.model.user.User;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.models.EmptyRelationship;

import java.util.Date;
import java.util.List;

/**
 * @author Pawel Szymanski
 */
@Type("comments")
public class Comment extends EmptyRelationship {
    @Id
    private String id;

    private String text;

    private boolean approved;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("commentable_type")
    private String commentableType;

    @Relationship("commenter")
    private User commenter;

    @Relationship("creation")
    private Creation creation;

    @Relationship("gallery")
    private Gallery gallery;

    @Relationship("user")
    private User user;

    @Relationship("mentions")
    private List<Mention> mentions;

    public static Comment create(String text) {
        return new Comment(text);
    }

    /**
     * Constructor needed for Jackson. Use {@link #create(String)} to create new comment.
     */
    @JsonCreator
    public Comment() {
    }

    private Comment(String text) {
        this.text = text;
    }

    @NonNull
    public String getId() {
        return id;
    }

    @NonNull
    public String getText() {
        return text;
    }

    public boolean isApproved() {
        return approved;
    }

    @NonNull
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @return instance of a {@code User} who created this comment
     */
    @NonNull
    public User getCommenter() {
        return commenter;
    }

    /**
     * @return instance of Creation for which this comment has been created to. {@code null} if comment was created for something else
     */
    @Nullable
    public Creation getCreation() {
        return creation;
    }

    /**
     * @return instance of Gallery for which this comment has been created to. {@code null} if comment was created for something else
     */
    @Nullable
    public Gallery getGallery() {
        return gallery;
    }

    /**
     * @return instance of User for which this comment has been created to. {@code null} if comment was created for something else
     */
    @Nullable
    public User getUser() {
        return user;
    }

    public List<Mention> getMentions() {
        return mentions;
    }
}
