package com.creatubbles.api.exception;

import android.support.annotation.NonNull;

import java.util.Collections;
import java.util.List;

/**
 * Created by mariuszostapowicz on 08.03.2016.
 */
public class ErrorResponse {
    private final List<Error> errors;

    public ErrorResponse() {
        errors = Collections.emptyList();
    }

    public ErrorResponse(List<Error> errors) {
        this.errors = errors;
    }

    @NonNull
    public List<Error> getErrors() {
        return errors;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "errors=" + errors +
                '}';
    }
}
