package com.creatubbles.api.model.user;


import com.creatubbles.api.exception.InvalidParametersException;
import com.creatubbles.api.model.creation.Creation;
import com.creatubbles.api.model.school.School;
import com.creatubbles.api.model.user.custom_style.AgeDisplayType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;

import java.util.Collections;
import java.util.Date;
import java.util.List;


/**
 * @author Pawel Szymanski
 */
@Type("accounts")
public class AccountDetails {

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
    AccountDetails(String username, String displayName, String name, String email, Integer birthMonth, Integer birthYear, AgeDisplayType ageDisplayType, String uiLocale, Boolean preapproveComments, Boolean receiveNotifications, Boolean receiveNewsletter, String whatDoYouTeach, String interests, String countryCode, Creation avatarCreation, School school) {
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
        this.countryCode = countryCode;
        this.avatarCreation = avatarCreation;
        this.school = school;
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

    public String getEmail() {
        return email;
    }

    public Integer getBirthMonth() {
        return birthMonth;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public AgeDisplayType getAgeDisplayType() {
        return ageDisplayType;
    }

    public String getUiLocale() {
        return uiLocale;
    }

    public List<String> getGroupList() {
        return groupList;
    }

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

    public String getWhatDoYouTeach() {
        return whatDoYouTeach;
    }

    public String getInterests() {
        return interests;
    }

    public Integer getManagedCreatorsCount() {
        return managedCreatorsCount;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getPendingAvatarUrl() {
        return pendingAvatarUrl;
    }

    public Date getPasswordUpdatedAt() {
        return passwordUpdatedAt;
    }

    public Date getCurrentSignInAt() {
        return currentSignInAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public User getUser() {
        return user;
    }

    public Creation getAvatarCreation() {
        return avatarCreation;
    }

    public School getSchool() {
        return school;
    }

    public Role getRole() {
        return role;
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
        private String countryCode;
        private Creation avatarCreation;
        private School school;


        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setDisplayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        /**
         * @param birthMonth number between 1 and 12
         */
        public Builder setBirthMonth(Integer birthMonth) {
            if (birthMonth < 0 || birthMonth > 12) {
                throw new InvalidParametersException("birthMonth has to be a number between 1 and 12 (inclusive)");
            }
            this.birthMonth = birthMonth;
            return this;
        }

        /**
         * @param birthYear number between 1900 and current year
         */
        public Builder setBirthYear(Integer birthYear) {
            if (birthYear < 1900) {
                throw new InvalidParametersException("birthYear can't be smaller than 1900");
            }
            this.birthYear = birthYear;
            return this;
        }

        public Builder setAgeDisplayType(AgeDisplayType ageDisplayType) {
            this.ageDisplayType = ageDisplayType;
            return this;
        }

        public Builder setUiLocale(String uiLocale) {
            this.uiLocale = uiLocale;
            return this;
        }

        public Builder setPreapproveComments(Boolean preapproveComments) {
            this.preapproveComments = preapproveComments;
            return this;
        }

        public Builder setReceiveNotifications(Boolean receiveNotifications) {
            this.receiveNotifications = receiveNotifications;
            return this;
        }

        public Builder setReceiveNewsletter(Boolean receiveNewsletter) {
            this.receiveNewsletter = receiveNewsletter;
            return this;
        }

        public Builder setWhatDoYouTeach(String whatDoYouTeach) {
            this.whatDoYouTeach = whatDoYouTeach;
            return this;
        }

        public Builder setInterests(String interests) {
            this.interests = interests;
            return this;
        }

        public Builder setCountryCode(String countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        public Builder setAvatarCreation(Creation avatarCreation) {
            this.avatarCreation = avatarCreation;
            return this;
        }

        public Builder setSchool(School school) {
            this.school = school;
            return this;
        }

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
                    countryCode, avatarCreation, school);
        }
    }
}
