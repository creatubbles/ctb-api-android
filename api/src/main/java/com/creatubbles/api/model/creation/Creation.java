package com.creatubbles.api.model.creation;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.model.partner_application.PartnerApplication;
import com.creatubbles.api.model.user.User;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.models.EmptyRelationship;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Type("creations")
public class Creation extends EmptyRelationship {

    @Id
    private String id;

    @Relationship("user")
    private User user;

    @Relationship("creators")
    private List<User> creators = Collections.emptyList();

    @Relationship("partner_application")
    private PartnerApplication partnerApplication;

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

    @JsonProperty("play_iframe_url_is_mobile_ready")
    private Boolean playIframeIsMobileReady;

    @JsonProperty("video_480_url")
    private String video480Url;

    @JsonProperty("video_720_url")
    private String video720Url;

    @JsonProperty("tags")
    private List<String> tags;

    /**
     * Returned only if user can edit
     */
    @JsonProperty("created_at_year")
    private Integer createdAtYear;

    /**
     * Returned only if user can edit
     */
    @JsonProperty("created_at_month")
    private Integer createdAtMonth;

    @JsonProperty("content_type")
    private String contentType;

    @JsonCreator
    public Creation() {
    }

    @SuppressWarnings("WeakerAccess")
    Creation(String id, String name, List<User> creators, String reflectionText, String reflectionVideoUrl, Integer createdAtYear, Integer createdAtMonth, List<String> tags) {
        this.id = id;
        this.name = name;
        this.creators = creators;
        this.reflectionText = reflectionText;
        this.reflectionVideoUrl = reflectionVideoUrl;
        this.createdAtYear = createdAtYear;
        this.createdAtMonth = createdAtMonth;
        this.tags = tags;
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

    @Nullable
    public Boolean getPlayIframeIsMobileReady() {
        return playIframeIsMobileReady;
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

    @Nullable
    public String getVideo480Url() {
        return video480Url;
    }

    @Nullable
    public String getVideo720Url() {
        return video720Url;
    }

    @Nullable
    public PartnerApplication getPartnerApplication() {
        return partnerApplication;
    }

    @Nullable
    public List<String> getTags() {
        return tags;
    }

    @Nullable
    public Integer getCreatedAtYear() {
        return createdAtYear;
    }

    @Nullable
    public Integer getCreatedAtMonth() {
        return createdAtMonth;
    }

    @NonNull
    public String getContentType() {
        return contentType;
    }

    @Override
    public String toString() {
        return "Creation{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", creators=" + creators +
                ", partnerApplication=" + partnerApplication +
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
                ", playIframeIsMobileReady=" + playIframeIsMobileReady +
                ", video480Url='" + video480Url + '\'' +
                ", video720Url='" + video720Url + '\'' +
                ", tags=" + tags +
                ", createdAtYear=" + createdAtYear +
                ", createdAtMonth=" + createdAtMonth +
                ", contentType='" + contentType + '\'' +
                '}';
    }

    public static class Builder {
        private final String name;
        private final List<User> creators;
        private String reflectionVideoUrl;
        private String reflectionText;
        private Integer createdAtYear = null;
        private Integer createdAtMonth = null;
        private List<String> tags;
        private String id;

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
        public Builder setCreatedAtYear(int createdAtYear) {
            this.createdAtYear = createdAtYear;
            return this;
        }

        @NonNull
        public Builder setCreatedAtMonth(int createdAtMonth) {
            this.createdAtMonth = createdAtMonth;
            return this;
        }

        @NonNull
        public Builder setTags(List<String> tags) {
            this.tags = tags;
            return this;
        }

        @NonNull
        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        @NonNull
        public Creation build() {
            return new Creation(id, name, creators, reflectionText, reflectionVideoUrl, createdAtYear, createdAtMonth, tags);
        }
    }


}
