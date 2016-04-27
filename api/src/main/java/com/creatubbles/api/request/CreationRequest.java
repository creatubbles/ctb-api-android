package com.creatubbles.api.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Janek on 11.02.2016.
 */
public class CreationRequest {

    @SerializedName("name")
    private final String name;

    @SerializedName("creator_ids")
    private final String[] creatorIds;

    @SerializedName("created_at_month")
    private final Integer createdAtMonth;

    @SerializedName("created_at_year")
    private final Integer createdAtYear;

    @SerializedName("reflection_text")
    private final String reflectionText;

    @SerializedName("reflection_video_url")
    private final String reflectionVideoUrl;

    public CreationRequest(Builder builder) {
        this.name = builder.name;
        this.creatorIds = builder.creatorIds;
        this.createdAtMonth = builder.createdAtMonth;
        this.createdAtYear = builder.createdAtYear;
        this.reflectionText = builder.reflectionText;
        this.reflectionVideoUrl = builder.reflectionVideoUrl;
    }

    public static class Builder {

        private String name;
        private String[] creatorIds;
        private Integer createdAtMonth;
        private Integer createdAtYear;
        private String reflectionText;
        private String reflectionVideoUrl;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder creatorIds(String[] creatorIds) {
            this.creatorIds = creatorIds;
            return this;
        }

        public Builder createdAtMonth(Integer createdAtMonth) {
            this.createdAtMonth = createdAtMonth;
            return this;
        }

        public Builder createdAtYear(Integer createdAtYear) {
            this.createdAtYear = createdAtYear;
            return this;
        }

        public Builder reflectionText(String reflectionText) {
            this.reflectionText = reflectionText;
            return this;
        }

        public Builder reflectionVideoUrl(String reflectionVideoUrl) {
            this.reflectionVideoUrl = reflectionVideoUrl;
            return this;
        }

        public CreationRequest build() {
            return new CreationRequest(this);
        }

    }

    public String getName() {
        return name;
    }

    public String[] getCreatorIds() {
        return creatorIds;
    }

    public Integer getCreatedAtMonth() {
        return createdAtMonth;
    }

    public Integer getCreatedAtYear() {
        return createdAtYear;
    }

    public String getReflectionText() {
        return reflectionText;
    }

    public String getReflectionVideoUrl() {
        return reflectionVideoUrl;
    }
}
