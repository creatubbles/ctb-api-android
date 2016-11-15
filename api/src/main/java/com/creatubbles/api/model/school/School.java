
package com.creatubbles.api.model.school;

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

    @JsonCreator
    public School() {
    }

    @SuppressWarnings("WeakerAccess")
    School(String name, String countryCode) {
        this.name = name;
        this.countryCode = countryCode;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    @Override
    public String toString() {
        return "School{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }

    public static class Builder {
        private final String name;
        private final String countryCode;

        public Builder(String name, String countryCode) {
            this.name = name;
            this.countryCode = countryCode;
        }

        public School build() {
            return new School(name, countryCode);
        }
    }
}
