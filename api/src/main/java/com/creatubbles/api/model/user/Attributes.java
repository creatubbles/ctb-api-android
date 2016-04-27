package com.creatubbles.api.model.user;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Attributes {

    @SerializedName("username")
    private String username;

    @SerializedName("display_name")
    private String displayName;

    @SerializedName("name")
    private String name;

    @SerializedName("role")
    private String role;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("avatar_url")
    private String avatarUrl;

    @SerializedName("bubbled_by_user_ids")
    private List<Object> bubbledByUserIds = new ArrayList<Object>();

    @SerializedName("birth_month")
    private Object birthMonth;

    @SerializedName("birth_year")
    private Integer birthYear;

    @SerializedName("age")
    private String age;

    @SerializedName("is_male")
    private Boolean isMale;

    @SerializedName("groups")
    private List<Group> groups = new ArrayList<>();

    @SerializedName("last_bubbled_at")
    private Object lastBubbledAt;

    @SerializedName("last_commented_at")
    private Object lastCommentedAt;

    @SerializedName("added_bubbles_count")
    private Integer addedBubblesCount;

    @SerializedName("activities_count")
    private Integer activitiesCount;

    @SerializedName("bubbles_count")
    private Integer bubblesCount;

    @SerializedName("comments_count")
    private Integer commentsCount;

    @SerializedName("creations_count")
    private Integer creationsCount;

    @SerializedName("creators_count")
    private Integer creatorsCount;

    @SerializedName("galleries_count")
    private Integer galleriesCount;

    @SerializedName("managers_count")
    private Integer managersCount;

    @SerializedName("short_url")
    private String shortUrl;

    @SerializedName("gsp_seen")
    private Boolean gspSeen;

    @SerializedName("uep_unwanted")
    private Boolean uepUnwanted;

    @SerializedName("loggable")
    private Boolean loggable;

    @SerializedName("owned_tags")
    private List<Object> ownedTags = new ArrayList<Object>();

    @SerializedName("country_code")
    private String countryCode;

    @SerializedName("country_name")
    private String countryName;

    @SerializedName("is_partner")
    private Boolean isPartner;

    @SerializedName("signed_up_as_instructor")
    private Boolean signedUpAsInstructor;

    @SerializedName("home_schooling")
    private Boolean homeSchooling;

    public String getUsername() {
        return username;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public List<Object> getBubbledByUserIds() {
        return bubbledByUserIds;
    }

    public Object getBirthMonth() {
        return birthMonth;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public String getAge() {
        return age;
    }

    public Boolean getIsMale() {
        return isMale;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public Object getLastBubbledAt() {
        return lastBubbledAt;
    }

    public Object getLastCommentedAt() {
        return lastCommentedAt;
    }

    public Integer getAddedBubblesCount() {
        return addedBubblesCount;
    }

    public Integer getActivitiesCount() {
        return activitiesCount;
    }

    public Integer getBubblesCount() {
        return bubblesCount;
    }

    public Integer getCommentsCount() {
        return commentsCount;
    }

    public Integer getCreationsCount() {
        return creationsCount;
    }

    public Integer getCreatorsCount() {
        return creatorsCount;
    }

    public Integer getGalleriesCount() {
        return galleriesCount;
    }

    public Integer getManagersCount() {
        return managersCount;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public Boolean getGspSeen() {
        return gspSeen;
    }

    public Boolean getUepUnwanted() {
        return uepUnwanted;
    }

    public Boolean getLoggable() {
        return loggable;
    }

    public List<Object> getOwnedTags() {
        return ownedTags;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public Boolean getIsPartner() {
        return isPartner;
    }

    public Boolean getSignedUpAsInstructor() {
        return signedUpAsInstructor;
    }

    public Boolean getHomeSchooling() {
        return homeSchooling;
    }
}
