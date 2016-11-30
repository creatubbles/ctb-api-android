package com.creatubbles.api.model.notification;

import android.support.annotation.NonNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jasminb.jsonapi.annotations.Id;

/**
 * @author Pawel Szymanski
 */
abstract class Entity {

    @Id
    private String id;

    @JsonProperty("start_pos")
    private Integer startPosition;

    @JsonProperty("end_pos")
    private Integer endPosition;

    @NonNull
    public String getId() {
        return id;
    }

    @NonNull
    public Integer getStartPosition() {
        return startPosition;
    }

    @NonNull
    public Integer getEndPosition() {
        return endPosition;
    }
}
