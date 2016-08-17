package com.creatubbles.api.model.gallery.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Attributes {

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("open_for_all")
    private Boolean openForAll;

    @SerializedName("banner")
    private Object banner;

    @SerializedName("preview_image_urls")
    private List<Object> previewImageUrls = new ArrayList<Object>();

    @SerializedName("creations_count")
    private Integer creationsCount;

    @SerializedName("bubbles_count")
    private Integer bubblesCount;

    @SerializedName("comments_count")
    private Integer commentsCount;

    @SerializedName("last_bubbled_at")
    private Object lastBubbledAt;

    @SerializedName("last_commented_at")
    private Object lastCommentedAt;

    @SerializedName("short_url")
    private String shortUrl;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("updated_at")
    private String updatedAt;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getOpenForAll() {
        return openForAll;
    }

    public Object getBanner() {
        return banner;
    }

    public List<Object> getPreviewImageUrls() {
        return previewImageUrls;
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

    public Object getLastBubbledAt() {
        return lastBubbledAt;
    }

    public Object getLastCommentedAt() {
        return lastCommentedAt;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }
}
