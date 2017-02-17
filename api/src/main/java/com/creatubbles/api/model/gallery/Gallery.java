package com.creatubbles.api.model.gallery;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.model.partner_application.PartnerApplication;
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
    private boolean openForAll;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("updated_at")
    private Date updatedAt;

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

    @Relationship("partner_application")
    private PartnerApplication partnerApplication;

    public Gallery(String galleryId) {
        this.id = galleryId;
    }

    @NonNull
    public String getId() {
        return id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    @JsonCreator
    public Gallery() {
    }

    /**
     *
     * @param name name of the gallery
     * @param description (optional)
     * @param openForAll (optional) value indicating if everyone can sumbit creations to this gallery
     * @param owner (optional) if null then current user is assumed.
     */
    public Gallery(@NonNull String name, @Nullable String description, boolean openForAll, @Nullable User owner) {
        this.name = name;
        this.description = description;
        this.openForAll = openForAll;
        this.owner = owner;
    }

    /**
     * @return boolean indicating if everyone can submit creations to this gallery
     */
    public boolean getOpenForAll() {
        return openForAll;
    }

    @NonNull
    public Date getCreatedAt() {
        return createdAt;
    }

    @NonNull
    public Date getUpdatedAt() {
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

    @NonNull
    public Integer getCreationsCount() {
        return creationsCount;
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
    public String getShortUrl() {
        return shortUrl;
    }

    @Nullable
    public Banner getBanner() {
        return banner;
    }

    @NonNull
    public List<String> getPreviewImageUrls() {
        return previewImageUrls;
    }

    @NonNull
    public User getOwner() {
        return owner;
    }

    public PartnerApplication getPartnerApplication() {
        return partnerApplication;
    }

    @Override public String toString() {
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
                ", partnerApplication=" + partnerApplication +
                '}';
    }
}
