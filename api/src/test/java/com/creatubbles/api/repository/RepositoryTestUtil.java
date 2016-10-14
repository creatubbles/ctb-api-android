package com.creatubbles.api.repository;

import android.support.annotation.NonNull;

import org.mockito.stubbing.Answer;

import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author Pawel Szymanski
 */
public class RepositoryTestUtil {
    @SuppressWarnings("unchecked")
    @NonNull
    static Answer getSuccessfulAnswer(Object mockedBody) {
        return invocation -> {
            Object[] args = invocation.getArguments();
            Callback retrofitCallback = (Callback) args[args.length - 1];
            retrofitCallback.onResponse(null, Response.success(mockedBody));
            return null;
        };
    }

    @SuppressWarnings("unchecked")
    @NonNull
    static Answer getFailedAnswer(String message) {
        return invocation -> {
            Object[] args = invocation.getArguments();
            Callback retrofitCallback = ((Callback) args[args.length - 1]);
            retrofitCallback.onFailure(null, new Exception(message));
            return null;
        };
    }
}
