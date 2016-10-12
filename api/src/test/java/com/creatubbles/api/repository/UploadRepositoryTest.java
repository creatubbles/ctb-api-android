package com.creatubbles.api.repository;

import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.UploadService;
import com.creatubbles.api.utils.UploadRepositoryCacheUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
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
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;


/**
 * Created by Mariusz Ostapowicz on 20.03.2016.
 */
@RunWith(RobolectricTestRunner.class)
@PowerMockIgnore({"org.mockito.*", "org.robolectric.*", "android.*"})
@PrepareForTest(UploadRepositoryCacheUtil.class)
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

    private MediaType mediaType;

    private File file;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        PowerMockito.mockStatic(UploadRepositoryCacheUtil.class);
        target = new UploadRepositoryImpl(new ObjectMapper(), mockedUploadService, RuntimeEnvironment.application);
        file = new File("");
        mediaType = MediaType.parse("test/type");
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testUserByIdSuccessfulRequest() {
        Answer successfulAnswer = invocation -> {
            Object[] arg = invocation.getArguments();
            Callback<String> retrofitCallback = ((Callback<String>) arg[arg.length - 1]);
            retrofitCallback.onResponse(null, Response.success(""));
            return null;
        };
        mockUploadServiceAnswerForUploadFile(successfulAnswer);
        target.uploadFile("", mediaType, file, responseCallback);
        verify(responseCallback, never()).onError(any(String.class));
        verify(responseCallback).onSuccess(any(String.class));
        verifyStatic();
        UploadRepositoryCacheUtil.removeFileFromSendCache(anyString(), any(), anyString(), any());
    }

    @Test
    public void testUserByIdFailedRequest() {
        Answer failedAnswer = invocation -> {
            Object[] arg = invocation.getArguments();
            Callback<?> retrofitCallback = ((Callback) arg[arg.length - 1]);
            retrofitCallback.onFailure(null, new Exception(ERROR_MESSAGE));
            return null;
        };
        mockUploadServiceAnswerForUploadFile(failedAnswer);
        target.uploadFile("", mediaType, file, responseCallback);
        verify(responseCallback).onError(ERROR_MESSAGE);
        verify(responseCallback, never()).onSuccess(any(String.class));
        verifyStatic();
        UploadRepositoryCacheUtil.addFileToSendCache(anyString(), any(), anyString(), any());
    }


    private void mockUploadServiceAnswerForUploadFile(Answer answer) {
        Mockito.doAnswer(answer).when(uploadCall).enqueue(any());
        doReturn(uploadCall).when(mockedUploadService).uploadFile(anyString(), any(RequestBody.class));
    }


}
