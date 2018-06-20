package com.creatubbles.api.model.user;

import android.support.annotation.NonNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.models.EmptyRelationship;

import java.util.List;

@Type("user")
public class NewUser extends EmptyRelationship {

    @Id
    private String id; // this is unused field required by jsonapi-converter

    private String name;

    @JsonProperty("display_name")
    private String displayName;

    @JsonProperty("birth_year")
    private Integer birthYear;

    @JsonProperty("birth_month")
    private Integer birthMonth;

    private String country;

    @JsonProperty("personalized_avatar_source_url")
    private String avatarUrl;

    @JsonProperty("interest_list")
    private List<String> interests;

    @SuppressWarnings("WeakerAccess")
    NewUser(Builder builder) {
        this.name = builder.name;
        this.displayName = builder.displayName;
        this.birthMonth = builder.birthMonth;
        this.birthYear = builder.birthYear;
        this.country = builder.country;
        this.avatarUrl = builder.avatarUrl;
        this.interests = builder.interests;
    }

    public static class Builder {

        final String name;
        String displayName;
        Integer birthYear;
        Integer birthMonth;
        String country;
        String avatarUrl;
        List<String> interests;

        public Builder(@NonNull String name) {
            this.name = name;
        }

        @NonNull
        public Builder displayName(@NonNull String displayName) {
            this.displayName = displayName;
            return this;
        }

        @NonNull
        public Builder birthYear(int birthYear) {
            this.birthYear = birthYear;
            return this;
        }

        @NonNull
        public Builder birthMonth(int birthMonth) {
            this.birthMonth = birthMonth;
            return this;
        }

        @NonNull
        public Builder country(String country) {
            this.country = country;
            return this;
        }

        @NonNull
        public Builder avatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
            return this;
        }

        @NonNull
        public Builder setInterests(List<String> interests) {
            this.interests = interests;
            return this;
        }

        @NonNull
        public NewUser build() {
            return new NewUser(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public Integer getBirthMonth() {
        return birthMonth;
    }

    public String getCountry() {
        return country;
    }

    public List<String> getInterests() {
        return interests;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    @Override
    public String toString() {
        return "NewUser{" +
                "name='" + name + '\'' +
                ", displayName='" + displayName + '\'' +
                ", birthYear=" + birthYear +
                ", birthMonth=" + birthMonth +
                ", country='" + country + '\'' +
                '}';
    }
}
