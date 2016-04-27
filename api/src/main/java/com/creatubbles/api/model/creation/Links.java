package com.creatubbles.api.model.creation;

import com.google.gson.annotations.SerializedName;

public class Links {

    @SerializedName("original")
    private String original;

    @SerializedName("full_view")
    private String fullView;

    @SerializedName("list_view_retina")
    private String listViewRetina;

    @SerializedName("list_view")
    private String listView;

    @SerializedName("matrix_view_retina")
    private String matrixViewRetina;

    @SerializedName("matrix_view")
    private String matrixView;

    @SerializedName("gallery_mobile")
    private String galleryMobile;

    @SerializedName("explore_mobile")
    private String exploreMobile;

    @SerializedName("share")
    private String share;

    public String getOriginal() {
        return original;
    }

    public String getFullView() {
        return fullView;
    }

    public String getListViewRetina() {
        return listViewRetina;
    }

    public String getListView() {
        return listView;
    }

    public String getMatrixViewRetina() {
        return matrixViewRetina;
    }

    public String getMatrixView() {
        return matrixView;
    }

    public String getGalleryMobile() {
        return galleryMobile;
    }

    public String getExploreMobile() {
        return exploreMobile;
    }

    public String getShare() {
        return share;
    }
}
