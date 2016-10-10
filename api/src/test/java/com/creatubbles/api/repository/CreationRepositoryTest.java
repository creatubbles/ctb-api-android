package com.creatubbles.api.repository;

import com.creatubbles.api.model.creation.Creation;
import com.creatubbles.api.model.upload.Upload;
import com.creatubbles.api.request.CreationListRequest;
import com.creatubbles.api.request.UploadRequest;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.CreationService;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;


public class CreationRepositoryTest {

    private static final String ERROR_MESSAGE = "What an error!";
    private CreationRepository target;

    @Mock
    ResponseCallback<List<Creation>> creationListResponseCallback;

    @Mock
    ResponseCallback<Creation> creationResponseCallback;

    @Mock
    ResponseCallback<Void> updateCreationResponseCallback;

    @Mock
    ResponseCallback<Upload> uploadResponseCallback;

    @Mock
    CreationService mockedCreationService;

    @Mock
    Call<JSONAPIDocument<Creation>> call;

    @Mock
    JSONAPIDocument<?> mockBody;

    @Mock
    Call<Void> voidCall;

    @Mock
    Call<JSONAPIDocument<Upload>> uploadCall;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        target = new CreationRepositoryImpl(mockedCreationService);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testGetCreationListSuccessfulRequest() {
        Answer successfulAnswer = invocation -> {
            Object[] getCreationListTokenArguments = invocation.getArguments();
            Callback<JSONAPIDocument<?>> retrofitCallback = (Callback<JSONAPIDocument<?>>)
                    getCreationListTokenArguments[getCreationListTokenArguments.length - 1];
            retrofitCallback.onResponse(null, Response.success(mockBody));
            return null;
        };

        mockCreationServiceAnswerForCreationList(successfulAnswer);

        target.getCretiationsList(any(CreationListRequest.class), creationListResponseCallback);

        verify(creationListResponseCallback, never()).onError(any(String.class));
        verify(creationListResponseCallback).onSuccess(anyListOf(Creation.class));
    }


    @SuppressWarnings("unchecked")
    @Test
    public void testGetCreationByIdSuccessfulRequest() {
        Answer successfulAnswer = invocation -> {
            Object[] getCreationByIdTokenArguments = invocation.getArguments();
            Callback<JSONAPIDocument<?>> retrofitCallback = ((Callback<JSONAPIDocument<?>>)
                    getCreationByIdTokenArguments[getCreationByIdTokenArguments.length - 1]);

            retrofitCallback.onResponse(null, Response.success(mockBody));
            return null;
        };

        mockCreationServiceAnswerForCreationById(successfulAnswer);

        target.getCreationById(any(String.class), creationResponseCallback);

        verify(creationResponseCallback, never()).onError(any(String.class));
        verify(creationResponseCallback).onSuccess(any(Creation.class));
    }


    @SuppressWarnings("unchecked")
    @Test
    public void testUpdateCreationSuccessfulRequest() {
        Answer successfulAnswer = invocation -> {
            Object[] getUpdateCreationTokenArguments = invocation.getArguments();
            Callback<Void> retrofitCallback = ((Callback<Void>)
                    getUpdateCreationTokenArguments[getUpdateCreationTokenArguments.length -
                            1]);

            retrofitCallback.onResponse(null, Response.success(any(Void.class)));
            return null;
        };

        mockCreationServiceAnswerForCreationUpdate(successfulAnswer);

        target.updateCreation(any(String.class), any(Creation.class),
                updateCreationResponseCallback);

        verify(updateCreationResponseCallback, never()).onError(any(String.class));
        verify(updateCreationResponseCallback).onSuccess(any(Void.class));
    }

    @Test
    public void testGetCreationListFailedRequest() {
        Answer failedAnswer = invocation -> {
            Object[] getCreationListTokenArguments = invocation.getArguments();

            Callback<?> retrofitCallback = ((Callback)
                    getCreationListTokenArguments[getCreationListTokenArguments.length - 1]);

            retrofitCallback.onFailure(null, new Exception(ERROR_MESSAGE));
            return null;
        };

        mockCreationServiceAnswerForCreationList(failedAnswer);
        target.getCretiationsList(any(CreationListRequest.class), creationListResponseCallback);

        verify(creationListResponseCallback).onError(ERROR_MESSAGE);
        verify(creationListResponseCallback, never()).onSuccess(anyListOf(Creation.class));
    }

    @Test
    public void testGetCreationByIdFailedRequest() {
        Answer failedAnswer = invocation -> {
            Object[] getCreationByIdTokenArguments = invocation.getArguments();

            Callback<?> retrofitCallback = ((Callback)
                    getCreationByIdTokenArguments[getCreationByIdTokenArguments.length - 1]);

            retrofitCallback.onFailure(null, new Exception(ERROR_MESSAGE));
            return null;
        };
        mockCreationServiceAnswerForCreationById(failedAnswer);
        target.getCreationById(any(String.class), creationResponseCallback);

        verify(creationResponseCallback).onError(ERROR_MESSAGE);
        verify(creationResponseCallback, never()).onSuccess(any(Creation.class));
    }

