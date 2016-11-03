package com.creatubbles.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Type;

/**
 * @author Pawel Szymanski
 */
@Type("reports")
public class Report {
    @Id
    private String id;

    private String message;

    @JsonCreator
    public Report() {
    }

    private Report(String message) {
        this.message = message;
    }

    public static Report create(String message) {
        return new Report(message);
    }

    public String getId() {
        return id;
    }

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
