
package com.creatubbles.api.model.creator;

import com.google.gson.annotations.SerializedName;

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

    @SerializedName("age")
    private String age;

    @SerializedName("gender")
    private String gender;

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

    @SerializedName("is_young_creator")
    private Boolean isYoungCreator;

    @SerializedName("what_do_you_teach")
    private Object whatDoYouTeach;

    @SerializedName("interests")
    private Object interests;

    @SerializedName("list_name")
    private String listName;

    @SerializedName("country_code")
    private String countryCode;

    @SerializedName("country_name")
    private String countryName;

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

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
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

    public Boolean getYoungCreator() {
        return isYoungCreator;
    }

    public Object getWhatDoYouTeach() {
        return whatDoYouTeach;
    }

    public Object getInterests() {
        return interests;
    }

    public String getListName() {
        return listName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public Boolean getSignedUpAsInstructor() {
        return signedUpAsInstructor;
    }

    public Boolean getHomeSchooling() {
        return homeSchooling;
    }

    @Override
    public String toString() {
        return "Attributes{" +
                "username='" + username + '\'' +
                ", displayName='" + displayName + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
