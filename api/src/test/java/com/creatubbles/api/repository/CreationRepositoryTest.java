package com.creatubbles.api.repository;

import com.creatubbles.api.model.CreationListResponse;
import com.creatubbles.api.model.CreationResponse;
import com.creatubbles.api.model.UploadResponse;
import com.creatubbles.api.request.CreationListRequest;
import com.creatubbles.api.request.CreationRequest;
import com.creatubbles.api.request.UploadRequest;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.CreationService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.robolectric.RobolectricTestRunner;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;


/**
 * Created by Janek on 07.03.2016.
 */
@RunWith(RobolectricTestRunner.class)
public class CreationRepositoryTest {


    private static final String ERROR_MESSAGE = "What an error!";
    private CreationRepository target;

    @Mock
    ResponseCallback<CreationListResponse> creationListResponseCallback;

    @Mock
    ResponseCallback<CreationResponse> creationResponseCallback;

    @Mock
    ResponseCallback<Void> updateCreationResponseCallback;

    @Mock
    ResponseCallback<UploadResponse> uploadResponseCallback;

    @Mock
    CreationService mockedCreationService;

    @Mock
    Call<CreationResponse> call;

    @Mock
    Call<Void> voidCall;

    @Mock
    Call<UploadResponse> uploadCall;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        target = new CreationRepositoryImpl(mockedCreationService);
    }

    @Test
    public void testGetCreationListSuccessfulRequest() {
        Answer successfulAnswer = new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] getCreationListTokenArguments = invocation.getArguments();
                Callback retrofitCallback = ((Callback)
                        getCreationListTokenArguments[getCreationListTokenArguments.length - 1]);
                retrofitCallback.onResponse(null, Response.success(any(CreationResponse.class)));
                return null;
            }
        };

        mockCreationServiceAnswerForCreationList(successfulAnswer);

        target.getCretiationsList(any(CreationListRequest.class), creationListResponseCallback);

        verify(creationListResponseCallback, never()).onError(any(String.class));
        verify(creationListResponseCallback).onSuccess(any(CreationListResponse.class));
    }


    @Test
    public void testGetCreationByIdSuccessfulRequest() {
        Answer successfulAnswer = new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] getCreationByIdTokenArguments = invocation.getArguments();
                Callback retrofitCallback = ((Callback)
                        getCreationByIdTokenArguments[getCreationByIdTokenArguments.length - 1]);

                retrofitCallback.onResponse(null, Response.success(any(CreationResponse.class)));
                return null;
            }
        };

        mockCreationServiceAnswerForCreationById(successfulAnswer);

        target.getCreationById(any(String.class), creationResponseCallback);

        verify(creationResponseCallback, never()).onError(any(String.class));
        verify(creationResponseCallback).onSuccess(any(CreationResponse.class));
    }


    @Test
    public void testUpdateCreationSuccessfulRequest() {
        Answer successfulAnswer = new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] getUpdateCreationTokenArguments = invocation.getArguments();
                Callback retrofitCallback = ((Callback)
                        getUpdateCreationTokenArguments[getUpdateCreationTokenArguments.length -
                                1]);

                retrofitCallback.onResponse(null, Response.success(any(Void.class)));
                return null;
            }
        };

        mockCreationServiceAnswerForCreationUpdate(successfulAnswer);

        target.updateCreation(any(String.class), any(CreationRequest.class),
                updateCreationResponseCallback);

        verify(updateCreationResponseCallback, never()).onError(any(String.class));
        verify(updateCreationResponseCallback).onSuccess(any(Void.class));
    }

    @Test
    public void testGetCreationListFailedRequest() {
        Answer failedAnswer = new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] getCreationListTokenArguments = invocation.getArguments();

                Callback retrofitCallback = ((Callback)
                        getCreationListTokenArguments[getCreationListTokenArguments.length - 1]);

                retrofitCallback.onFailure(null, new Exception(ERROR_MESSAGE));
                return null;
            }
        };

        mockCreationServiceAnswerForCreationList(failedAnswer);
        target.getCretiationsList(any(CreationListRequest.class), creationListResponseCallback);

        verify(creationListResponseCallback).onError(ERROR_MESSAGE);
        verify(creationListResponseCallback, never()).onSuccess(any(CreationListResponse.class));
    }

    @Test
    public void testGetCreationByIdFailedRequest() {
        Answer failedAnswer = new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] getCreationByIdTokenArguments = invocation.getArguments();

                Callback retrofitCallback = ((Callback)
                        getCreationByIdTokenArguments[getCreationByIdTokenArguments.length - 1]);

                retrofitCallback.onFailure(null, new Exception(ERROR_MESSAGE));
                return null;
            }
        };
        mockCreationServiceAnswerForCreationById(failedAnswer);
        target.getCreationById(any(String.class), creationResponseCallback);

        verify(creationResponseCallback).onError(ERROR_MESSAGE);
        verify(creationResponseCallback, never()).onSuccess(any(CreationResponse.class));
    }

    @Test
    public void testUpdateCreationFailedRequest() {
        Answer failedAnswer = new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] updateCreationTokenArguments = invocation.getArguments();

                Callback retrofitCallback = ((Callback)
                        updateCreationTokenArguments[updateCreationTokenArguments.length - 1]);
                retrofitCallback.onFailure(null, new Exception(ERROR_MESSAGE));
                return null;
            }
        };
        mockCreationServiceAnswerForCreationUpdate(failedAnswer);
        target.updateCreation(any(String.class), any(CreationRequest.class),
                updateCreationResponseCallback);

        verify(updateCreationResponseCallback).onError(ERROR_MESSAGE);
        verify(updateCreationResponseCallback, never()).onSuccess(any(Void.class));
    }

    @Test
    public void testCreateCreationFailedRequest() {
        Answer failedAnswer = new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] getCreationListTokenArguments = invocation.getArguments();

                Callback retrofitCallback = ((Callback)
                        getCreationListTokenArguments[getCreationListTokenArguments.length - 1]);

                retrofitCallback.onFailure(null, new Exception(ERROR_MESSAGE));
                return null;
            }
        };

        mockCreationServiceAnswerForCreateCreation(failedAnswer);
        target.createCreation(any(CreationRequest.class), creationResponseCallback);

        verify(creationResponseCallback).onError(ERROR_MESSAGE);
        verify(creationResponseCallback, never()).onSuccess(any(CreationResponse.class));
    }

    @Test
    public void testCreateCreationSuccessfulRequest() {
        Answer successfulAnswer = new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] getCreationListTokenArguments = invocation.getArguments();
                Callback retrofitCallback = ((Callback)
                        getCreationListTokenArguments[getCreationListTokenArguments.length - 1]);
                retrofitCallback.onResponse(null, Response.success(any(CreationResponse.class)));
                return null;
            }
        };

        mockCreationServiceAnswerForCreateCreation(successfulAnswer);
        target.createCreation(any(CreationRequest.class), creationResponseCallback);

        verify(creationResponseCallback, never()).onError(any(String.class));
        verify(creationResponseCallback).onSuccess(any(CreationResponse.class));
    }

    @Test
    public void testCreateUploadSuccessfulRequest() {
        Answer successfulAnswer = new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] createUploadTokenArguments = invocation.getArguments();
                Callback retrofitCallback = ((Callback)
                        createUploadTokenArguments[createUploadTokenArguments.length - 1]);
                retrofitCallback.onResponse(null, Response.success(any(UploadResponse.class)));
                return null;
            }
        };

        mockCreationServiceAnswerForCreateUpload(successfulAnswer);
        target.createUpload(any(String.class), any(UploadRequest.class), uploadResponseCallback);

        verify(uploadResponseCallback, never()).onError(any(String.class));
        verify(uploadResponseCallback).onSuccess(any(UploadResponse.class));
    }

    @Test
    public void testCreateUploadFailedRequest() {
        Answer failedAnswer = new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] createUploadTokenArguments = invocation.getArguments();
                Callback retrofitCallback = ((Callback)
                        createUploadTokenArguments[createUploadTokenArguments.length - 1]);
                retrofitCallback.onFailure(null, new Exception(ERROR_MESSAGE));
                return null;
            }
        };

        mockCreationServiceAnswerForCreateUpload(failedAnswer);
        target.createUpload(any(String.class), any(UploadRequest.class), uploadResponseCallback);

        verify(uploadResponseCallback).onError(ERROR_MESSAGE);
        verify(uploadResponseCallback, never()).onSuccess(any(UploadResponse.class));
    }


    private void mockCreationServiceAnswerForCreationList(Answer answer) {
        doAnswer(answer).when(call).enqueue(any(Callback.class));

        doReturn(call).when(mockedCreationService).getListOfCreation(any(CreationListRequest
                .class));
    }

    private void mockCreationServiceAnswerForCreationById(Answer answer) {
        doAnswer(answer).when(call).enqueue(any(Callback.class));

        doReturn(call).when(mockedCreationService).getCreationById(any(String.class));
    }


    private void mockCreationServiceAnswerForCreationUpdate(Answer answer) {
        doAnswer(answer).when(voidCall).enqueue(any(Callback.class));

        doReturn(voidCall).when(mockedCreationService).updateCreation(any(String.class), any
                (CreationRequest.class));
    }

    private void mockCreationServiceAnswerForCreateCreation(Answer answer) {
        doAnswer(answer).when(call).enqueue(any(Callback.class));

        doReturn(call).when(mockedCreationService).createCreation(any(CreationRequest
                .class));
    }

    private void mockCreationServiceAnswerForCreateUpload(Answer answer) {
        doAnswer(answer).when(uploadCall).enqueue(any(Callback.class));

        doReturn(uploadCall).when(mockedCreationService).createUpload(any(String.class), any
                (UploadRequest.class));
    }

}
