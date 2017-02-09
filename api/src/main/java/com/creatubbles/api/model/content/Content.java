package com.creatubbles.api.model.content;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.model.ObjectType;
import com.creatubbles.api.model.creation.Creation;
import com.creatubbles.api.model.gallery.Gallery;
import com.creatubbles.api.model.partner_application.PartnerApplication;
import com.creatubbles.api.model.user.User;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;

/**
 * Created by Mario Ostapowicz on 28.10.2016.
 */

@Type("contents")
public class Content {

    @Id
    private String id;

    private ObjectType type;

    @Relationship("creation")
    private Creation creation;

    @Relationship("user")
    private User user;

    @Relationship("gallery")
    private Gallery gallery;

    @Relationship("partner_application")
    private PartnerApplication partnerApplication;

    @JsonCreator
    public Content() {
        super();
    }

    @NonNull
    public String getId() {
        return id;
    }

    @NonNull
    public ObjectType getType() {
        return type;
    }

    @Nullable
    public Creation getCreation() {
        return creation;
    }

    @Nullable
    public User getUser() {
        return user;
    }

    @Nullable
    public Gallery getGallery() {
        return gallery;
    }

    @Nullable
    public PartnerApplication getPartnerApplication() {
        return partnerApplication;
    }

    @Override
    public String toString() {
        return "Content{" +
                "id='" + id + '\'' +
                ", type=" + type +
                ", creation=" + creation +
                ", user=" + user +
                ", gallery=" + gallery +
                ", partnerApplication=" + partnerApplication +
                '}';
    }
}
