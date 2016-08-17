
package com.creatubbles.api.model.creator;

import com.google.gson.annotations.SerializedName;


public class AbilityAttributes {

    @SerializedName("resource_type")
    private String resourceType;

    @SerializedName("resource_id")
    private String resourceId;

    @SerializedName("permission")
    private Boolean permission;

    @SerializedName("operation")
    private String operation;

    public String getResourceType() {
        return resourceType;
    }

    public String getResourceId() {
        return resourceId;
    }

    public Boolean getPermission() {
        return permission;
    }

    public String getOperation() {
        return operation;
    }
}
