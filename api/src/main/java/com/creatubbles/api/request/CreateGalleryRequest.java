package com.creatubbles.api.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Janek on 11.02.2016.
 */
public class CreateGalleryRequest {

    @SerializedName("name")
    private final String name;

    @SerializedName("description")
    private final String description;

    @SerializedName("openForAll")
    private final Integer openForAll;

    @SerializedName("ownerId")
    private final String ownerId;

    private CreateGalleryRequest(Builder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.openForAll = builder.openForAll;
        this.ownerId = builder.ownerId;
    }

    public static class Builder {

        private final String name;
        private final String description;
        private Integer openForAll;
        private String ownerId;

        public Builder(String name, String description) {
            this.name = name;
            this.description = description;
        }

        public Builder openForAll(Integer openForAll) {
            this.openForAll = openForAll;
            return this;
        }

        public Builder ownerId(String ownerId) {
            this.ownerId = ownerId;
            return this;
        }

        public CreateGalleryRequest build() {
            return new CreateGalleryRequest(this);
        }
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getOpenForAll() {
        return openForAll;
    }

    public String getOwnerId() {
        return ownerId;
    }
}
