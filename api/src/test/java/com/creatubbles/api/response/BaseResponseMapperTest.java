package com.creatubbles.api.response;

import android.support.annotation.Nullable;

import com.creatubbles.api.exception.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * @author Pawel Szymanski
 */
@RunWith(MockitoJUnitRunner.class)
public class BaseResponseMapperTest {

    @Mock
    ResponseCallback<Object> responseCallback;

    private BaseResponseMapper<Object, Object> responseMapper;
    private ObjectMapper objectMapper;

    @Before
    public void setUp() throws Exception {
        objectMapper = givenMapperWithAnswer(invocation -> mock(ErrorResponse.class));
        responseMapper = new BaseResponseMapper<>(objectMapper, responseCallback);
    }

    @Test
    public void shouldCallOnSuccessWhenResponseIsSuccessful() throws Exception {
        responseMapper.onResponse(anyCall(), anySuccessfulResponse());

        verify(responseCallback).onSuccess(any());
    }

    @Test
    public void shouldCallOnServerErrorWhenResponseIsNotSuccessful() throws Exception {
        responseMapper.onResponse(anyCall(), anyUnsuccessfulResponse());

        verify(responseCallback).onServerError(any());
    }

    @Test
    public void shouldCallOnErrorWhenOnFailureIsCalled() throws Exception {
        responseMapper.onFailure(anyCall(), anyThrowable());

        verify(responseCallback).onError(anyString());
    }

    @Test
    public void shouldCallOnErrorWhenErrorParsingFailed() throws Exception {
        objectMapper = givenMapperWithAnswer(invocation -> {
            throw mock(IOException.class);
        });
        responseMapper = new BaseResponseMapper<>(objectMapper, responseCallback);

        responseMapper.onResponse(anyCall(), anyUnsuccessfulResponse());

        verify(responseCallback).onError(anyString());
    }

    private ObjectMapper givenMapperWithAnswer(Answer answer) {
        return mock(ObjectMapper.class, answer);
    }

    private Throwable anyThrowable() {
        return new Throwable("asfd");
    }

    private Response<Object> anySuccessfulResponse() {
        return Response.success(null);
    }

    private Response<Object> anyUnsuccessfulResponse() {
        return Response.error(400, ResponseBody.create(MediaType.parse(""), new byte[0]));
    }

    @Nullable
    private Call<Object> anyCall() {
        return null;
    }
}