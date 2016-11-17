package com.creatubbles.api.model.content;

import com.creatubbles.api.model.ObjectType;
import com.creatubbles.api.model.creation.Creation;
import com.creatubbles.api.model.gallery.Gallery;
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

    @JsonCreator
    public Content() {
        super();
    }

    public String getId() {
        return id;
    }

    public ObjectType getType() {
        return type;
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

    @Override
    public String toString() {
        return "Content{" +
                "id='" + id + '\'' +
                ", type=" + type +
                ", creation=" + creation +
                ", user=" + user +
                ", gallery=" + gallery +
                '}';
    }
}
