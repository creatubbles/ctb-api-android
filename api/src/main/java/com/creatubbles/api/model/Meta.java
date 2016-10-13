package com.creatubbles.api.model;

import com.creatubbles.api.converter.AbilitiesConverter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

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

    @JsonDeserialize(using = AbilitiesConverter.class)
    private List<Ability> abilities;

    public Integer getTotalPages() {
        return totalPages;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public List<String> getBubbledCreations() {
        return unmodifiableList(userBubbledCreations);
    }

    public List<String> getBubbledGalleries() {
        return unmodifiableList(userBubbledGalleries);
    }

    public List<String> getBubbledUsers() {
        return unmodifiableList(userBubbledUsers);
    }

    public List<String> getFollowedUsers() {
        return unmodifiableList(followedUsers);
    }

    public List<Ability> getAbilities() {
        return unmodifiableList(abilities);
    }
}