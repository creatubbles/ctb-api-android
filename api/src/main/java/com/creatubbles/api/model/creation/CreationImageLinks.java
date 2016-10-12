package com.creatubbles.api.model.creation;

import android.support.annotation.Nullable;

import com.creatubbles.api.model.ImageLinks;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreationImageLinks extends ImageLinks {

    @JsonProperty("full_view")
    private String fullView;

    @JsonProperty("gallery_mobile")
    private String galleryMobile;

    private String share;

    /**
     * @return url to image suitable for fullscreen view, original aspect ratio
     */
    @Nullable
    public String getFullView() {
        return fullView;
    }

    /**
     * @return url to image in max 300x600 size
     */
    @Nullable
    public String getGalleryMobile() {
        return galleryMobile;
    }

    /**
     * @return url to image in 600x600 (might be cropped)
     */
    @Nullable
    public String getShare() {
        return share;
    }

    @Override
    public String toString() {
        return "CreationImageLinks{" +
                "fullView='" + fullView + '\'' +
                ", galleryMobile='" + galleryMobile + '\'' +
                ", share='" + share + '\'' +
                "} " + super.toString();
    }
}
