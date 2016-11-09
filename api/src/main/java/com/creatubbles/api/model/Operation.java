package com.creatubbles.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by Janek on 04.11.2016.
 */

public enum Operation {

    EDIT("edit"),
    REPORT("report"),
    SEE_REFLECTION_TEXT("see_reflection_text"),
    SEE_REFLECTION_VIDEO("see_reflection_video"),
    SHARE("share"),
    SUBMIT_TO("submit_to"),
    SWITCH("switch"),
    SWITCH_WITHOUT_PASSWORD("switch_without_password"),
    CUSTOMIZE("customize"),
    SHARE_FULLY("share_fully"),
    DECLINE("decline"),
    APPROVE("approve"),
    DELETE("delete"),
    DESTROY("destroy");

    private String operationName;

    Operation(String operationName) {
        this.operationName = operationName;
    }

    @JsonValue
    public String getOperationName() {
        return operationName;
    }

    @JsonCreator
    public static Operation fromName(String operationName) {
        for (Operation operation : values()) {
            if (operation.operationName.equals(operationName)) {
                return operation;
            }
        }
        return null;
    }
}
