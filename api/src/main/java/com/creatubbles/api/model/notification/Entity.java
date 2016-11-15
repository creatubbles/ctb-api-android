package com.creatubbles.api.model.notification;

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

    public Integer getStartPosition() {
        return startPosition;
    }

    public Integer getEndPosition() {
        return endPosition;
    }
}
