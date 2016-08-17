
package com.creatubbles.api.model.creator;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Meta {

    @SerializedName("total_pages")
    private Integer totalPages;

    @SerializedName("total_count")
    private Integer totalCount;

    @SerializedName("current_page")
    private Integer currentPage;

    @SerializedName("abilities")
    private List<Ability> abilities = new ArrayList<>();

    @SerializedName("user_bubbled_users")
    private List<Object> userBubbledUsers = new ArrayList<>();

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

    public List<Object> getUserBubbledUsers() {
        return userBubbledUsers;
    }
}
