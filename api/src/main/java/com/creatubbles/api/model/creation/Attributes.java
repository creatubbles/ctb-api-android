package com.creatubbles.api.model.creation;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Attributes {

    @SerializedName("name")
    private String name;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("created_at_month")
    private Integer createdAtMonth;

    @SerializedName("created_at_year")
    private Integer createdAtYear;

    @SerializedName("image_status")
    private Integer imageStatus;

    @SerializedName("image")
    private Image image;

    @SerializedName("bubbles_count")
    private Integer bubblesCount;

    @SerializedName("comments_count")
    private Integer commentsCount;

    @SerializedName("views_count")
    private Integer viewsCount;

    @SerializedName("last_bubbled_at")
    private Object lastBubbledAt;

    @SerializedName("last_commented_at")
    private String lastCommentedAt;

    @SerializedName("last_submitted_at")
    private String lastSubmittedAt;

    @SerializedName("translated_names")
    private List<TranslatedName> translatedNames = new ArrayList<TranslatedName>();

    @SerializedName("approved")
    private Boolean approved;

    @SerializedName("short_url")
    private String shortUrl;

    @SerializedName("created_at_age")
    private String createdAtAge;

    public String getName() {
        return name;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public Integer getCreatedAtMonth() {
        return createdAtMonth;
    }

    public Integer getCreatedAtYear() {
        return createdAtYear;
    }

    public Integer getImageStatus() {
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

    public Object getLastBubbledAt() {
        return lastBubbledAt;
    }

    public String getLastCommentedAt() {
        return lastCommentedAt;
    }

    public String getLastSubmittedAt() {
        return lastSubmittedAt;
    }

    public List<TranslatedName> getTranslatedNames() {
        return translatedNames;
    }

    public Boolean getApproved() {
        return approved;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public String getCreatedAtAge() {
        return createdAtAge;
    }
}
