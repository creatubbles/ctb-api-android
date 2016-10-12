package com.creatubbles.api.repository;

import com.creatubbles.api.model.CtbResponse;
import com.creatubbles.api.model.gallery.Gallery;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.GalleryService;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class GalleryRepositoryTest {

    private static final String ERROR_MESSAGE = "What an error!";
    private GalleryRepository target;

    @Mock
    ResponseCallback<CtbResponse<Gallery>> galleryResponseCallback;

    @Mock
    ResponseCallback<CtbResponse<List<Gallery>>> galleriesResponseCallback;

    @Mock
    GalleryService mockedGalleryService;

    @Mock
    Call<JSONAPIDocument<?>> call;

    @Mock
    JSONAPIDocument<?> body;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        target = new GalleryRepositoryImpl(new ObjectMapper(), mockedGalleryService);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testGetGalleryByIdSuccessfulRequest() {
        Answer successfulAnswer = invocation -> {
            Object[] getGalleryByIdArguments = invocation.getArguments();
            Callback<JSONAPIDocument<?>> retrofitCallback = ((Callback<JSONAPIDocument<?>>)
                    getGalleryByIdArguments[getGalleryByIdArguments.length - 1]);

            retrofitCallback.onResponse(null, Response.success(body));
            return null;
        };

        mockGalleryServiceForGalleryById(successfulAnswer);
        target.getGalleryById(any(String.class), galleryResponseCallback);

        verify(galleryResponseCallback, never()).onError(any(String.class));
        verify(galleryResponseCallback).onSuccess(any(CtbResponse.class));
    }

    @Test
    public void testGetGalleryByIdFailedRequest() {
        Answer failedAnswer = invocation -> {
            Object[] getGalleryByIdArguments = invocation.getArguments();
            Callback<?> retrofitCallback = ((Callback)
                    getGalleryByIdArguments[getGalleryByIdArguments.length - 1]);
            retrofitCallback.onFailure(null, new Exception(ERROR_MESSAGE));
            return null;
        };


        mockGalleryServiceForGalleryById(failedAnswer);
        target.getGalleryById(any(String.class), galleryResponseCallback);

        verify(galleryResponseCallback).onError(ERROR_MESSAGE);
        verify(galleryResponseCallback, never()).onSuccess(any());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testGetListOfGalleriesByUserSuccessfulRequest() {
        Answer successfulAnswer = invocation -> {
            Object[] getListOfGalleriesArguments = invocation.getArguments();
            Callback<JSONAPIDocument<?>> retrofitCallback = ((Callback<JSONAPIDocument<?>>)
                    getListOfGalleriesArguments[getListOfGalleriesArguments.length - 1]);
            retrofitCallback.onResponse(null, Response.success(body));
            return null;
        };

        mockGalleryServiceForListOfGalleriesByUser(successfulAnswer);
        target.getGalleriesByUser(any(String.class), galleriesResponseCallback);

        verify(galleriesResponseCallback, never()).onError(any(String.class));
        verify(galleriesResponseCallback).onSuccess(any());
    }

    @Test
    public void testGetListOfGalleriesByUserFailedRequest() {
        Answer failedAnswer = invocation -> {
            Object[] getListOfGalleriesArguments = invocation.getArguments();
            Callback<?> retrofitCallback = ((Callback)
                    getListOfGalleriesArguments[getListOfGalleriesArguments.length -
                            1]);


            retrofitCallback.onFailure(null, new Exception(ERROR_MESSAGE));
            return null;
        };
        mockGalleryServiceForListOfGalleriesByUser(failedAnswer);
        target.getGalleriesByUser(any(String.class), galleriesResponseCallback);

        verify(galleriesResponseCallback).onError(ERROR_MESSAGE);
        verify(galleriesResponseCallback, never()).onSuccess(any());
    }

    @Test
    @SuppressWarnings("unchecked")

    public void testCreateGallerySuccessfulRequest() {
        Answer successfulAnswer = invocation -> {
            Object[] getListOfGalleriesArguments = invocation.getArguments();
            Callback<JSONAPIDocument<?>> retrofitCallback = ((Callback<JSONAPIDocument<?>>)
                    getListOfGalleriesArguments[getListOfGalleriesArguments.length - 1]);
            retrofitCallback.onResponse(null, Response.success(body));
            return null;
        };

        mockGalleryServiceForCreateGallery(successfulAnswer);
        target.createGallery(any(Gallery.class), galleryResponseCallback);

        verify(galleryResponseCallback, never()).onError(any(String.class));
        verify(galleryResponseCallback).onSuccess(any());
    }

    @Test
    public void testCreatefGalleryFailedRequest() {
        Answer failedAnswer = invocation -> {
            Object[] getListOfGalleriesArguments = invocation.getArguments();
            Callback<?> retrofitCallback = ((Callback)
                    getListOfGalleriesArguments[getListOfGalleriesArguments.length -
                            1]);


            retrofitCallback.onFailure(null, new Exception(ERROR_MESSAGE));
            return null;
        };
        mockGalleryServiceForCreateGallery(failedAnswer);
        target.createGallery(any(Gallery.class), galleryResponseCallback);

        verify(galleryResponseCallback).onError(ERROR_MESSAGE);
        verify(galleryResponseCallback, never()).onSuccess(any());
    }


    private void mockGalleryServiceForGalleryById(Answer answer) {
        doAnswer(answer).when(call).enqueue(any());

        doReturn(call).when(mockedGalleryService).getGalleryById(any(String.class));
    }

    private void mockGalleryServiceForListOfGalleriesByUser(Answer answer) {
        doAnswer(answer).when(call).enqueue(any());

        doReturn(call).when(mockedGalleryService).getGalleriesByUser(any(String.class));
    }

    private void mockGalleryServiceForCreateGallery(Answer answer) {
        doAnswer(answer).when(call).enqueue(any());

        doReturn(call).when(mockedGalleryService).createGallery(any(Gallery.class));
    }

}
