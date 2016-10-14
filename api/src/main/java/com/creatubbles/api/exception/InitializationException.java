package com.creatubbles.api.exception;

/**
 * Created by Janek on 13.10.2016.
 */

public class InitializationException extends RuntimeException {

    public InitializationException() {
        super();
    }

    public InitializationException(String message) {
        super(message);
    }

    public InitializationException(String message, Throwable cause) {
        super(message, cause);
    }

    public InitializationException(Throwable cause) {
        super(cause);
    }
}
