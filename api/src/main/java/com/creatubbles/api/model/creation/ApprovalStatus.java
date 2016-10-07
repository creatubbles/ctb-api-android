package com.creatubbles.api.model.creation;

public enum ApprovalStatus {
    APPROVED("approved"),
    UNAPPROVED("unapproved"),
    REJECTED("rejected");


    private String status;

    ApprovalStatus(String status) {
        this.status = status;
    }

    public static ApprovalStatus fromName(String name) {
        for (ApprovalStatus approvalStatus : values()) {
            if (approvalStatus.status.equals(name)) {
                return approvalStatus;
            }
        }
        return null;
    }

    public String getStatus() {
        return status;
    }
}
