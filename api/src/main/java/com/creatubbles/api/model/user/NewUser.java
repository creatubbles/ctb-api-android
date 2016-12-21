package com.creatubbles.api.model.user;

import android.support.annotation.NonNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Type;

@Type("user")
public class NewUser {

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

    @SuppressWarnings("WeakerAccess")
    NewUser(Builder builder) {
        this.name = builder.name;
        this.displayName = builder.displayName;
        this.birthMonth = builder.birthMonth;
        this.birthYear = builder.birthYear;
        this.country = builder.country;
    }

    public static class Builder {

        final String name;
        String displayName;
        Integer birthYear;
        Integer birthMonth;
        String country;

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
