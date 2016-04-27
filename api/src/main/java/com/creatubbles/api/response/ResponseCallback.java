package com.creatubbles.api.response;

import com.creatubbles.api.exception.ErrorResponse;

/**
 * @author Matthew Platek on 11.02.2016.
 */
public interface ResponseCallback<T> {

    void onSuccess(T response);

    void onServerError(ErrorResponse errorResponse);

    void onError(String message);
}
