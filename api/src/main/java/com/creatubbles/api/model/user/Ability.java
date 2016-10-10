
package com.creatubbles.api.model.user;

import com.google.gson.annotations.SerializedName;

public class Ability {

    @SerializedName("id")
    private String id;

    @SerializedName("type")
    private String type;

    @SerializedName("relationships")
    private Relationships relationships;

    @SerializedName("attributes")
    private AbilityAttributes attributes;

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Relationships getRelationships() {
        return relationships;
    }

    public AbilityAttributes getAttributes() {
        return attributes;
    }
}
