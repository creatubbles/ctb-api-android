
package com.creatubbles.api.model.user.custom_style;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.model.creation.Creation;
import com.creatubbles.api.model.user.User;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;

import java.util.Date;
import java.util.List;

@Type("custom_styles")
public class CustomStyle {

    @JsonCreator
    public CustomStyle() {
    }

    @SuppressWarnings("WeakerAccess")
    public CustomStyle(String name, String headerBackgroundId, String bodyBackgroundId, String font, String bio, List<String> bodyColors, List<String> headerColors) {
        this.name = name;
        this.headerBackgroundId = headerBackgroundId;
        this.bodyBackgroundId = bodyBackgroundId;
        this.font = font;
        this.bio = bio;
        this.bodyColors = bodyColors;
        this.headerColors = headerColors;
    }

    @Id
    private String id; // this is unused field required by jsonapi-converter

    @Relationship("user")
    private User user;

    @Relationship("header_creation")
    private Creation headerCreation;

    @Relationship("body_creation")
    private Creation bodyCreation;

    private String name;

    @JsonProperty("header_background_id")
    private String headerBackgroundId;

    @JsonProperty("body_background_id")
    private String bodyBackgroundId;

    private String font;

    private String bio;

    @JsonProperty("body_colors")
    private List<String> bodyColors;

    @JsonProperty("header_colors")
    private List<String> headerColors;

    @JsonProperty("body_creation_url")
    private String bodyCreationUrl;

    @JsonProperty("header_creation_url")
    private String headerCreationUrl;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("updated_at")
    private Date updatedAt;

    @NonNull
    public String getId() {
        return id;
    }

    @Nullable
    public String getName() {
        return name;
    }

    @Nullable
    public String getHeaderBackgroundId() {
        return headerBackgroundId;
    }

    @Nullable
    public String getBodyBackgroundId() {
        return bodyBackgroundId;
    }

    @Nullable
    public String getFont() {
        return font;
    }

    @Nullable
    public String getBio() {
        return bio;
    }

    @Nullable
    public List<String> getBodyColors() {
        return bodyColors;
    }

    @Nullable
    public List<String> getHeaderColors() {
        return headerColors;
    }

    @Nullable
    public String getBodyCreationUrl() {
        return bodyCreationUrl;
    }

    @Nullable
    public String getHeaderCreationUrl() {
        return headerCreationUrl;
    }

    @NonNull
    public Date getCreatedAt() {
        return createdAt;
    }

    @NonNull
    public Date getUpdatedAt() {
        return updatedAt;
    }

    public static class Builder {
        private String name;
        private String headerBackgroundId;
        private String bodyBackgroundId;
        private String font;
        private String bio;
        private List<String> bodyColors;
        private List<String> headerColors;

        @NonNull
        public Builder setName(@NonNull String name) {
            this.name = name;
            return this;
        }

        @NonNull
        public Builder setHeaderBackgroundId(@NonNull String headerBackgroundId) {
            this.headerBackgroundId = headerBackgroundId;
            return this;
        }

        @NonNull
        public Builder setBodyBackgroundId(@NonNull String bodyBackgroundId) {
            this.bodyBackgroundId = bodyBackgroundId;
            return this;
        }

        @NonNull
        public Builder setFont(@NonNull String font) {
            this.font = font;
            return this;
        }

        @NonNull
        public Builder setBio(@NonNull String bio) {
            this.bio = bio;
            return this;
        }

        @NonNull
        public Builder setBodyColors(@NonNull List<String> bodyColors) {
            this.bodyColors = bodyColors;
            return this;
        }

        @NonNull
        public Builder setHeaderColors(@NonNull List<String> headerColors) {
            this.headerColors = headerColors;
            return this;
        }

        @NonNull
        public CustomStyle build() {
            return new CustomStyle(name, headerBackgroundId, bodyBackgroundId, font, bio, bodyColors, headerColors);
        }
    }

    /**
     * @return instance of custom style owner
     */
    @NonNull
    public User getUser() {
        return user;
    }

    /**
     * @return instance of creation used as header background
     */
    @Nullable
    public Creation getHeaderCreation() {
        return headerCreation;
    }

    /**
     * @return instance of creation used as body background
     */
    @Nullable
    public Creation getBodyCreation() {
        return bodyCreation;
    }

    @Override
    public String toString() {
        return "CustomStyle{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", headerCreation=" + headerCreation +
                ", bodyCreation=" + bodyCreation +
                ", name='" + name + '\'' +
                ", headerBackgroundId='" + headerBackgroundId + '\'' +
                ", bodyBackgroundId='" + bodyBackgroundId + '\'' +
                ", font='" + font + '\'' +
                ", bio='" + bio + '\'' +
                ", bodyColors=" + bodyColors +
                ", headerColors=" + headerColors +
                ", bodyCreationUrl='" + bodyCreationUrl + '\'' +
                ", headerCreationUrl='" + headerCreationUrl + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
