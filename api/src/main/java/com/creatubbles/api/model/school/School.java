
package com.creatubbles.api.model.school;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Type;

@Type("schools")
public class School {

    @Id
    private String id;

    private String name;

    @JsonProperty("country_code")
    private String countryCode;

    @JsonProperty("country_name")
    private String countryName;

    @JsonProperty("instructors_count")
    private Integer instructorsCount;

    @JsonProperty("avatar_url")
    private String avatarUrl;

    @JsonProperty("custom_style_header")
    private String customStyleHeader;

    @JsonCreator
    public School() {
    }

    @SuppressWarnings("WeakerAccess")
    School(String name, String countryCode) {
        this.name = name;
        this.countryCode = countryCode;
    }

    @NonNull
    public String getId() {
        return id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public Integer getInstructorsCount() {
        return instructorsCount;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * @return String containing CSS style of the school's header
     */
    @Nullable
    public String getCustomStyleHeader() {
        return customStyleHeader;
    }

    @Override
    public String toString() {
        return "School{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", countryName='" + countryName + '\'' +
                ", instructorsCount=" + instructorsCount +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", customStyleHeader='" + customStyleHeader + '\'' +
                '}';
    }

    public static class Builder {
        private final String name;
        private final String countryCode;

        public Builder(@NonNull String name, @NonNull String countryCode) {
            this.name = name;
            this.countryCode = countryCode;
        }

        @NonNull
        public School build() {
            return new School(name, countryCode);
        }
    }
}
