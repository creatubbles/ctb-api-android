package com.creatubbles.api.model;

import android.support.annotation.NonNull;

import com.creatubbles.api.model.creation.Creation;
import com.creatubbles.api.model.gallery.Gallery;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.models.EmptyRelationship;

/**
 * @author Pawel Szymanski
 */
@Type("gallery_submissions")
public class GallerySubmission extends EmptyRelationship {

    @Id
    private String id;

    @Relationship("gallery")
    private Gallery gallery;

    @Relationship("creation")
    private Creation creation;

    @JsonCreator
    public GallerySubmission() {
    }

    public GallerySubmission(@NonNull String galleryId, @NonNull String creationId) {
        this.gallery = new Gallery(galleryId);
        this.creation = new Creation(creationId);
    }

    @NonNull
    public Gallery getGallery() {
        return gallery;
    }

    @NonNull
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
