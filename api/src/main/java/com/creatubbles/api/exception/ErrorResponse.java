package com.creatubbles.api.exception;

import java.util.List;

/**
 * Created by mariuszostapowicz on 08.03.2016.
 */
public class ErrorResponse {
    private List<Error> errors;

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
