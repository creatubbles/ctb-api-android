package com.creatubbles.api.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Janek on 11.02.2016.
 */
public class CreatorRequest {

    @SerializedName("name")
    private final String name;

    @SerializedName("display_name")
    private final String displayName;

    @SerializedName("birth_year")
    private final Integer birthYear;

    @SerializedName("birth_month")
    private final Integer birthMonth;

    @SerializedName("country")
    private final String country;

    @SerializedName("gender")
    private final Integer gender;

    public CreatorRequest(Builder builder) {
        this.name = builder.name;
        this.displayName = builder.displayName;
        this.birthYear = builder.birthYear;
        this.birthMonth = builder.birthMonth;
        this.country = builder.country;
        this.gender = builder.gender;
    }

    public static class Builder {

        private final String name;
        private final String displayName;
        private final Integer birthYear;
        private final Integer birthMonth;
        private final String country;
        private Integer gender;

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
