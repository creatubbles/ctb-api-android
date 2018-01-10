package com.creatubbles.api.model.comment;

import android.support.annotation.Nullable;

import com.creatubbles.api.model.creation.Creation;
import com.creatubbles.api.model.gallery.Gallery;
import com.creatubbles.api.model.group.Group;
import com.creatubbles.api.model.partner_application.PartnerApplication;
import com.creatubbles.api.model.user.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.models.EmptyRelationship;

import java.util.List;

/**
 * Created by Janek on 20.12.2017.
 */
@Type("mentions")
public class Mention extends EmptyRelationship {

    @Id
    private String id;

    @JsonProperty("mention_type")
    private MentionType mentionType;

    private String text;

    private List<Integer> indices;

    @Relationship("user")
    private User user;

    @Relationship("group")
    private Group group;

    @Relationship("creation")
    private Creation creation;

    @Relationship("gallery")
    private Gallery gallery;

    @Relationship("partner_application")
    private PartnerApplication partnerApplication;

    @Nullable
    public String getId() {
        return id;
    }

    @Nullable
    public MentionType getMentionType() {
        return mentionType;
    }

    @Nullable
    public String getText() {
        return text;
    }

    @Nullable
    public List<Integer> getIndices() {
        return indices;
    }

    @Nullable
    public User getUser() {
        return user;
    }

    @Nullable
    public Group getGroup() {
        return group;
    }

    @Nullable
    public Creation getCreation() {
        return creation;
    }

    @Nullable
    public Gallery getGallery() {
        return gallery;
    }

    @Nullable
    public PartnerApplication getPartnerApplication() {
        return partnerApplication;
    }
}
