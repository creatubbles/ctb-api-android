package com.creatubbles.api.model.user;

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
        Integer gender;

        public Builder(String name) {
            this.name = name;
        }

        public Builder displayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        public Builder birthYear(Integer birthYear) {
            this.birthYear = birthYear;
            return this;
        }

        public Builder birthMonth(Integer birthMonth) {
            this.birthMonth = birthMonth;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Builder gender(Integer gender) {
            this.gender = gender;
            return this;
        }

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
