package com.creatubbles.api.request;

import com.creatubbles.api.service.Sort;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Janek on 11.02.2016.
 */
public class CreationListRequest {


    @SerializedName("page")
    private final Integer page;

    @SerializedName("per_page")
    private final Integer perPage;

    @SerializedName("gallery_id")
    private final String galleryId;

    @SerializedName("user_id")
    private final String userId;

    @SerializedName("sort")
    private final Sort sort;

    @SerializedName("search")
    private final String keyword;

    private CreationListRequest(Builder builder) {
        this.page = builder.page;
        this.perPage = builder.perPage;
        this.galleryId = builder.galleryId;
        this.userId = builder.userId;
        this.sort = builder.sort;
        this.keyword = builder.keyword;
    }

    public static class Builder {

        private Integer page;
        private Integer perPage;
        private String galleryId;
        private String userId;
        private Sort sort;
        private String keyword;

        public Builder page(Integer page) {
            this.page = page;
            return this;
        }

        public Builder perPage(Integer perPage) {
            this.perPage = perPage;
            return this;
        }

        public Builder galleryId(String galleryId) {
            this.galleryId = galleryId;
            return this;
        }

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder keyword(String keyword) {
            this.keyword = keyword;
            return this;
        }

        public CreationListRequest build() {
            return new CreationListRequest(this);
        }
    }

    public Integer getPage() {
        return page;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public String getGalleryId() {
        return galleryId;
    }

    public String getUserId() {
        return userId;
    }

    public Sort getSort() {
        return sort;
    }

    public String getKeyword() {
        return keyword;
    }
}
