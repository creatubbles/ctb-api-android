package com.creatubbles.api.model.group;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.model.creation.Creation;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.models.EmptyRelationship;

@Type("groups")
public class Group extends EmptyRelationship {

    @Id
    private String id;

    private String name;

    private String slug;

    @JsonProperty("creators_count")
    private Integer creatorsCount;

    @JsonProperty("avatar_url")
    private String avatarUrl;

    @Relationship("avatar_creation")
    private Creation avatarCreation;

    @JsonCreator
    public Group() {
    }

    Group(String name, Creation avatarCreation) {
        this.name = name;
        this.avatarCreation = avatarCreation;
    }

    @NonNull
    public String getId() {
        return id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public String getSlug() {
        return slug;
    }

    @NonNull
    public Integer getCreatorsCount() {
        return creatorsCount;
    }

    /**
     * It's a shortcut for getting URL to avatar image.
     */
    @Nullable
    public String getAvatarUrl() {
        return avatarUrl;
    }

    @Nullable
    public Creation getAvatarCreation() {
        return avatarCreation;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", slug='" + slug + '\'' +
                ", creatorsCount=" + creatorsCount +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", avatarCreation=" + avatarCreation +
                '}';
    }

    public static class Builder {
        private String name;
        private Creation avatarCreation;

        public Builder() {
        }

        @NonNull
        public Builder setName(@NonNull String name) {
            this.name = name;
            return this;
        }

        @NonNull
        public Builder setAvatarCreation(@NonNull Creation avatarCreation) {
            this.avatarCreation = avatarCreation;
            return this;
        }

        @NonNull
        public Group build() {
            if (name == null && avatarCreation == null) {
                throw new IllegalStateException("Cannot create empty group, you should set either name, avatarCreation or both.");
            }

            return new Group(name, avatarCreation);
        }
    }
}
