package com.creatubbles.api.model.creation;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Attributes {

    @SerializedName("name")
    private String name;

    @SerializedName("created_at")
    private Date createdAt;

    @SerializedName("updated_at")
    private Date updatedAt;

    @SerializedName("image_status")
    private ImageStatus imageStatus;

    @SerializedName("image")
    private Image image;

    @SerializedName("bubbles_count")
    private Integer bubblesCount;

    @SerializedName("comments_count")
    private Integer commentsCount;

    @SerializedName("views_count")
    private Integer viewsCount;

    @SerializedName("last_bubbled_at")
    private Date lastBubbledAt;

    @SerializedName("last_commented_at")
    private Date lastCommentedAt;

    @SerializedName("last_submitted_at")
    private Date lastSubmittedAt;

    @SerializedName("translated_names")
    private List<TranslatedName> translatedNames = Collections.emptyList();

    @SerializedName("approved")
    @Deprecated
    private Boolean approved;

    @SerializedName("short_url")
    private String shortUrl;

    @SerializedName("created_at_age")
    private String createdAtAge;

    @SerializedName("approval_status")
    private ApprovalStatus approvalStatus;

    @SerializedName("created_at_age_per_creator")
    private Map<String, String> createdAtAgePerCreator;

    @SerializedName("reflection_text")
    private String reflectionText;

    @SerializedName("reflection_video_url")
    private String reflectionVideoUrl;

    @SerializedName("obj_file_url")
    private String objFileUrl;

    @SerializedName("play_iframe_url")
    private String playIframeUrl;

    public String getName() {
        return name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public ImageStatus getImageStatus() {
        return imageStatus;
    }

    public Image getImage() {
        return image;
    }

    public Integer getBubblesCount() {
        return bubblesCount;
    }

    public Integer getCommentsCount() {
        return commentsCount;
    }

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

    public List<TranslatedName> getTranslatedNames() {
        return translatedNames;
    }

    @Deprecated
    public Boolean getApproved() {
        return approved;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    @Nullable
    public String getCreatedAtAge() {
        return createdAtAge;
    }

    public ApprovalStatus getApprovalStatus() {
        return approvalStatus;
    }

    /**
     * This is the hash of ids of creators related to creation with proper ages assigned.
     * It’s very useful for listing creators with information about how old it was when creation have been added.
     */
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

    @Override
    public String toString() {
        return "Attributes{" +
                "name='" + name + '\'' +
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
                ", approved=" + approved +
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
}
