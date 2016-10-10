
package com.creatubbles.api.model.user;

import com.google.gson.annotations.SerializedName;

import java.util.Collections;
import java.util.List;

public class Meta {

    @SerializedName("total_pages")
    private Integer totalPages;

    @SerializedName("total_count")
    private Integer totalCount;

    @SerializedName("current_page")
    private Integer currentPage;

    @SerializedName("abilities")
    private List<Ability> abilities = Collections.emptyList();

    @SerializedName("user_bubbled_users")
    private List<String> userBubbledUsers = Collections.emptyList();

    @SerializedName("followed_users")
    private List<String> followedUsers = Collections.emptyList();

    public Integer getTotalPages() {
        return totalPages;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public List<String> getUserBubbledUsers() {
        return userBubbledUsers;
    }

    public List<String> getFollowedUsers() {
        return followedUsers;
    }
}
