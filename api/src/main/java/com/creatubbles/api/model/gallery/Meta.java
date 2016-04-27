package com.creatubbles.api.model.gallery;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Meta {

    @SerializedName("total_pages")
    private int totalPages;

    @SerializedName("pages_count")
    private int pagesCount;

    @SerializedName("bubbled_ids")
    private List<Object> bubbledIds = new ArrayList<Object>();

    public int getTotalPages() {
        return totalPages;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public List<Object> getBubbledIds() {
        return bubbledIds;
    }
}