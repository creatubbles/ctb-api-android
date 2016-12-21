package com.creatubbles.api.model.creation;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.model.user.User;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Type("creations")
public class Creation {

    @Id
    private String id;

    @Relationship("user")
    private User user;

    @Relationship("creators")
    private List<User> creators = Collections.emptyList();

    @JsonProperty("name")
    private String name;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("updated_at")
    private Date updatedAt;

    @JsonProperty("image_status")
    private ImageStatus imageStatus;

    @JsonProperty("image")
    private Image image;

    @JsonProperty("bubbles_count")
    private Integer bubblesCount;

    @JsonProperty("comments_count")
    private Integer commentsCount;

    @JsonProperty("views_count")
    private Integer viewsCount;

    @JsonProperty("last_bubbled_at")
    private Date lastBubbledAt;

    @JsonProperty("last_commented_at")
    private Date lastCommentedAt;

    @JsonProperty("last_submitted_at")
    private Date lastSubmittedAt;

    @JsonProperty("translated_names")
    private List<TranslatedName> translatedNames = Collections.emptyList();

    @JsonProperty("short_url")
    private String shortUrl;

    @JsonProperty("created_at_age")
    private String createdAtAge;

    @JsonProperty("approval_status")
    private ApprovalStatus approvalStatus;

    @JsonProperty("created_at_age_per_creator")
    private Map<String, String> createdAtAgePerCreator = Collections.emptyMap();

    @JsonProperty("reflection_text")
    private String reflectionText;

    @JsonProperty("reflection_video_url")
    private String reflectionVideoUrl;

    @JsonProperty("obj_file_url")
    private String objFileUrl;

    @JsonProperty("play_iframe_url")
    private String playIframeUrl;

    @JsonCreator
    public Creation() {
    }

    @SuppressWarnings("WeakerAccess")
    Creation(String name, List<User> creators, String reflectionText, String reflectionVideoUrl) {
        this.name = name;
        this.creators = creators;
        this.reflectionText = reflectionText;
        this.reflectionVideoUrl = reflectionVideoUrl;
    }

    public Creation(String creationId) {
        this.id = creationId;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public Date getCreatedAt() {
        return createdAt;
    }

    @NonNull
    public Date getUpdatedAt() {
        return updatedAt;
    }

    @NonNull
    public ImageStatus getImageStatus() {
        return imageStatus;
    }

    @NonNull
    public Image getImage() {
        return image;
    }

    @NonNull
    public Integer getBubblesCount() {
        return bubblesCount;
    }

    @NonNull
    public Integer getCommentsCount() {
        return commentsCount;
    }

    @NonNull
    public Integer getViewsCount() {
        return viewsCount;
    }

    @Nullable
    public Date getLastBubbledAt() {
        return lastBubbledAt;
    }

    @Nullable
    public Date getLastCommentedAt() {
        return lastCommentedAt;
    }

    @Nullable
    public Date getLastSubmittedAt() {
        return lastSubmittedAt;
    }

    @NonNull
    public List<TranslatedName> getTranslatedNames() {
        return translatedNames;
    }

    @NonNull
    public String getShortUrl() {
        return shortUrl;
    }

    @Nullable
    public String getCreatedAtAge() {
        return createdAtAge;
    }

    @NonNull
    public ApprovalStatus getApprovalStatus() {
        return approvalStatus;
    }

    /**
     * This is the hash of ids of creators related to creation with proper ages assigned.
     * It’s very useful for listing creators with information about how old it was when creation have been added.
     */
    @NonNull
    public Map<String, String> getCreatedAtAgePerCreator() {
        return createdAtAgePerCreator;
    }

    /**
     * @return user’s "reflection" / "comment" about the creation
     */
    @Nullable
    public String getReflectionText() {
        return reflectionText;
    }

    /**
     * @return link to video on creation process, has to be a valid URL
     */
    @Nullable
    public String getReflectionVideoUrl() {
        return reflectionVideoUrl;
    }

    /**
     * @return url to OBJ file for 3d object
     */
    @Nullable
    public String getObjFileUrl() {
        return objFileUrl;
    }

    /**
     * @return url to 3d player which can be embedded in iframe
     */
    @Nullable
    public String getPlayIframeUrl() {
        return playIframeUrl;
    }

    @NonNull
    public String getId() {
        return id;
    }

    @NonNull
    public User getUser() {
        return user;
    }

    @NonNull
    public List<User> getCreators() {
        return creators;
    }

    @Override
    public String toString() {
        return "Creation{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", creators=" + creators +
                ", name='" + name + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", imageStatus=" + imageStatus +
                ", image=" + image +
                ", bubblesCount=" + bubblesCount +
                ", commentsCount=" + commentsCount +
                ", viewsCount=" + viewsCount +
                ", lastBubbledAt=" + lastBubbledAt +
                ", lastCommentedAt=" + lastCommentedAt +
                ", lastSubmittedAt=" + lastSubmittedAt +
                ", translatedNames=" + translatedNames +
                ", shortUrl='" + shortUrl + '\'' +
                ", createdAtAge='" + createdAtAge + '\'' +
                ", approvalStatus=" + approvalStatus +
                ", createdAtAgePerCreator=" + createdAtAgePerCreator +
                ", reflectionText='" + reflectionText + '\'' +
                ", reflectionVideoUrl='" + reflectionVideoUrl + '\'' +
                ", objFileUrl='" + objFileUrl + '\'' +
                ", playIframeUrl='" + playIframeUrl + '\'' +
                '}';
    }

    public static class Builder {
        private final String name;
        private final List<User> creators;
        private String reflectionVideoUrl;
        private String reflectionText;


        public Builder(@NonNull String name, @NonNull List<User> creators) {
            this.name = name;
            this.creators = creators;
        }

        @NonNull
        public Builder setReflectionText(@NonNull String reflectionText) {
            this.reflectionText = reflectionText;
            return this;
        }

        @NonNull
        public Builder setReflectionVideoUrl(@NonNull String reflectionVideoUrl) {
            this.reflectionVideoUrl = reflectionVideoUrl;
            return this;
        }

        @NonNull
        public Creation build() {
            return new Creation(name, creators, reflectionText, reflectionVideoUrl);
        }
    }


}
