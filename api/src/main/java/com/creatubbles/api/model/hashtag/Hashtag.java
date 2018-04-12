package com.creatubbles.api.model.hashtag;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Type;

@Type("hashtags")
public class Hashtag {
    @Id
    private String id;

    @JsonProperty("is_official")
    private Boolean official;

    @JsonProperty("avatar_image_url")
    private AvatarImage avatarImage;

    @JsonProperty("taggings_count")
    private Integer taggingsCount;

    @JsonProperty("followers_count")
    private Integer followersCount;

    @NonNull
    public String getId() {
        return id;
    }

    @Nullable
    public Boolean getOfficial() {
        return official;
    }

    @Nullable
    public AvatarImage getAvatarImage() {
        return avatarImage;
    }

    @Nullable
    public Integer getTaggingsCount() {
        return taggingsCount;
    }

    @Nullable
    public Integer getFollowersCount() {
        return followersCount;
    }

    @Override
    public String toString() {
        return "Hashtag{" +
                "id='" + id + '\'' +
                ", official=" + official +
                ", avatarImage=" + avatarImage +
                ", taggingsCount=" + taggingsCount +
                ", followersCount=" + followersCount +
                '}';
    }
}
