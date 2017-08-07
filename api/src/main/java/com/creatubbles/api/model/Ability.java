package com.creatubbles.api.model;

import android.support.annotation.NonNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.models.EmptyRelationship;

@Type("abilities")
public class Ability extends EmptyRelationship {

    @Id
    private String id;

    @JsonProperty("resource_type")
    private String resourceType;

    @JsonProperty("resource_id")
    private String resourceId;

    private boolean permission;

    private Operation operation;

    public void setId(String id) {
        this.id = id;
    }

    @NonNull
    public String getId() {
        return id;
    }

    @NonNull
    public String getResourceType() {
        return resourceType;
    }

    @NonNull
    public String getResourceId() {
        return resourceId;
    }

    public boolean getPermission() {
        return permission;
    }

    @NonNull
    public Operation getOperation() {
        return operation;
    }

    @Override
    public String toString() {
        return "Ability{" +
                "id='" + id + '\'' +
                ", resourceType='" + resourceType + '\'' +
                ", resourceId='" + resourceId + '\'' +
                ", permission=" + permission +
                ", operation='" + operation + '\'' +
                '}';
    }
}
