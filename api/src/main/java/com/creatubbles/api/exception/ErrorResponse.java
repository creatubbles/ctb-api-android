package com.creatubbles.api.exception;

import android.support.annotation.NonNull;

import java.util.Collections;
import java.util.List;

/**
 * Created by mariuszostapowicz on 08.03.2016.
 */
public class ErrorResponse {
    private final List<Error> errors = Collections.emptyList();

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
