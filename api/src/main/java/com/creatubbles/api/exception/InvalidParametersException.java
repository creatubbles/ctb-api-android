package com.creatubbles.api.exception;

/**
 * Created by Janek on 27.04.2016.
 */
public class InvalidParametersException extends IllegalStateException {

    public InvalidParametersException() {
        super();
    }

    public InvalidParametersException(Throwable throwable) {
        super(throwable);
    }

    public InvalidParametersException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public InvalidParametersException(String detailMessage) {
        super(detailMessage);
    }
}
