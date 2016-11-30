package com.creatubbles.api.model.user.avatar;

import android.support.annotation.NonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Type;

/**
 * Created by Janek on 24.10.2016.
 */
@Type("avatar_suggestions")
public class AvatarSuggestion {

    @JsonCreator
    public AvatarSuggestion() {

    }


    public AvatarSuggestion(@NonNull String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Id
    private String id; // this is unused field required by jsonapi-converter

    @JsonProperty("url")
    private String avatarUrl;

    @NonNull
    public String getId() {
        return id;
    }

    @NonNull
    public String getAvatarUrl() {
        return avatarUrl;
    }

    @Override
    public String toString() {
        return "AvatarSuggestion{" +
                "id='" + id + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                '}';
    }
}
