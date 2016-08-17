package com.creatubbles.api.model.gallery;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Attributes {

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("last_bubbled_at")
    private Object lastBubbledAt;

    @SerializedName("last_commented_at")
    private Object lastCommentedAt;

    @SerializedName("creations_count")
    private Integer creationsCount;

    @SerializedName("bubbles_count")
    private Integer bubblesCount;

    @SerializedName("comments_count")
    private Integer commentsCount;

    @SerializedName("short_url")
    private String shortUrl;

    @SerializedName("banner")
    private Banner banner;

    @SerializedName("preview_image_urls")
    private List<String> previewImageUrls = new ArrayList<String>();

    @SerializedName("bubbled_by_user_ids")
    private List<Object> bubbledByUserIds = new ArrayList<Object>();

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public Object getLastBubbledAt() {
        return lastBubbledAt;
    }

    public Object getLastCommentedAt() {
        return lastCommentedAt;
    }

    public Integer getCreationsCount() {
        return creationsCount;
    }

    public Integer getBubblesCount() {
        return bubblesCount;
    }

    public Integer getCommentsCount() {
        return commentsCount;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public Banner getBanner() {
        return banner;
    }

    public List<String> getPreviewImageUrls() {
        return previewImageUrls;
    }

    public List<Object> getBubbledByUserIds() {
        return bubbledByUserIds;
    }

    @Override
    public String toString() {
        return "Attributes{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
