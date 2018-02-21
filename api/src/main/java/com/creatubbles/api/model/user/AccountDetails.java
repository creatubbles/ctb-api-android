package com.creatubbles.api.model.user;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.exception.InvalidParametersException;
import com.creatubbles.api.model.creation.Creation;
import com.creatubbles.api.model.school.School;
import com.creatubbles.api.model.user.custom_style.AgeDisplayType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.models.EmptyRelationship;

import java.util.Collections;
import java.util.Date;
import java.util.List;


/**
 * @author Pawel Szymanski
 */
@Type("accounts")
public class AccountDetails extends EmptyRelationship {

    @Id
    private String id;

    private String username;

    @JsonProperty("display_name")
    private String displayName;

    private String name;

    private String email;

    private Role role;

    @JsonProperty("birth_month")
    private Integer birthMonth;

    @JsonProperty("birth_year")
    private Integer birthYear;

    @JsonProperty("age_display_type")
    private AgeDisplayType ageDisplayType;

    @JsonProperty("ui_locale")
    private String uiLocale;

    @JsonProperty("group_list")
    private List<String> groupList = Collections.emptyList();

    @JsonProperty("owned_tags")
    private List<String> ownedTags = Collections.emptyList();

    @JsonProperty("preapprove_comments")
    private Boolean preapproveComments;

    @JsonProperty("receive_notifications")
    private Boolean receiveNotifications;

    @JsonProperty("newsletter")
    private Boolean receiveNewsletter;

    @JsonProperty("what_do_you_teach")
    private String whatDoYouTeach;

    private String interests;

    @JsonProperty("interest_list")
    private List<String> interestsList;

    @JsonProperty("managed_creators_count")
    private Integer managedCreatorsCount;

    @JsonProperty("country_code")
    private String countryCode;

    @JsonProperty("pending_avatar_url")
    private String pendingAvatarUrl;

    @JsonProperty("password_updated_at")
    private Date passwordUpdatedAt;

    @JsonProperty("current_sign_in_at")
    private Date currentSignInAt;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("updated_at")
    private Date updatedAt;

    @Relationship("user")
    private User user;

    @Relationship("avatar_creation")
    private Creation avatarCreation;

    @Relationship("school")
    private School school;

    @JsonCreator
    public AccountDetails() {
    }

