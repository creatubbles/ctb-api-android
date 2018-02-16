package com.creatubbles.api.model;

import com.creatubbles.api.model.hashtag.Hashtag;
import com.creatubbles.api.model.user.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;

import java.util.Date;

@Type("followings")
public class Following {
    @Id
    private String id;

    @JsonProperty("created_at")
    private Date createdAt;

    @Relationship("follower")
    private User user;

    @Relationship("user")
    private User followedUser;

    @Relationship("hashtag")
    private Hashtag followedHashtag;

    public String getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public User getUser() {
        return user;
    }

    public User getFollowedUser() {
        return followedUser;
    }

    public Hashtag getFollowedHashtag() {
        return followedHashtag;
    }

    @Override
    public String toString() {
        return "Following{" +
                "id='" + id + '\'' +
                ", createdAt=" + createdAt +
                ", user=" + user +
                ", followedUser=" + followedUser +
                ", followedHashtag=" + followedHashtag +
                '}';
    }
}
