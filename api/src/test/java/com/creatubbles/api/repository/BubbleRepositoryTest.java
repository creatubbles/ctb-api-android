package com.creatubbles.api.repository;

import com.creatubbles.api.model.bubble.Bubble;
import com.creatubbles.api.model.bubble.BubbleColor;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.BubbleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import retrofit2.Call;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Pawel Szymanski
 */
@RunWith(MockitoJUnitRunner.class)
public class BubbleRepositoryTest {

    private BubbleRepository repository;

    @Mock
    BubbleService service;
    @Mock
    Call<JSONAPIDocument<List<Bubble>>> listCall;
    @Mock
    Call<JSONAPIDocument<Bubble>> singleCall;
    @Mock
    Call<Void> voidCall;
    @Mock
    Call<JSONAPIDocument<List<BubbleColor>>> colorsCall;

    @Before
    public void setUp() throws Exception {
        ObjectMapper objectMapper = mock(ObjectMapper.class);
        repository = new BubbleRepositoryImpl(service, objectMapper);
    }

    @Test
    public void shouldCallGetForCreationWhenGettingForCreation() throws Exception {
        when(service.getForCreation(any(), any())).thenReturn(listCall);

        repository.getForCreation(anyPage(), anyId(), anyCallback());

        verify(service).getForCreation(any(), any());
        verify(listCall).enqueue(any());
    }

    private Integer anyPage() {
        return null;
    }

    @Test
    public void shouldCallGetForGalleryWhenGettingForGallery() throws Exception {
        when(service.getForGallery(any(), any())).thenReturn(listCall);

        repository.getForGallery(anyPage(), anyId(), anyCallback());

        verify(service).getForGallery(any(), any());
        verify(listCall).enqueue(any());
    }

    @Test
    public void shouldCallGetForUserWhenGettingForUser() throws Exception {
        when(service.getForUser(any(), any())).thenReturn(listCall);

        repository.getForUser(anyPage(), anyId(), anyCallback());

        verify(service).getForUser(any(), any());
        verify(listCall).enqueue(any());
    }

    @Test
    public void shouldCallPostForCreationWhenCreatingForCreation() throws Exception {
        when(service.postForCreation(any(), any())).thenReturn(singleCall);

        repository.createForCreation(anyId(), anyBubble(), anyCallback());

        verify(service).postForCreation(any(), any());
        verify(singleCall).enqueue(any());
    }

    @Test
    public void shouldCallPostForGalleryWhenCreatingForGallery() throws Exception {
        when(service.postForGallery(any(), any())).thenReturn(singleCall);

        repository.createForGallery(anyId(), anyBubble(), anyCallback());

        verify(service).postForGallery(any(), any());
        verify(singleCall).enqueue(any());
    }

    @Test
    public void shouldCallPostForUserWhenCreatingForUser() throws Exception {
        when(service.postForUser(any(), any())).thenReturn(singleCall);

        repository.createForUser(anyId(), anyBubble(), anyCallback());

        verify(service).postForUser(any(), any());
        verify(singleCall).enqueue(any());
    }

    @Test
    public void shouldCallPutWhenUpdating() throws Exception {
        when(service.putBubble(any(), any())).thenReturn(voidCall);

        repository.update(anyId(), anyBubble(), anyCallback());

        verify(service).putBubble(any(), any());
        verify(voidCall).enqueue(any());
    }

    @Test
    public void shouldCallDeleteWhenDeleting() throws Exception {
        when(service.deleteBubble(any())).thenReturn(voidCall);

        repository.delete(anyId(), anyCallback());

        verify(service).deleteBubble(any());
        verify(voidCall).enqueue(any());
    }

    @Test
    public void shouldCallGetColorsWhenRetrievingColors() throws Exception {
        when(service.getColors()).thenReturn(colorsCall);

        repository.getColors(anyCallback());

        verify(service).getColors();
        verify(colorsCall).enqueue(any());
    }

    private Bubble anyBubble() {
        return mock(Bubble.class);
    }

    private <T> ResponseCallback<T> anyCallback() {
        return null;
    }

    private String anyId() {
        return "ID";
    }
}