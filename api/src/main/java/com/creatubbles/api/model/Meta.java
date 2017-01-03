package com.creatubbles.api.model;

import android.support.annotation.Nullable;

import com.creatubbles.api.converter.AbilitiesConverter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class Meta {

    @JsonProperty("total_pages")
    private Integer totalPages;

    @JsonProperty("total_count")
    private Integer totalCount;

    @JsonProperty("user_bubbled_creations")
    private List<String> userBubbledCreations;

    @JsonProperty("user_bubbled_users")
    private List<String> userBubbledUsers;

    @JsonProperty("user_bubbled_galleries")
    private List<String> userBubbledGalleries;

    @JsonProperty("followed_users")
    private List<String> followedUsers;

    @JsonProperty("total_unread_count")
    private Integer totalUnreadCount;

    @JsonProperty("total_new_count")
    private Integer totalNewCount;

    @JsonProperty("last_viewed_at")
    private Date lastViewedAt;

    @JsonDeserialize(using = AbilitiesConverter.class)
    private List<Ability> abilities;

    @Nullable
    public Integer getTotalPages() {
        return totalPages;
    }

    @Nullable
    public Integer getTotalCount() {
        return totalCount;
    }

    @Nullable
    public List<String> getBubbledCreations() {
        return unmodifiableList(userBubbledCreations);
    }

    @Nullable
    public List<String> getBubbledGalleries() {
        return unmodifiableList(userBubbledGalleries);
    }

    @Nullable
    public List<String> getBubbledUsers() {
        return unmodifiableList(userBubbledUsers);
    }

    @Nullable
    public List<String> getFollowedUsers() {
        return unmodifiableList(followedUsers);
    }

    @Nullable
    public List<Ability> getAbilities() {
        return unmodifiableList(abilities);
    }

    @Nullable
    public Integer getTotalUnreadCount() {
        return totalUnreadCount;
    }

    @Nullable
    public Integer getTotalNewCount() {
        return totalNewCount;
    }

    @Nullable
    public Date getLastViewedAt() {
        return lastViewedAt;
    }
}