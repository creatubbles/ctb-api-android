package com.creatubbles.api.model;

import android.support.annotation.NonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.models.EmptyRelationship;

/**
 * @author Pawel Szymanski
 */
@Type("reports")
public class Report extends EmptyRelationship {
    @Id
    private String id;

    private String message;

    @JsonCreator
    public Report() {
    }

    private Report(String message) {
        this.message = message;
    }

    public static Report create(@NonNull String message) {
        return new Report(message);
    }

    @NonNull
    public String getId() {
        return id;
    }

    @NonNull
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id='" + id + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
