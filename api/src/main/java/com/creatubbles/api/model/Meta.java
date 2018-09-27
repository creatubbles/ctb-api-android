package com.creatubbles.api.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.converter.AbilitiesConverter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;
import java.util.List;

import static java.util.Collections.emptyList;

public class Meta {

    @JsonProperty("total_pages")
    private Integer totalPages;

    @JsonProperty("total_count")
    private Integer totalCount;

    @JsonProperty("user_bubbled_creations")
    private List<String> userBubbledCreations = emptyList();

    @JsonProperty("user_bubbled_users")
    private List<String> userBubbledUsers = emptyList();

    @JsonProperty("user_bubbled_galleries")
    private List<String> userBubbledGalleries = emptyList();

    @JsonProperty("followed_users")
    private List<String> followedUsers = emptyList();

    @JsonProperty("total_unread_count")
    private Integer totalUnreadCount;

    @JsonProperty("total_new_count")
    private Integer totalNewCount;

    @JsonProperty("last_viewed_at")
    private Date lastViewedAt;

    @JsonDeserialize(using = AbilitiesConverter.class)
    private List<Ability> abilities = emptyList();

    private String code;

    @JsonProperty("followed_hashtags")
    private List<String> followedTags;

    @JsonProperty("favorite_creations")
    private List<String> favoriteCreations;

    @JsonProperty("favorite_users")
    private List<String> favoriteUsers;

    @JsonProperty("submitted_challenges")
    private List<String> submittedChallengesId;

    @JsonProperty("favorite_challenges")
    private List<String> favoriteChallengesId;

    @JsonProperty("owned_items")
    private List<String> ownedItems;

    @JsonProperty("items_in_use")
    private List<String> itemsInUse;

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
        return userBubbledCreations;
    }

    @Nullable
    public List<String> getBubbledGalleries() {
        return userBubbledGalleries;
    }

    @Nullable
    public List<String> getBubbledUsers() {
        return userBubbledUsers;
    }

    @Nullable
    public List<String> getFollowedUsers() {
        return followedUsers;
    }

    @Nullable
    public List<Ability> getAbilities() {
        return abilities;
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

    @Nullable
    public String getCode() {
        return code;
    }

    @Nullable
    public List<String> getFollowedTags() {
        return followedTags;
    }

    @NonNull
    public List<String> getSubmittedChallengesId() {
        return submittedChallengesId;
    }

    @NonNull
    public List<String> getFavoriteChallengesId() {
        return favoriteChallengesId;
    }

    @NonNull
    public List<String> getFavoriteCreations() {
        return favoriteCreations;
    }

    @NonNull
    public List<String> getFavoriteUsers() {
        return favoriteUsers;
    }

    @NonNull
    public List<String> getOwnedItems() {
        return ownedItems;
    }

    @NonNull
    public List<String> getItemsInUse() {
        return itemsInUse;
    }
}