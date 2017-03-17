package com.creatubbles.api.model.upload;

public enum UploadStep {
    INITIALIZED(0),
    CREATION_ALLOCATED(1),
    FILE_UPLOAD_CONFIGURED(2),
    FILE_UPLOAD_FAIL_REPORTED(3),
    FILE_UPLOAD_UPLOADED(4),
    FILE_UPLOAD_SERVER_NOTIFIED(5),
    SUBMITTED_TO_GALLERIES(6);

    private int order;

    UploadStep(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }
}
