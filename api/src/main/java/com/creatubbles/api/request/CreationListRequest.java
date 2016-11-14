package com.creatubbles.api.request;

import com.creatubbles.api.service.GallerySortMode;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Janek on 11.02.2016.
 */
public class CreationListRequest {


    @JsonProperty("page")
    private Integer page;

    @JsonProperty("per_page")
    private Integer perPage;

    @JsonProperty("gallery_id")
    private String galleryId;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("sort")
    private GallerySortMode sort;

    @JsonProperty("search")
    private String keyword;

    @JsonCreator
    CreationListRequest() {
    }

    CreationListRequest(Builder builder) {
        this.page = builder.page;
        this.perPage = builder.perPage;
        this.galleryId = builder.galleryId;
        this.userId = builder.userId;
        this.sort = builder.sort;
        this.keyword = builder.keyword;
    }

    public static class Builder {

        Integer page;
        Integer perPage;
        String galleryId;
        String userId;
        GallerySortMode sort;
        String keyword;

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

    public GallerySortMode getSort() {
        return sort;
    }

    public String getKeyword() {
        return keyword;
    }
}
