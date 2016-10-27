package com.creatubbles.api.model;

import com.creatubbles.api.model.creation.Creation;
import com.creatubbles.api.model.gallery.Gallery;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;

/**
 * @author Pawel Szymanski
 */
@Type("gallery_submissions")
public class GallerySubmission {

    @Id
    private String id;

    @Relationship("gallery")
    private Gallery gallery;

    @Relationship("creation")
    private Creation creation;

    @JsonCreator
    public GallerySubmission() {
    }

    public GallerySubmission(String galleryId, String creationId) {
        this.gallery = new Gallery(galleryId);
        this.creation = new Creation(creationId);
    }

    public Gallery getGallery() {
        return gallery;
    }

    public Creation getCreation() {
        return creation;
    }

    @Override
    public String toString() {
        return "GallerySubmission{" +
                "id='" + id + '\'' +
                ", gallery=" + gallery +
                ", creation=" + creation +
                '}';
    }
}
