package com.creatubbles.api.repository;

import com.creatubbles.api.ContentType;
import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.creation.Creation;
import com.creatubbles.api.model.creation.ToybooDetails;
import com.creatubbles.api.model.image_manipulation.ImageManipulation;
import com.creatubbles.api.model.upload.Upload;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.CreationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;

import java.util.List;

import retrofit2.Call;

import static com.creatubbles.api.repository.RepositoryTestUtil.getFailedAnswer;
import static com.creatubbles.api.repository.RepositoryTestUtil.getSuccessfulAnswer;
import static com.creatubbles.api.repository.RepositoryTestUtil.verifyFailedResponseOn;
import static com.creatubbles.api.repository.RepositoryTestUtil.verifySuccessfulResponseOn;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class CreationRepositoryTest {

    private static final String ERROR_MESSAGE = "What an error!";
    private CreationRepository target;

    @Mock
    ResponseCallback<CreatubblesResponse<List<Creation>>> creationListResponseCallback;

    @Mock
    ResponseCallback<CreatubblesResponse<Creation>> creationResponseCallback;

    @Mock
    ResponseCallback<CreatubblesResponse<ToybooDetails>> toybooResponseCallback;

    @Mock
    ResponseCallback<Void> voidCallback;

    @Mock
    ResponseCallback<CreatubblesResponse<Upload>> uploadResponseCallback;

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
        target = new CreationRepositoryImpl(new ObjectMapper(), mockedCreationService);
    }

    @Test
    public void testGetRecentSuccessfulRequest() {
        mockGetRecentWithAnswer(getSuccessfulAnswer(mockBody));

        target.getRecent(null, Boolean.FALSE, creationListResponseCallback);

        verifySuccessfulResponseOn(creationListResponseCallback);
    }

    @Test
    public void testGetRecentFailedRequest() {
        mockGetRecentWithAnswer(getFailedAnswer(ERROR_MESSAGE));

        target.getRecent(null, Boolean.FALSE, creationListResponseCallback);

        verifyFailedResponseOn(creationListResponseCallback, ERROR_MESSAGE);
    }

    @Test
    public void testGetByNameSuccessfulRequest() {
        mockSearchByNameWithAnswer(getSuccessfulAnswer(mockBody));

        target.getByName(null, "", Boolean.FALSE, creationListResponseCallback);

        verifySuccessfulResponseOn(creationListResponseCallback);
    }

    @Test
    public void testGetByNameFailedRequest() {
        mockSearchByNameWithAnswer(getFailedAnswer(ERROR_MESSAGE));

        target.getByName(null, "", Boolean.FALSE, creationListResponseCallback);

        verifyFailedResponseOn(creationListResponseCallback, ERROR_MESSAGE);
    }

    @Test
    public void testGetFromGallerySuccessfulRequest() {
        mockGetFromGalleryWithAnswer(getSuccessfulAnswer(mockBody));

        target.getFromGallery(null, "", Boolean.FALSE, creationListResponseCallback);

        verifySuccessfulResponseOn(creationListResponseCallback);
    }

    @Test
    public void testGetFromGalleryFailedRequest() {
        mockGetFromGalleryWithAnswer(getFailedAnswer(ERROR_MESSAGE));

        target.getFromGallery(null, "", Boolean.FALSE, creationListResponseCallback);

        verifyFailedResponseOn(creationListResponseCallback, ERROR_MESSAGE);
    }

    @Test
    public void testGetByUserSuccessfulRequest() {
        mockGetByUserWithAnswer(getSuccessfulAnswer(mockBody));

        target.getByUser(null, "", Boolean.FALSE, creationListResponseCallback);

        verifySuccessfulResponseOn(creationListResponseCallback);
    }

    @Test
    public void testGetByUserFailedRequest() {
        mockGetByUserWithAnswer(getFailedAnswer(ERROR_MESSAGE));

        target.getByUser(null, "", Boolean.FALSE, creationListResponseCallback);

        verifyFailedResponseOn(creationListResponseCallback, ERROR_MESSAGE);
    }

    @Test
    public void testGetRecommendedByUserSuccessfulRequest() {
        mockGetRecommendedByUserWithAnswer(getSuccessfulAnswer(mockBody));

        target.getRecommendedByUser(null, "", Boolean.FALSE, creationListResponseCallback);

        verifySuccessfulResponseOn(creationListResponseCallback);
    }

    @Test
    public void testGetRecommendedByUserFailedRequest() {
        mockGetRecommendedByUserWithAnswer(getFailedAnswer(ERROR_MESSAGE));

        target.getRecommendedByUser(null, "", Boolean.FALSE, creationListResponseCallback);

        verifyFailedResponseOn(creationListResponseCallback, ERROR_MESSAGE);
    }

    @Test
    public void testGetRecommendedByCreationSuccessfulRequest() {
        mockGetRecommendedByCreationWithAnswer(getSuccessfulAnswer(mockBody));

        target.getRecommendedByCreation(null, "", Boolean.FALSE, creationListResponseCallback);

        verifySuccessfulResponseOn(creationListResponseCallback);
    }

    @Test
    public void testGetRecommendedByCreationFailedRequest() {
        mockGetRecommendedByCreationWithAnswer(getFailedAnswer(ERROR_MESSAGE));

        target.getRecommendedByCreation(null, "", Boolean.FALSE, creationListResponseCallback);

        verifyFailedResponseOn(creationListResponseCallback, ERROR_MESSAGE);
    }

    @Test
    public void testGetCreationByIdSuccessfulRequest() {
        mockGetByIdWithAnswer(getSuccessfulAnswer(mockBody));

        target.getById(anyString(), creationResponseCallback);

        verifySuccessfulResponseOn(creationResponseCallback);
    }

    @Test
    public void testGetCreationByIdFailedRequest() {
        mockGetByIdWithAnswer(getFailedAnswer(ERROR_MESSAGE));

        target.getById(anyString(), creationResponseCallback);

        verifyFailedResponseOn(creationResponseCallback, ERROR_MESSAGE);
    }

    @Test
    public void testUpdateCreationSuccessfulRequest() {
        mockUpdateCreationWithAnswer(getSuccessfulAnswer(null));

        target.update("", mock(Creation.class), voidCallback);

        verifySuccessfulResponseOn(voidCallback);
    }

    @Test
    public void testUpdateCreationFailedRequest() {
        mockUpdateCreationWithAnswer(getFailedAnswer(ERROR_MESSAGE));

        target.update("", mock(Creation.class), voidCallback);

        verifyFailedResponseOn(voidCallback, ERROR_MESSAGE);
    }

    @Test
    public void testCreateCreationSuccessfulRequest() {
        mockCreateCreationWithAnswer(getSuccessfulAnswer(mockBody));

        target.create(mock(Creation.class), creationResponseCallback);

        verifySuccessfulResponseOn(creationResponseCallback);
    }

    @Test
    public void testCreateCreationFailedRequest() {
        mockCreateCreationWithAnswer(getFailedAnswer(ERROR_MESSAGE));

        target.create(mock(Creation.class), creationResponseCallback);

        verifyFailedResponseOn(creationResponseCallback, ERROR_MESSAGE);
    }

    @Test
    public void testRemoveCreationSuccessfulRequest() {
        mockRemoveCreationWithAnswer(getSuccessfulAnswer(mockBody));

        target.remove("", voidCallback);

        verifySuccessfulResponseOn(voidCallback);
    }

    @Test
    public void testRemoveCreationFailedRequest() {
        mockRemoveCreationWithAnswer(getFailedAnswer(ERROR_MESSAGE));

        target.remove("", voidCallback);

        verifyFailedResponseOn(voidCallback, ERROR_MESSAGE);
    }

    @Test
    public void testStartUploadSuccessfulRequest() {
        mockCreateUploadWithAnswer(getSuccessfulAnswer(mockBody));

        target.startUpload("", ContentType.JPEG, uploadResponseCallback);

        verifySuccessfulResponseOn(uploadResponseCallback);
    }

    @Test
    public void testStartUploadFailedRequest() {
        mockCreateUploadWithAnswer(getFailedAnswer(ERROR_MESSAGE));

        target.startUpload("", ContentType.JPEG, uploadResponseCallback);

        verifyFailedResponseOn(uploadResponseCallback, ERROR_MESSAGE);
    }

    @Test
    public void testFinishUploadSuccessfulRequest() {
        mockUpdateUploadWithAnswer(getSuccessfulAnswer(mockBody));

        target.finishUpload(mock(Upload.class), null, voidCallback);

        verifySuccessfulResponseOn(voidCallback);
    }

    @Test
    public void testFinishUploadFailedRequest() {
        mockUpdateUploadWithAnswer(getFailedAnswer(ERROR_MESSAGE));

        target.finishUpload(mock(Upload.class), null, voidCallback);

        verifyFailedResponseOn(voidCallback, ERROR_MESSAGE);
    }

    @Test
    public void testGetToybooDetailsSuccessfulRequest() {
        mockGetToybooDetailsWithAnswer(getSuccessfulAnswer(mockBody));

        target.getToybooDetails(anyString(), toybooResponseCallback);

        verifySuccessfulResponseOn(toybooResponseCallback);
    }

    @Test
    public void testGetToybooDetailsFailedRequest() {
        mockGetToybooDetailsWithAnswer(getFailedAnswer(ERROR_MESSAGE));

        target.getToybooDetails(anyString(),toybooResponseCallback);

        verifyFailedResponseOn(toybooResponseCallback, ERROR_MESSAGE);
    }

    @Test
    public void shouldCallPutImageManipulationWhenUpdatingImage() throws Exception {
        when(mockedCreationService.putImageManipulation(any(), any())).thenReturn(voidCall);

        target.updateImage("", mock(ImageManipulation.class), voidCallback);

        verify(mockedCreationService).putImageManipulation(any(), any());
        verify(voidCall).enqueue(any());
    }

    private void mockGetRecentWithAnswer(Answer successfulAnswer) {
        doAnswer(successfulAnswer).when(call).enqueue(any());
        doReturn(call).when(mockedCreationService).getRecent(any(), any());
    }

    private void mockGetByIdWithAnswer(Answer answer) {
        doAnswer(answer).when(call).enqueue(any());

        doReturn(call).when(mockedCreationService).getCreation(anyString());
    }

    private void mockUpdateCreationWithAnswer(Answer answer) {
        doAnswer(answer).when(voidCall).enqueue(any());
        doReturn(voidCall).when(mockedCreationService).updateCreation(anyString(), any());
    }

    private void mockSearchByNameWithAnswer(Answer answer) {
        doAnswer(answer).when(call).enqueue(any());
        doReturn(call).when(mockedCreationService).searchByName(any(), anyString(), any());
    }

    private void mockCreateCreationWithAnswer(Answer answer) {
        doAnswer(answer).when(call).enqueue(any());

        doReturn(call).when(mockedCreationService).createCreation(any());
    }

    private void mockCreateUploadWithAnswer(Answer answer) {
        doAnswer(answer).when(uploadCall).enqueue(any());

        doReturn(uploadCall).when(mockedCreationService).createUpload(anyString(), any());
    }

    private void mockUpdateUploadWithAnswer(Answer answer) {
        doAnswer(answer).when(uploadCall).enqueue(any());
        doReturn(uploadCall).when(mockedCreationService).updateCreationUpload(anyString(), anyString());
    }

    private void mockGetFromGalleryWithAnswer(Answer answer) {
        doAnswer(answer).when(call).enqueue(any());
        doReturn(call).when(mockedCreationService).getFromGallery(any(), anyString(), any());
    }

    private void mockGetByUserWithAnswer(Answer answer) {
        doAnswer(answer).when(call).enqueue(any());
        doReturn(call).when(mockedCreationService).getByUser(any(), anyString(), any());
    }

    private void mockGetRecommendedByUserWithAnswer(Answer answer) {
        doAnswer(answer).when(call).enqueue(any());
        doReturn(call).when(mockedCreationService).getRecommendedByUser(any(), anyString(), any());
    }

    private void mockGetRecommendedByCreationWithAnswer(Answer answer) {
        doAnswer(answer).when(call).enqueue(any());
        doReturn(call).when(mockedCreationService).getRecommendedByCreation(any(), anyString(), any());
    }

    private void mockRemoveCreationWithAnswer(Answer answer) {
        doAnswer(answer).when(call).enqueue(any());
        doReturn(call).when(mockedCreationService).removeCreation(anyString());
    }

    private void mockGetToybooDetailsWithAnswer(Answer answer) {
        doAnswer(answer).when(call).enqueue(any());
        doReturn(call).when(mockedCreationService).getToybooDetails(anyString());
    }
}