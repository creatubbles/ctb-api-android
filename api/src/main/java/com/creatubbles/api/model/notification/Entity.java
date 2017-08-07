package com.creatubbles.api.model.notification;

import android.support.annotation.NonNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.models.EmptyRelationship;

/**
 * @author Pawel Szymanski
 */
abstract class Entity extends EmptyRelationship {

    @Id
    private String id;

    @JsonProperty("start_pos")
    private int startPosition;

    @JsonProperty("end_pos")
    private int endPosition;

    @NonNull
    public String getId() {
        return id;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public int getEndPosition() {
        return endPosition;
    }
}
