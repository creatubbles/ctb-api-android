package com.creatubbles.api.model.notification;

import android.support.annotation.NonNull;

import com.creatubbles.api.model.gallery.Gallery;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;

/**
 * @author Pawel Szymanski
 */
@Type("gallery_entities")
public class GalleryEntity extends Entity {

    @Relationship("gallery")
    private Gallery gallery;

    @NonNull
    public Gallery getGallery() {
        return gallery;
    }
}
