package com.creatubbles.api.model.user;

import com.creatubbles.api.response.ResponseCallback;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Type;

/**
 * Class wraps up parameters required for a request used to create multiple Creators managed
 * by current user. Creators can be assigned to specific group.
 * <br />
 * To create an instance of this class use {@link Builder}.
 *
 * @author Pawel Szymanski
 * @see com.creatubbles.api.repository.UserRepository#createMultipleCreators(MultipleCreators, ResponseCallback)
 */
@Type("creator_builder_jobs")
public class MultipleCreators {
    @Id
    private String id;

    private Integer amount;

    @JsonProperty("birth_year")
    private Integer birthYear;

    private String group;

    @JsonCreator
    private MultipleCreators() {
    }

    MultipleCreators(Integer amount, Integer birthYear, String group) {
        this.amount = amount;
        this.birthYear = birthYear;
        this.group = group;
    }

    public static class Builder {
        Integer amount;
        Integer birthYear;
        String group;

        /**
         * @param amount    the amount of creators to add
         * @param birthYear integer between 1900 and [last year]
         */
        public Builder(Integer amount, Integer birthYear) {
            this.amount = amount;
            this.birthYear = birthYear;
        }

        /**
         * @param group to add creators to
         */
        public Builder setGroup(String group) {
            this.group = group;
            return this;
        }

        public MultipleCreators build() {
            return new MultipleCreators(amount, birthYear, group);
        }
    }

    public String getId() {
        return id;
    }

    public Integer getAmount() {
        return amount;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "MultipleCreators{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", birthYear=" + birthYear +
                ", group='" + group + '\'' +
                '}';
    }
}
