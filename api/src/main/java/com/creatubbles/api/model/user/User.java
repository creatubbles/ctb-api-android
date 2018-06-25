package com.creatubbles.api.model.user;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.model.school.School;
import com.creatubbles.api.model.user.custom_style.CustomStyle;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.models.EmptyRelationship;

import java.util.Date;

@Type("users")
public class User extends EmptyRelationship {

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
    private boolean signedUpAsInstructor;

    @JsonProperty("home_schooling")
    private boolean homeSchooling;

    @JsonProperty("what_do_you_teach")
    private String whatDoYouTeach;

    private String interests;

    @Relationship("custom_style")
    private CustomStyle customStyle;

    @Relationship("school")
    private School school;

    @JsonProperty("followed_users_count")
    private Integer followedUsersCount;

    @JsonProperty("followers_count")
    private Integer followersCount;

    @JsonProperty("followed_hashtags_count")
    private Integer followedHashtagsCount;

    @JsonProperty("bubbles_on_creations_count")
    private Integer bubblesOnCreationsCount = 0;

    @JsonProperty("requires_guardian_approval")
    private boolean requiresGuardianApproval;

    @JsonProperty("last_guardian_approval_email")
    private String lastGuardianApprovalEmail;

    public static User withId(String id) {
        return new User(id);
    }

    @JsonCreator
    public User() {
    }

    private User(String id) {
        this.id = id;
    }

    @NonNull
    public String getId() {
        return id;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    @NonNull
    public String getDisplayName() {
        return displayName;
    }

    @NonNull
    public String getName() {
        return name;
    }

    /**
     * Method returns role set at sign-up and can be either ‘creator’, 'parent’ or 'instructor’.
     */
    @NonNull
    public Role getRole() {
        return role;
    }

    @NonNull
    public Date getCreatedAt() {
        return createdAt;
    }

    @NonNull
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

    @NonNull
    public Integer getAddedBubblesCount() {
        return addedBubblesCount;
    }

    /**
     * @return number of activities on this user.
     */
    @NonNull
    public Integer getActivitiesCount() {
        return activitiesCount;
    }

    /**
     * @return number of bubbles this user received
     */
    @NonNull
    public Integer getBubblesCount() {
        return bubblesCount;
    }

    /**
     * @return number of comments this user received
     */
    @NonNull
    public Integer getCommentsCount() {
        return commentsCount;
    }

    /**
     * @return number of creations the user created
     */
    @NonNull
    public Integer getCreationsCount() {
        return creationsCount;
    }

    /**
     * @return number of creators
     */
    @NonNull
    public Integer getCreatorsCount() {
        return creatorsCount;
    }

    /**
     * @return number of galleries the user created
     */
    @NonNull
    public Integer getGalleriesCount() {
        return galleriesCount;
    }

    /**
     * @return number of managers for this user
     */
    @NonNull
    public Integer getManagersCount() {
        return managersCount;
    }

    @NonNull
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

    public boolean getSignedUpAsInstructor() {
        return signedUpAsInstructor;
    }

    public boolean getHomeSchooling() {
        return homeSchooling;
    }

    @NonNull
    public String getListName() {
        return listName;
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

    @Nullable
    public School getSchool() {
        return school;
    }

    @Nullable
    public CustomStyle getCustomStyle() {
        return customStyle;
    }

    public Integer getFollowedUsersCount() {
        return followedUsersCount;
    }

    public Integer getFollowersCount() {
        return followersCount;
    }

    public Integer getFollowedHashtagsCount() {
        return followedHashtagsCount;
    }

    public Integer getBubblesOnCreationsCount() {
        return bubblesOnCreationsCount;
    }

    public boolean isRequiresGuardianApproval() {
        return requiresGuardianApproval;
    }

    @Nullable
    public String getLastGuardianApprovalEmail() {
        return lastGuardianApprovalEmail;
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
                ", customStyle=" + customStyle +
                ", school=" + school +
                ", followedUsersCount=" + followedUsersCount +
                ", followersCount=" + followersCount +
                ", followedHashtagsCount=" + followedHashtagsCount +
                ", bubblesOnCreationsCount=" + bubblesOnCreationsCount +
                '}';
    }
}
