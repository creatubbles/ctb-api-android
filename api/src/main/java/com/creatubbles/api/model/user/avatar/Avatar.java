package com.creatubbles.api.model.user.avatar;

import android.support.annotation.Nullable;

import com.creatubbles.api.model.creation.Creation;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;

import java.util.Date;

/**
 * Created by Janek on 24.10.2016.
 */
@Type("user_avatars")
public class Avatar {

    @JsonCreator
    public Avatar() {
    }

    public Avatar(@Nullable AvatarSuggestion avatarSuggestion, Creation avatarCreation) {
        this.avatarSuggestion = avatarSuggestion;
        this.avatarCreation = avatarCreation;
    }

    @Id
    private String id; // this is unused field required by jsonapi-converter

    @Relationship("avatar_creation")
    private Creation avatarCreation;

    @Relationship("avatar_suggestion")
    private AvatarSuggestion avatarSuggestion;

    @JsonProperty("avatar_url")
    private String avatarUrl;

    @JsonProperty("pending_avatar_url")
    private String pendingAvatarUrl;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("updated_at")
    private Date updatedAt;

    public String getId() {
        return id;
    }

    @Nullable
    public String getAvatarUrl() {
        return avatarUrl;
    }

    @Nullable
    public String getPendingAvatarUrl() {
        return pendingAvatarUrl;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    @Nullable
    public Creation getAvatarCreation() {
        return avatarCreation;
    }

    @Nullable
    public AvatarSuggestion getAvatarSuggestion() {
        return avatarSuggestion;
    }

    public static class Builder {

        private final Creation avatarCreation;
        private final AvatarSuggestion avatarSuggestion;

        public Builder(Creation avatarCreation, AvatarSuggestion avatarSuggestion) {
            this.avatarCreation = avatarCreation;
            this.avatarSuggestion = avatarSuggestion;
        }

        public Avatar build() {
            return new Avatar(avatarSuggestion, avatarCreation);
        }
    }

    @Override
    public String toString() {
        return "Avatar{" +
                "id='" + id + '\'' +
                ", avatarCreation=" + avatarCreation +
                ", avatarSuggestion=" + avatarSuggestion +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", pendingAvatarUrl='" + pendingAvatarUrl + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
