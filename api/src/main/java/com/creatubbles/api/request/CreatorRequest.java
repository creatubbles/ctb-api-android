package com.creatubbles.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Janek on 11.02.2016.
 */
public class CreatorRequest {

    private final String name;

    @JsonProperty("display_name")
    private final String displayName;

    @JsonProperty("birth_year")
    private final Integer birthYear;

    @JsonProperty("birth_month")
    private final Integer birthMonth;

    private final String country;

    private final Integer gender;

    @SuppressWarnings("WeakerAccess")
    CreatorRequest(Builder builder) {
        this.name = builder.name;
        this.displayName = builder.displayName;
        this.birthYear = builder.birthYear;
        this.birthMonth = builder.birthMonth;
        this.country = builder.country;
        this.gender = builder.gender;
    }

    public static class Builder {

        final String name;
        final String displayName;
        final Integer birthYear;
        final Integer birthMonth;
        final String country;
        Integer gender;

        public Builder(String name, String displayName, Integer birthYear, Integer birthMonth,
                       String country) {
            this.name = name;
            this.displayName = displayName;
            this.birthYear = birthYear;
            this.birthMonth = birthMonth;
            this.country = country;
        }

        public Builder gender(Integer gender) {
            this.gender = gender;
            return this;
        }

        public CreatorRequest build() {
            return new CreatorRequest(this);
        }
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

    public Integer getGender() {
        return gender;
    }


}
