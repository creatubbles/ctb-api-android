package com.creatubbles.api.model;

import com.google.gson.annotations.SerializedName;

public class Meta {

    @SerializedName("total_pages")
    private Integer totalPages;

    @SerializedName("total_count")
    private Integer totalCount;

    public Integer getTotalPages() {
        return totalPages;
    }

    public Integer getTotalCount() {
        return totalCount;
    }
}