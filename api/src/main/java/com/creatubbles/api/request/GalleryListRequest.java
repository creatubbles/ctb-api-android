package com.creatubbles.api.request;

import com.creatubbles.api.service.Sort;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Janek on 11.02.2016.
 */
public class GalleryListRequest {

    @SerializedName("page")
    private final Integer page;

    @SerializedName("per_page")
    private final Integer perPage;

    @SerializedName("sort")
    private final Sort sort;

    @SerializedName("user_id")
    private final String userId;

    private GalleryListRequest(Builder builder) {
        this.page = builder.page;
        this.perPage = builder.perPage;
        this.sort = builder.sort;
        this.userId = builder.userId;
    }

    public static class Builder {


        private Integer page;
        private Integer perPage;
        private Sort sort;
        private String userId;

        public Builder page(Integer page) {
            this.page = page;
            return this;
        }

        public Builder perPage(Integer perPage) {
            this.perPage = perPage;
            return this;
        }

        public Builder sort(Sort sort) {
            this.sort = sort;
            return this;
        }

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public GalleryListRequest build() {
            return new GalleryListRequest(this);
        }


    }

    public Integer getPage() {
        return page;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public Sort getSort() {
        return sort;
    }

    public String getUserId() {
        return userId;
    }
}
