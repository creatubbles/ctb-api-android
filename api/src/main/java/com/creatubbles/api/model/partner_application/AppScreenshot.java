package com.creatubbles.api.model.partner_application;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Type;

/**
 * @author Pawel Szymanski
 */
@Type("app_screenshots")
public class AppScreenshot {

    @Id
    private String id;
    private String url;
    @JsonProperty("is_video")
    private boolean video;
    private String vid;
    private String title;
    private VideoProvider provider;
    private Integer position;

    /**
     * Url for screenshot image (empty in case of video)
     */
    @Nullable
    public String getUrl() {
        return url;
    }

    /**
     * @return false in case of image, true if this is a video
     */
    public boolean isVideo() {
        return video;
    }

    /**
     * YouTube/Vimeo video identifier
     */
    @Nullable
    public String getVid() {
        return vid;
    }

    /**
     * Title for popup which displays the video
     */
    @Nullable
    public String getTitle() {
        return title;
    }

    @Nullable
    public VideoProvider getProvider() {
        return provider;
    }

    /**
     * Determines asset position in “Screenshots & Videos” section
     */
    @NonNull
    public Integer getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "AppScreenshot{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", video=" + video +
                ", vid='" + vid + '\'' +
                ", title='" + title + '\'' +
                ", provider=" + provider +
                ", position=" + position +
                '}';
    }
}
