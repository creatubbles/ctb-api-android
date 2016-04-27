package com.creatubbles.api.repository;

import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.UploadService;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.doAnswer;
import static org.powermock.api.mockito.PowerMockito.doReturn;
import static org.powermock.api.mockito.PowerMockito.when;


/**
 * Created by Mariusz Ostapowicz on 20.03.2016.
 */
@RunWith(RobolectricTestRunner.class)
@PowerMockIgnore({ "org.mockito.*", "org.robolectric.*", "android.*" })
@PrepareForTest(RequestBody.class)
public class UploadRepositoryTest {

    @Rule
    public PowerMockRule rule = new PowerMockRule();

    private static final String ERROR_MESSAGE = "What an error!";
    private UploadRepository target;

    @Mock
    ResponseCallback<String> responseCallback;

    @Mock
    UploadService mockedUploadService;

    @Mock
    Call<String> uploadCall;

    @Mock
    RequestBody requestBody;

    File file;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        target = new UploadRepositoryImpl(mockedUploadService, RuntimeEnvironment.application);
    }

    @Test
    public void testUserByIdSuccessfulRequest() {
        Answer successfulAnswer = new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] arg = invocation.getArguments();
                Callback retrofitCallback = ((Callback) arg[arg.length - 1]);
                retrofitCallback.onResponse(null, Response.success(any(String.class)));
                return null;
            }
        };
        mockUploadServiceAnswerForUploadFile(successfulAnswer);
        target.uploadFile(any(String.class), any(MediaType.class), file, responseCallback);
        verify(responseCallback, never()).onError(any(String.class));
        verify(responseCallback).onSuccess(any(String.class));
    }

    @Test
    public void testUserByIdFailedRequest() {
        Answer failedAnswer = new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] arg = invocation.getArguments();
                Callback retrofitCallback = ((Callback) arg[arg.length - 1]);
                retrofitCallback.onFailure(null, new Exception(ERROR_MESSAGE));
                return null;
            }
        };
        mockUploadServiceAnswerForUploadFile(failedAnswer);
        target.uploadFile(any(String.class), any(MediaType.class), file, responseCallback);
        verify(responseCallback).onError(ERROR_MESSAGE);
        verify(responseCallback, never()).onSuccess(any(String.class));
    }


    private void mockUploadServiceAnswerForUploadFile(Answer answer) {
        PowerMockito.mockStatic(RequestBody.class);
        when(RequestBody.create(any(MediaType.class), any(File.class))).thenReturn(requestBody);

        doAnswer(answer).when(uploadCall).enqueue(any(Callback.class));
        doReturn(uploadCall).when(mockedUploadService).uploadFile(anyString(), any(RequestBody.class));
    }


}
