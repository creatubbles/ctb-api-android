package com.creatubbles.api.model.gallery;

import android.support.annotation.Nullable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Links {

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

    @Nullable
    public String getListView() {
        return listView;
    }

    @Nullable
    public String getListViewRetina() {
        return listViewRetina;
    }

    @Nullable
    public String getMatrixViewRetina() {
        return matrixViewRetina;
    }

    @Nullable
    public String getMatrixView() {
        return matrixView;
    }

    @Nullable
    public String getExploreMobile() {
        return exploreMobile;
    }
}
