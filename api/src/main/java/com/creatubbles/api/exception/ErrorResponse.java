package com.creatubbles.api.exception;

import java.util.List;

/**
 * Created by mariuszostapowicz on 08.03.2016.
 */
public class ErrorResponse {
    private Integer status;
    private List<Error> errors;

    public Integer getStatus() {
        return status;
    }

    public List<Error> getErrors() {
        return errors;
    }


}