    @Test
    public void testUpdateCreationFailedRequest() {
        Answer failedAnswer = invocation -> {
            Object[] updateCreationTokenArguments = invocation.getArguments();

            Callback<?> retrofitCallback = ((Callback)
                    updateCreationTokenArguments[updateCreationTokenArguments.length - 1]);
            retrofitCallback.onFailure(null, new Exception(ERROR_MESSAGE));
            return null;
        };
        mockCreationServiceAnswerForCreationUpdate(failedAnswer);
        target.updateCreation(any(String.class), any(Creation.class),
                updateCreationResponseCallback);

        verify(updateCreationResponseCallback).onError(ERROR_MESSAGE);
        verify(updateCreationResponseCallback, never()).onSuccess(any(Void.class));
    }

    @Test
    public void testCreateCreationFailedRequest() {
        Answer failedAnswer = invocation -> {
            Object[] getCreationListTokenArguments = invocation.getArguments();

            Callback<?> retrofitCallback = ((Callback)
                    getCreationListTokenArguments[getCreationListTokenArguments.length - 1]);

            retrofitCallback.onFailure(null, new Exception(ERROR_MESSAGE));
            return null;
        };

        mockCreationServiceAnswerForCreateCreation(failedAnswer);
        target.createCreation(any(Creation.class), creationResponseCallback);

        verify(creationResponseCallback).onError(ERROR_MESSAGE);
        verify(creationResponseCallback, never()).onSuccess(any(Creation.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testCreateCreationSuccessfulRequest() {
        Answer successfulAnswer = invocation -> {
            Object[] getCreationListTokenArguments = invocation.getArguments();
            Callback<JSONAPIDocument<?>> retrofitCallback = ((Callback<JSONAPIDocument<?>>)
                    getCreationListTokenArguments[getCreationListTokenArguments.length - 1]);
            retrofitCallback.onResponse(null, Response.success(mockBody));
            return null;
        };

        mockCreationServiceAnswerForCreateCreation(successfulAnswer);
        target.createCreation(any(Creation.class), creationResponseCallback);

        verify(creationResponseCallback, never()).onError(any(String.class));
        verify(creationResponseCallback).onSuccess(any(Creation.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testCreateUploadSuccessfulRequest() {
        Answer successfulAnswer = invocation -> {
            Object[] createUploadTokenArguments = invocation.getArguments();
            Callback<JSONAPIDocument<?>> retrofitCallback = ((Callback<JSONAPIDocument<?>>)
                    createUploadTokenArguments[createUploadTokenArguments.length - 1]);
            retrofitCallback.onResponse(null, Response.success(mockBody));
            return null;
        };

        mockCreationServiceAnswerForCreateUpload(successfulAnswer);
        target.createUpload(any(String.class), any(UploadRequest.class), uploadResponseCallback);

        verify(uploadResponseCallback, never()).onError(any(String.class));
        verify(uploadResponseCallback).onSuccess(any(Upload.class));
    }

    @Test
    public void testCreateUploadFailedRequest() {
        Answer failedAnswer = invocation -> {
            Object[] createUploadTokenArguments = invocation.getArguments();
            Callback<?> retrofitCallback = ((Callback)
                    createUploadTokenArguments[createUploadTokenArguments.length - 1]);
            retrofitCallback.onFailure(null, new Exception(ERROR_MESSAGE));
            return null;
        };

        mockCreationServiceAnswerForCreateUpload(failedAnswer);
        target.createUpload(any(String.class), any(UploadRequest.class), uploadResponseCallback);

        verify(uploadResponseCallback).onError(ERROR_MESSAGE);
        verify(uploadResponseCallback, never()).onSuccess(any(Upload.class));
    }


    private void mockCreationServiceAnswerForCreationList(Answer answer) {
        doAnswer(answer).when(call).enqueue(any());

        doReturn(call).when(mockedCreationService).getListOfCreation(any(CreationListRequest
                .class));
    }

    private void mockCreationServiceAnswerForCreationById(Answer answer) {
        doAnswer(answer).when(call).enqueue(any());

        doReturn(call).when(mockedCreationService).getCreationById(any(String.class));
    }


    private void mockCreationServiceAnswerForCreationUpdate(Answer answer) {
        doAnswer(answer).when(voidCall).enqueue(any());

        doReturn(voidCall).when(mockedCreationService).updateCreation(any(String.class), any
                (Creation.class));
    }

    private void mockCreationServiceAnswerForCreateCreation(Answer answer) {
        doAnswer(answer).when(call).enqueue(any());

        doReturn(call).when(mockedCreationService).createCreation(any(Creation.class));
    }

    private void mockCreationServiceAnswerForCreateUpload(Answer answer) {
        doAnswer(answer).when(uploadCall).enqueue(any());

        doReturn(uploadCall).when(mockedCreationService).createUpload(any(String.class), any
                (UploadRequest.class));
    }

}
