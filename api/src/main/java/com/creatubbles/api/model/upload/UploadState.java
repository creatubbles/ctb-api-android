package com.creatubbles.api.model.upload;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class UploadState {
    private UploadStep uploadStep = UploadStep.INITIALIZED;
    private String allocatedCreationId;
    private Upload uploadMeta;
    private float uploadProgress;
    private Deque<String> unUpdatedGalleries;

    public UploadState() {
        unUpdatedGalleries = new ArrayDeque<>();
    }

    public UploadStep getUploadStep() {
        return uploadStep;
    }

    public void setUploadStep(UploadStep uploadStep) {
        this.uploadStep = uploadStep;
    }

    public String getAllocatedCreationId() {
        return allocatedCreationId;
    }

    public void setAllocatedCreationId(String allocatedCreationId) {
        this.allocatedCreationId = allocatedCreationId;
    }

    public Upload getUploadMeta() {
        return uploadMeta;
    }

    public void setUploadMeta(Upload uploadMeta) {
        this.uploadMeta = uploadMeta;
    }

    public float getUploadProgress() {
        return uploadProgress;
    }

    public void setUploadProgress(float uploadProgress) {
        this.uploadProgress = uploadProgress;
    }

    public Deque<String> getUnUpdatedGalleries() {
        return unUpdatedGalleries;
    }

    public String serialize() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }

    public static UploadState deserialize(String serialized) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(serialized, UploadState.class);
    }
}
