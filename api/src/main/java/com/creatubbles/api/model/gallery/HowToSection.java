package com.creatubbles.api.model.gallery;

import android.support.annotation.Nullable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.models.EmptyRelationship;

@Type("gallery_howto_sections")
public class HowToSection extends EmptyRelationship {
    @Id
    private String id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("content")
    private String content;

    @JsonProperty("image")
    private ChallengeImage image;

    @JsonCreator
    public HowToSection() {
    }

    public String getId() {
        return id;
    }

    @Nullable
    public String getTitle() {
        return title;
    }

    @Nullable
    public String getContent() {
        return content;
    }

    @Nullable
    public ChallengeImage getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "HowToSection{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", image=" + image +
                '}';
    }
}
