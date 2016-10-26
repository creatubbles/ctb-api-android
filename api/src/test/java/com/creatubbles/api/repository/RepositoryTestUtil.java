package com.creatubbles.api.repository;

import android.support.annotation.NonNull;

import com.creatubbles.api.response.ResponseCallback;

import org.mockito.stubbing.Answer;

import retrofit2.Callback;
import retrofit2.Response;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

/**
 * @author Pawel Szymanski
 */
class RepositoryTestUtil {
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

    static <T> void verifySuccessfulResponseOn(ResponseCallback<T> creationListResponseCallback) {
        verify(creationListResponseCallback, never()).onError(any(String.class));
        verify(creationListResponseCallback).onSuccess(any());
    }

    static <T> void verifyFailedResponseOn(ResponseCallback<T> callback, String message) {
        verify(callback).onError(message);
        verify(callback, never()).onSuccess(any());
    }
}
