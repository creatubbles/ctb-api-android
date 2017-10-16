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

    @JsonProperty("video_480_url")
    private String video480Url;

    @JsonProperty("video_720_url")
    private String video720Url;

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

    public String getVideo480Url() {
        return video480Url;
    }

    public String getVideo720Url() {
        return video720Url;
    }

    @Override
    public String toString() {
        return "HowToSection{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", image=" + image +
                ", video480Url='" + video480Url + '\'' +
                ", video720Url='" + video720Url + '\'' +
                '}';
    }
}
