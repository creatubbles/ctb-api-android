package com.creatubbles.api.model.upload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Type;

import java.util.Date;

@Type("uploads")
public class Upload {

    @Id
    private String id;

    private String url;

    @JsonProperty("content_type")
    private String contentType;

    @JsonProperty("ping_url")
    private String pingUrl;

    @JsonProperty("created_at")
    private Date createdAt;

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getContentType() {
        return contentType;
    }

    public String getPingUrl() {
        return pingUrl;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Upload{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", contentType='" + contentType + '\'' +
                ", pingUrl='" + pingUrl + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
