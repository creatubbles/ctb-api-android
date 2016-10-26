package com.creatubbles.api.model.gallery;

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

@Type("galleries")
public class Gallery {

    @Id
    private String id;

    private String name;

    private String description;

    @JsonProperty("open_for_all")
    private Boolean openForAll;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("last_bubbled_at")
    private Date lastBubbledAt;

    @JsonProperty("last_commented_at")
    private Date lastCommentedAt;

    @JsonProperty("creations_count")
    private Integer creationsCount;

    @JsonProperty("bubbles_count")
    private Integer bubblesCount;

    @JsonProperty("comments_count")
    private Integer commentsCount;

    @JsonProperty("short_url")
    private String shortUrl;

    private Banner banner;

    @JsonProperty("preview_image_urls")
    private List<String> previewImageUrls = Collections.emptyList();

    @Relationship("owner")
    private User owner;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    @JsonCreator
    Gallery() {
    }

    /**
     *
     * @param name name of the gallery
     * @param description (optional)
     * @param openForAll (optional) value indicating if everyone can sumbit creations to this gallery
     * @param owner (optional) if null then current user is assumed.
     */
    public Gallery(String name, String description, Boolean openForAll, User owner) {
        this.name = name;
        this.description = description;
        this.openForAll = openForAll;
        this.owner = owner;
    }

    /**
     * @return boolean indicating if everyone can submit creations to this gallery
     */
    public Boolean getOpenForAll() {
        return openForAll;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    @Nullable
    public Date getLastBubbledAt() {
        return lastBubbledAt;
    }

    @Nullable
    public Date getLastCommentedAt() {
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

    @Nullable
    public Banner getBanner() {
        return banner;
    }

    public List<String> getPreviewImageUrls() {
        return previewImageUrls;
    }

    public User getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "Gallery{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", openForAll=" + openForAll +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", lastBubbledAt=" + lastBubbledAt +
                ", lastCommentedAt=" + lastCommentedAt +
                ", creationsCount=" + creationsCount +
                ", bubblesCount=" + bubblesCount +
                ", commentsCount=" + commentsCount +
                ", shortUrl='" + shortUrl + '\'' +
                ", banner=" + banner +
                ", previewImageUrls=" + previewImageUrls +
                ", owner=" + owner +
                '}';
    }
}
