package com.creatubbles.api.model.upload;

import com.google.gson.annotations.SerializedName;

public class Attributes {

    @SerializedName("url")
    private String url;

    @SerializedName("content_type")
    private String contentType;

    @SerializedName("ping_url")
    private String pingUrl;

    @SerializedName("completed_at")
    private Object completedAt;

    public String getUrl() {
        return url;
    }


    public String getContentType() {
        return contentType;
    }

    public String getPingUrl() {
        return pingUrl;
    }

    public Object getCompletedAt() {
        return completedAt;
    }


}
