package com.creatubbles.api.model.creation;

import android.support.annotation.Nullable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Links {

    private String original;

    @JsonProperty("full_view")
    private String fullView;

    @JsonProperty("list_view_retina")
    private String listViewRetina;

    @JsonProperty("list_view")
    private String listView;

    @JsonProperty("matrix_view_retina")
    private String matrixViewRetina;

    @JsonProperty("matrix_view")
    private String matrixView;

    @JsonProperty("gallery_mobile")
    private String galleryMobile;

    @JsonProperty("explore_mobile")
    private String exploreMobile;

    private String share;

    @Nullable
    public String getOriginal() {
        return original;
    }

    /**
     * @return url to image suitable for fullscreen view, original aspect ratio
     */
    @Nullable
    public String getFullView() {
        return fullView;
    }

    /**
     * @return url to image in 600x600 (might be cropped)
     */
    @Nullable
    public String getListViewRetina() {
        return listViewRetina;
    }

    /**
     * @return url to image in 300x300 (might be cropped)
     */
    @Nullable
    public String getListView() {
        return listView;
    }

    /**
     * @return url to image in 210x210 (might be cropped)
     */
    @Nullable
    public String getMatrixViewRetina() {
        return matrixViewRetina;
    }

    /**
     * @return url to image in 105x105 (might be cropped)
     */
    @Nullable
    public String getMatrixView() {
        return matrixView;
    }

    /**
     * @return url to image in max 300x600 size
     */
    @Nullable
    public String getGalleryMobile() {
        return galleryMobile;
    }

    /**
     * @return url to image in 90x90 (might be cropped)
     */
    @Nullable
    public String getExploreMobile() {
        return exploreMobile;
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
        return "Links{" +
                "original='" + original + '\'' +
                ", fullView='" + fullView + '\'' +
                ", listViewRetina='" + listViewRetina + '\'' +
                ", listView='" + listView + '\'' +
                ", matrixViewRetina='" + matrixViewRetina + '\'' +
                ", matrixView='" + matrixView + '\'' +
                ", galleryMobile='" + galleryMobile + '\'' +
                ", exploreMobile='" + exploreMobile + '\'' +
                ", share='" + share + '\'' +
                '}';
    }
}
