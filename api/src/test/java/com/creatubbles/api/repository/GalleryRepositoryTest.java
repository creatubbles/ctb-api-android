package com.creatubbles.api.repository;

import com.creatubbles.api.model.GalleryResponse;
import com.creatubbles.api.request.CreateGalleryRequest;
import com.creatubbles.api.request.GalleryListRequest;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.GalleryService;

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
public class GalleryRepositoryTest {

    private static final String ERROR_MESSAGE = "What an error!";
    private GalleryRepository target;

    @Mock
    ResponseCallback<GalleryResponse> galleryResponseCallback;

    @Mock
    GalleryService mockedGalleryService;

    @Mock
    Call<GalleryResponse> call;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        target = new GalleryRepositoryImpl(mockedGalleryService);
    }

    @Test
    public void testGetGalleryByIdSuccessfulRequest() {
        Answer successfulAnswer = new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] getGalleryByIdArguments = invocation.getArguments();
                Callback retrofitCallback = ((Callback)
                        getGalleryByIdArguments[getGalleryByIdArguments.length - 1]);

                retrofitCallback.onResponse(null, Response.success(any(GalleryResponse.class)));
                return null;
            }
        };

        mockGalleryServiceForGalleryById(successfulAnswer);
        target.getGalleryById(any(String.class), galleryResponseCallback);

        verify(galleryResponseCallback, never()).onError(any(String.class));
        verify(galleryResponseCallback).onSuccess(any(GalleryResponse.class));
    }

    @Test
    public void testGetGalleryByIdFailedRequest() {
        Answer failedAnswer = new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] getGalleryByIdArguments = invocation.getArguments();
                Callback retrofitCallback = ((Callback)
                        getGalleryByIdArguments[getGalleryByIdArguments.length - 1]);
                retrofitCallback.onFailure(null, new Exception(ERROR_MESSAGE));
                return null;
            }
        };


        mockGalleryServiceForGalleryById(failedAnswer);
        target.getGalleryById(any(String.class), galleryResponseCallback);

        verify(galleryResponseCallback).onError(ERROR_MESSAGE);
        verify(galleryResponseCallback, never()).onSuccess(any(GalleryResponse.class));
    }

    @Test
    public void testGetListOfGalleriesSuccessfulRequest() {
        Answer successfulAnswer = new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] getListOfGalleriesArguments = invocation.getArguments();
                Callback retrofitCallback = ((Callback)
                        getListOfGalleriesArguments[getListOfGalleriesArguments.length - 1]);
                retrofitCallback.onResponse(null, Response.success(any(GalleryResponse
                        .class)));
                return null;
            }
        };

        mockGalleryServiceForListOfGalleries(successfulAnswer);
        target.getGalleries(any(GalleryListRequest.class), galleryResponseCallback);

        verify(galleryResponseCallback, never()).onError(any(String.class));
        verify(galleryResponseCallback).onSuccess(any(GalleryResponse.class));
    }

    @Test
    public void testGetListOfGalleriesFailedRequest() {
        Answer failedAnswer = new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] getListOfGalleriesArguments = invocation.getArguments();
                Callback retrofitCallback = ((Callback)
                        getListOfGalleriesArguments[getListOfGalleriesArguments.length -
                                1]);


                retrofitCallback.onFailure(null, new Exception(ERROR_MESSAGE));
                return null;
            }
        };
        mockGalleryServiceForListOfGalleries(failedAnswer);
        target.getGalleries(any(GalleryListRequest.class), galleryResponseCallback);

        verify(galleryResponseCallback).onError(ERROR_MESSAGE);
        verify(galleryResponseCallback, never()).onSuccess(any(GalleryResponse.class));
    }

    @Test
    public void testCreateGallerySuccessfulRequest() {
        Answer successfulAnswer = new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] getListOfGalleriesArguments = invocation.getArguments();
                Callback retrofitCallback = ((Callback)
                        getListOfGalleriesArguments[getListOfGalleriesArguments.length - 1]);
                retrofitCallback.onResponse(null, Response.success(any(GalleryResponse
                        .class)));
                return null;
            }
        };

        mockGalleryServiceForCreateGallery(successfulAnswer);
        target.createGallery(any(CreateGalleryRequest.class), galleryResponseCallback);

        verify(galleryResponseCallback, never()).onError(any(String.class));
        verify(galleryResponseCallback).onSuccess(any(GalleryResponse.class));
    }

    @Test
    public void testCreatefGalleryFailedRequest() {
        Answer failedAnswer = new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] getListOfGalleriesArguments = invocation.getArguments();
                Callback retrofitCallback = ((Callback)
                        getListOfGalleriesArguments[getListOfGalleriesArguments.length -
                                1]);


                retrofitCallback.onFailure(null, new Exception(ERROR_MESSAGE));
                return null;
            }
        };
        mockGalleryServiceForCreateGallery(failedAnswer);
        target.createGallery(any(CreateGalleryRequest.class), galleryResponseCallback);

        verify(galleryResponseCallback).onError(ERROR_MESSAGE);
        verify(galleryResponseCallback, never()).onSuccess(any(GalleryResponse.class));
    }


    private void mockGalleryServiceForGalleryById(Answer answer) {
        doAnswer(answer).when(call).enqueue(any(Callback.class));

        doReturn(call).when(mockedGalleryService).getGalleryById(any(String.class));
    }

    private void mockGalleryServiceForListOfGalleries(Answer answer) {
        doAnswer(answer).when(call).enqueue(any(Callback.class));

        doReturn(call).when(mockedGalleryService).userGallery(any(GalleryListRequest
                .class));
    }

    private void mockGalleryServiceForCreateGallery(Answer answer) {
        doAnswer(answer).when(call).enqueue(any(Callback.class));

        doReturn(call).when(mockedGalleryService).createGallery(any(CreateGalleryRequest.class));
    }

}
