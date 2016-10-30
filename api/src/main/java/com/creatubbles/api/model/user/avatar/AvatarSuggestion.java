package com.creatubbles.api.model.user.avatar;

import android.support.annotation.NonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jasminb.jsonapi.annotations.Id;

/**
 * Created by Janek on 24.10.2016.
 */
public class AvatarSuggestion {

    @JsonCreator
    public AvatarSuggestion() {

    }


    public AvatarSuggestion(@NonNull String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Id
    private String id; // this is unused field required by jsonapi-converter

    @NonNull
    @JsonProperty("avatar_url")
    private String avatarUrl;

    public String getId() {
        return id;
    }

    @NonNull
    public String getAvatarUrl() {
        return avatarUrl;
    }

}
