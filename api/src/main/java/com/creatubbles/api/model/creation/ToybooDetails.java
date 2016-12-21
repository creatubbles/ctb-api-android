package com.creatubbles.api.model.creation;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Type;

/**
 * Created by Janek on 09.11.2016.
 */

@Type("creation_toyboo_details")
public class ToybooDetails {

    @Id
    private String id;

    @JsonProperty("uzpb_url")
    private String uzpbUrl;

    @JsonProperty("content_url")
    private String contentUrl;

    @JsonCreator
    public ToybooDetails() {
    }

    @NonNull
    public String getId() {
        return id;
    }

    @Nullable
    public String getUzpbUrl() {
        return uzpbUrl;
    }

    @Nullable
    public String getContentUrl() {
        return contentUrl;
    }
}
