package com.creatubbles.api.model.notification;

import com.creatubbles.api.model.GallerySubmission;
import com.creatubbles.api.model.comment.Comment;
import com.creatubbles.api.model.creation.Creation;
import com.creatubbles.api.model.gallery.Gallery;
import com.creatubbles.api.model.user.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * Notifications are always for either a creation, user or gallery. So any notification will reference exactly one of those three objects.
 * </p>
 * <p>
 * The visual icon shown for a notification should be based on this base object.
 * </p>
 * <p>
 * The notification will also reference different entities, which are annotations to the notification’s text.
 * The entities describe how parts of the notification text relate to other objects.
 * Applications should highlight those parts of the text and allow the user to navigate to the linked objects.
 * </p>
 *
 * @author Pawel Szymanski
 */
@Type("notifications")
public class Notification {

    @Id
    private String id;

    private NotificationType type;

    private String text;

    @JsonProperty("short_text")
    private String shortText;

    @JsonProperty("is_new")
    private Boolean isNew;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("updated_at")
    private Date updatedAt;

    @Relationship("creation")
    private Creation creation;

    @Relationship("user")
    private User user;

    @Relationship("gallery")
    private Gallery gallery;

    @Relationship("comment")
    private Comment comment;

    @Relationship("gallery_submission")
    private GallerySubmission gallerySubmission;

    @Relationship("user_entities")
    private List<UserEntity> userEntities;

    @Relationship("gallery_entities")
    private List<GalleryEntity> galleryEntities;

    @Relationship("creation_entities")
    private List<CreationEntity> creationEntities;


    public String getId() {
        return id;
    }

    public NotificationType getType() {
        return type;
    }

    public String getText() {
        return text;
    }

    public String getShortText() {
        return shortText;
    }

    public Boolean getNew() {
        return isNew;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Creation getCreation() {
        return creation;
    }

    public User getUser() {
        return user;
    }

    public Gallery getGallery() {
        return gallery;
    }

    public Comment getComment() {
        return comment;
    }

    public GallerySubmission getGallerySubmission() {
        return gallerySubmission;
    }

    public List<UserEntity> getUserEntities() {
        return userEntities;
    }

    public List<GalleryEntity> getGalleryEntities() {
        return galleryEntities;
    }

    public List<CreationEntity> getCreationEntities() {
        return creationEntities;
    }
}