    @SuppressWarnings("WeakerAccess")
    AccountDetails(String username, String displayName, String name, String email, Integer birthMonth, Integer birthYear, AgeDisplayType ageDisplayType, String uiLocale, Boolean preapproveComments, Boolean receiveNotifications, Boolean receiveNewsletter, String whatDoYouTeach, String interests, List<String> interestsList, String countryCode, Creation avatarCreation) {
        this.username = username;
        this.displayName = displayName;
        this.name = name;
        this.email = email;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
        this.ageDisplayType = ageDisplayType;
        this.uiLocale = uiLocale;
        this.preapproveComments = preapproveComments;
        this.receiveNotifications = receiveNotifications;
        this.receiveNewsletter = receiveNewsletter;
        this.whatDoYouTeach = whatDoYouTeach;
        this.interests = interests;
        this.interestsList = interestsList;
        this.countryCode = countryCode;
        this.avatarCreation = avatarCreation;
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

    @NonNull
    public String getEmail() {
        return email;
    }

    @Nullable
    public Integer getBirthMonth() {
        return birthMonth;
    }

    @Nullable
    public Integer getBirthYear() {
        return birthYear;
    }

    @NonNull
    public AgeDisplayType getAgeDisplayType() {
        return ageDisplayType;
    }

    @NonNull
    public String getUiLocale() {
        return uiLocale;
    }

    @NonNull
    public List<String> getGroupList() {
        return groupList;
    }

    @NonNull
    public List<String> getOwnedTags() {
        return ownedTags;
    }

    public Boolean getPreapproveComments() {
        return preapproveComments;
    }

    public Boolean getReceiveNotifications() {
        return receiveNotifications;
    }

    public Boolean getReceiveNewsletter() {
        return receiveNewsletter;
    }

    @Nullable
    public String getWhatDoYouTeach() {
        return whatDoYouTeach;
    }

    @Nullable
    public String getInterests() {
        return interests;
    }

    @NonNull
    public Integer getManagedCreatorsCount() {
        return managedCreatorsCount;
    }

    @Nullable
    public String getCountryCode() {
        return countryCode;
    }

    @Nullable
    public String getPendingAvatarUrl() {
        return pendingAvatarUrl;
    }

    @Nullable
    public Date getPasswordUpdatedAt() {
        return passwordUpdatedAt;
    }

    @Nullable
    public Date getCurrentSignInAt() {
        return currentSignInAt;
    }

    @NonNull
    public Date getCreatedAt() {
        return createdAt;
    }

    @NonNull
    public Date getUpdatedAt() {
        return updatedAt;
    }

    @NonNull
    public User getUser() {
        return user;
    }

    @Nullable
    public Creation getAvatarCreation() {
        return avatarCreation;
    }

    @Nullable
    public School getSchool() {
        return school;
    }

    @NonNull
    public Role getRole() {
        return role;
    }

    @Nullable
    public List<String> getInterestsList() {
        return interestsList;
    }

    @Override
    public String toString() {
        return "AccountDetails{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", displayName='" + displayName + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", birthMonth=" + birthMonth +
                ", birthYear=" + birthYear +
                ", ageDisplayType=" + ageDisplayType +
                ", uiLocale='" + uiLocale + '\'' +
                ", groupList=" + groupList +
                ", ownedTags=" + ownedTags +
                ", preapproveComments=" + preapproveComments +
                ", receiveNotifications=" + receiveNotifications +
                ", receiveNewsletter=" + receiveNewsletter +
                ", whatDoYouTeach='" + whatDoYouTeach + '\'' +
                ", interests='" + interests + '\'' +
                ", managedCreatorsCount=" + managedCreatorsCount +
                ", countryCode='" + countryCode + '\'' +
                ", pendingAvatarUrl='" + pendingAvatarUrl + '\'' +
                ", passwordUpdatedAt=" + passwordUpdatedAt +
                ", currentSignInAt=" + currentSignInAt +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", user=" + user +
                ", avatarCreation=" + avatarCreation +
                ", school=" + school +
                '}';
    }

    public static class Builder {
        private String username;
        private String displayName;
        private String name;
        private String email;
        private Integer birthMonth;
        private Integer birthYear;
        private AgeDisplayType ageDisplayType;
        private String uiLocale;
        private Boolean preapproveComments;
        private Boolean receiveNotifications;
        private Boolean receiveNewsletter;
        private String whatDoYouTeach;
        private String interests;
        private List<String> interestsList;
        private String countryCode;
        private Creation avatarCreation;

        @NonNull
        public Builder setUsername(@NonNull String username) {
            this.username = username;
            return this;
        }

        @NonNull
        public Builder setDisplayName(@NonNull String displayName) {
            this.displayName = displayName;
            return this;
        }

        @NonNull
        public Builder setName(@NonNull String name) {
            this.name = name;
            return this;
        }

        @NonNull
        public Builder setEmail(@NonNull String email) {
            this.email = email;
            return this;
        }

        /**
         * @param birthMonth number between 1 and 12
         */
        @NonNull
        public Builder setBirthMonth(int birthMonth) {
            if (birthMonth < 0 || birthMonth > 12) {
                throw new InvalidParametersException("birthMonth has to be a number between 1 and 12 (inclusive)");
            }
            this.birthMonth = birthMonth;
            return this;
        }

        /**
         * @param birthYear number between 1900 and current year
         */
        @NonNull
        public Builder setBirthYear(int birthYear) {
            if (birthYear < 1900) {
                throw new InvalidParametersException("birthYear can't be smaller than 1900");
            }
            this.birthYear = birthYear;
            return this;
        }

        @NonNull
        public Builder setAgeDisplayType(@NonNull AgeDisplayType ageDisplayType) {
            this.ageDisplayType = ageDisplayType;
            return this;
        }

        @NonNull
        public Builder setUiLocale(@NonNull String uiLocale) {
            this.uiLocale = uiLocale;
            return this;
        }

        @NonNull
        public Builder setPreapproveComments(boolean preapproveComments) {
            this.preapproveComments = preapproveComments;
            return this;
        }

        @NonNull
        public Builder setReceiveNotifications(boolean receiveNotifications) {
            this.receiveNotifications = receiveNotifications;
            return this;
        }

        @NonNull
        public Builder setReceiveNewsletter(boolean receiveNewsletter) {
            this.receiveNewsletter = receiveNewsletter;
            return this;
        }

        @NonNull
        public Builder setWhatDoYouTeach(@NonNull String whatDoYouTeach) {
            this.whatDoYouTeach = whatDoYouTeach;
            return this;
        }

        @NonNull
        public Builder setInterests(@NonNull String interests) {
            this.interests = interests;
            return this;
        }

        @NonNull
        public Builder setInterests(@NonNull List<String> interests) {
            this.interestsList = interests;
            return this;
        }

        @NonNull
        public Builder setCountryCode(@NonNull String countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        @NonNull
        public Builder setAvatarCreation(@NonNull Creation avatarCreation) {
            this.avatarCreation = avatarCreation;
            return this;
        }

        @NonNull
        public AccountDetails build() {
            return new AccountDetails(username,
                    displayName,
                    name,
                    email,
                    birthMonth,
                    birthYear,
                    ageDisplayType,
                    uiLocale,
                    preapproveComments,
                    receiveNotifications,
                    receiveNewsletter,
                    whatDoYouTeach,
                    interests,
                    interestsList,
                    countryCode,
                    avatarCreation);
        }
    }
}
