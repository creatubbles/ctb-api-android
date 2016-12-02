package com.creatubbles.api.model.creation;

import android.support.annotation.NonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ApprovalStatus {
    APPROVED("approved"),
    UNAPPROVED("unapproved"),
    REJECTED("rejected");

    private String name;

    ApprovalStatus(String name) {
        this.name = name;
    }

    @JsonCreator
    public static ApprovalStatus fromName(String name) {
        for (ApprovalStatus approvalStatus : values()) {
            if (approvalStatus.name.equals(name)) {
                return approvalStatus;
            }
        }
        return null;
    }

    @JsonValue
    @NonNull
    public String getName() {
        return name;
    }
}
