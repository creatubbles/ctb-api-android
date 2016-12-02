package com.creatubbles.api.model.upload;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

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

    @JsonProperty("updated_at")
    private Date updatedAt;

    @JsonProperty("completed_at")
    private Date completedAt;

    private boolean aborted;

    @JsonProperty("aborted_with")
    private String abortedWith;

    @JsonProperty("processing_completed")
    private boolean processingCompleted;

    @JsonProperty("processing_details")
    private Object processingDetails;

    @NonNull
    public String getId() {
        return id;
    }

    /**
     * @return URL to use for file uploads. Null if upload has been completed.
     */
    @Nullable
    public String getUrl() {
        return url;
    }

    @NonNull
    public String getContentType() {
        return contentType;
    }

    /**
     * @return URL to ping after upload completed or failed
     */
    @NonNull
    public String getPingUrl() {
        return pingUrl;
    }

    @NonNull
    public Date getCreatedAt() {
        return createdAt;
    }

    @NonNull
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @return datetime set when ping URL was called
     */
    @Nullable
    public Date getCompletedAt() {
        return completedAt;
    }

    /**
     * @return true if upload or processing failed
     */
    public boolean getAborted() {
        return aborted;
    }

    /**
     * @return string indicating why upload/processing failed
     */
    @Nullable
    public String getAbortedWith() {
        return abortedWith;
    }

    /**
     * @return true after processing finished
     */
    public boolean getProcessingCompleted() {
        return processingCompleted;
    }

    /**
     * @return details on processing, e.g. on failure
     */
    @Nullable
    public Object getProcessingDetails() {
        return processingDetails;
    }

    @Override
    public String toString() {
        return "Upload{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", contentType='" + contentType + '\'' +
                ", pingUrl='" + pingUrl + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", completedAt=" + completedAt +
                ", aborted=" + aborted +
                ", abortedWith='" + abortedWith + '\'' +
                ", processingCompleted=" + processingCompleted +
                ", processingDetails=" + processingDetails +
                '}';
    }
}
