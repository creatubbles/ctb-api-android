package com.creatubbles.api.model.content;

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

    public void setId(String id) {
        this.id = id;
    }

    public Creation getCreation() {
        return creation;
    }

    public void setCreation(Creation creation) {
        this.creation = creation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Gallery getGallery() {
        return gallery;
    }

    public void setGallery(Gallery gallery) {
        this.gallery = gallery;
    }

    @Override
    public String toString() {
        return "Content{" +
                "id='" + id + '\'' +
                ", creation=" + creation +
                ", user=" + user +
                ", gallery=" + gallery +
                '}';
    }
}
