package com.creatubbles.api.model.user;

import android.support.annotation.NonNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;

import java.util.Date;

/**
 * Class representing follow relationship between users.
 *
 * @author Pawel Szymanski
 */
@Type("user_followings")
public class UserFollowing {

    @Id
    private String id;

    @JsonProperty("created_at")
    private Date createdAt;

    @Relationship("user")
    private User user;

    @Relationship("followed_user")
    private User followedUser;

    @NonNull
    public String getId() {
        return id;
    }

    @NonNull
    public Date getCreatedAt() {
        return createdAt;
    }

    public User getUser() {
        return user;
    }

    public User getFollowedUser() {
        return followedUser;
    }

    @Override
    public String toString() {
        return "UserFollowing{" +
                "id='" + id + '\'' +
                ", createdAt=" + createdAt +
                ", user=" + user +
                ", followedUser=" + followedUser +
                '}';
    }
}
