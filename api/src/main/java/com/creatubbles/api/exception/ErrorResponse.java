package com.creatubbles.api.exception;

import java.util.List;

/**
 * Created by mariuszostapowicz on 08.03.2016.
 */
public class ErrorResponse {
    List<Error> errors;

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

}
