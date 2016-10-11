package com.creatubbles.api.model;

import android.support.annotation.Nullable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImageLinks {

    private String original;

    @JsonProperty("list_view")
    private String listView;

    @JsonProperty("list_view_retina")
    private String listViewRetina;

    @JsonProperty("matrix_view_retina")
    private String matrixViewRetina;

    @JsonProperty("matrix_view")
    private String matrixView;

    @JsonProperty("explore_mobile")
    private String exploreMobile;

    @Nullable
    public String getOriginal() {
        return original;
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
     * @return url to image in 90x90 (might be cropped)
     */
    @Nullable
    public String getExploreMobile() {
        return exploreMobile;
    }

    @Override
    public String toString() {
        return "ImageLinks{" +
                "original='" + original + '\'' +
                ", listView='" + listView + '\'' +
                ", listViewRetina='" + listViewRetina + '\'' +
                ", matrixViewRetina='" + matrixViewRetina + '\'' +
                ", matrixView='" + matrixView + '\'' +
                ", exploreMobile='" + exploreMobile + '\'' +
                '}';
    }
}
