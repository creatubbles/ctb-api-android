package com.creatubbles.api.model.notification;


import android.support.annotation.NonNull;

import com.creatubbles.api.model.creation.Creation;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;

/**
 * @author Pawel Szymanski
 */
@Type("creation_entities")
public class CreationEntity extends Entity {

    @Relationship("creation")
    private Creation creation;

    @NonNull
    public Creation getCreation() {
        return creation;
    }
}
