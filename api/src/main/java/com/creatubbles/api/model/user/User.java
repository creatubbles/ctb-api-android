package com.creatubbles.api.model.user;

import android.support.annotation.Nullable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Type;

import java.util.Date;

@Type("users")
public class User {

    @Id
    private String id;

    private String username;

    @JsonProperty("display_name")
    private String displayName;

    @JsonProperty("list_name")
    private String listName;

    private String name;

    private Role role;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("updated_at")
    private Date updatedAt;

    @JsonProperty("avatar_url")
    private String avatarUrl;

    private String age;

    @Deprecated
    private String gender;

    @JsonProperty("last_bubbled_at")
    private Date lastBubbledAt;

    @JsonProperty("last_commented_at")
    private Date lastCommentedAt;

    @JsonProperty("added_bubbles_count")
    private Integer addedBubblesCount;

    @JsonProperty("activities_count")
    private Integer activitiesCount;

    @JsonProperty("bubbles_count")
    private Integer bubblesCount;

    @JsonProperty("comments_count")
    private Integer commentsCount;

    @JsonProperty("creations_count")
    private Integer creationsCount;

    @JsonProperty("creators_count")
    private Integer creatorsCount;

    @JsonProperty("galleries_count")
    private Integer galleriesCount;

    @JsonProperty("managers_count")
    private Integer managersCount;

    @JsonProperty("short_url")
    private String shortUrl;

    @JsonProperty("country_code")
    private String countryCode;

    @JsonProperty("country_name")
    private String countryName;

    @JsonProperty("signed_up_as_instructor")
    private Boolean signedUpAsInstructor;

    @JsonProperty("home_schooling")
    private Boolean homeSchooling;

    @JsonProperty("what_do_you_teach")
    private String whatDoYouTeach;

    private String interests;

    public static User withId(String id) {
        return new User(id);
    }

    @JsonCreator
    private User() {
    }

    private User(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getName() {
        return name;
    }

    /**
     * Method returns role set at sign-up and can be either ‘creator’, 'parent’ or 'instructor’.
     */
    public Role getRole() {
        return role;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    @Nullable
    public String getAvatarUrl() {
        return avatarUrl;
    }

    @Nullable
    public String getAge() {
        return age;
    }

    @Nullable
    public Date getLastBubbledAt() {
        return lastBubbledAt;
    }

    @Nullable
    public Date getLastCommentedAt() {
        return lastCommentedAt;
    }

    public Integer getAddedBubblesCount() {
        return addedBubblesCount;
    }

    /**
     * @return number of activities on this user.
     */
    public Integer getActivitiesCount() {
        return activitiesCount;
    }

    /**
     * @return number of bubbles this user received
     */
    public Integer getBubblesCount() {
        return bubblesCount;
    }

    /**
     * @return number of comments this user received
     */
    public Integer getCommentsCount() {
        return commentsCount;
    }

    /**
     * @return number of creations the user created
     */
    public Integer getCreationsCount() {
        return creationsCount;
    }

    /**
     * @return number of creators
     */
    public Integer getCreatorsCount() {
        return creatorsCount;
    }

    /**
     * @return number of galleries the user created
     */
    public Integer getGalleriesCount() {
        return galleriesCount;
    }

    /**
     * @return number of managers for this user
     */
    public Integer getManagersCount() {
        return managersCount;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    @Nullable
    public String getCountryCode() {
        return countryCode;
    }

    @Nullable
    public String getCountryName() {
        return countryName;
    }

    public Boolean getSignedUpAsInstructor() {
        return signedUpAsInstructor;
    }

    @Nullable
    public Boolean getHomeSchooling() {
        return homeSchooling;
    }

    public String getListName() {
        return listName;
    }

    @Deprecated
    public String getGender() {
        return gender;
    }

    /**
     * Method returns value set in user's profile in "What do you teach?" (Teachers only).
     *
     * @return value set in "What do you teach?" field
     */
    @Nullable
    public String getWhatDoYouTeach() {
        return whatDoYouTeach;
    }

    /**
     * Method returns value set in user's profile in "Interests" (Teachers only).
     *
     * @return value set in "Interests" field
     */
    @Nullable
    public String getInterests() {
        return interests;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", displayName='" + displayName + '\'' +
                ", listName='" + listName + '\'' +
                ", name='" + name + '\'' +
                ", role=" + role +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", lastBubbledAt=" + lastBubbledAt +
                ", lastCommentedAt=" + lastCommentedAt +
                ", addedBubblesCount=" + addedBubblesCount +
                ", activitiesCount=" + activitiesCount +
                ", bubblesCount=" + bubblesCount +
                ", commentsCount=" + commentsCount +
                ", creationsCount=" + creationsCount +
                ", creatorsCount=" + creatorsCount +
                ", galleriesCount=" + galleriesCount +
                ", managersCount=" + managersCount +
                ", shortUrl='" + shortUrl + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", countryName='" + countryName + '\'' +
                ", signedUpAsInstructor=" + signedUpAsInstructor +
                ", homeSchooling=" + homeSchooling +
                ", whatDoYouTeach='" + whatDoYouTeach + '\'' +
                ", interests='" + interests + '\'' +
                '}';
    }
}
