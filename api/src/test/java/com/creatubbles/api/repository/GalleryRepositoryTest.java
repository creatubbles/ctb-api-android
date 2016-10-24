package com.creatubbles.api.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.model.gallery.Gallery;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.GalleryService;
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
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GalleryRepositoryTest {

    private GalleryRepository target;

    @Mock
    GalleryService galleryService;

    @Mock
    Call<JSONAPIDocument<Gallery>> singleCall;
    @Mock
    Call<JSONAPIDocument<List<Gallery>>> listCall;
    @Mock
    Call<Void> voidCall;

    @Before
    public void setUp() {
        ObjectMapper mapper = mock(ObjectMapper.class);
        target = new GalleryRepositoryImpl(mapper, galleryService);
    }

    @Test
    public void shouldCallGetPublic() throws Exception {
        when(galleryService.getPublic(any(), anyString())).thenReturn(listCall);

        target.getPublic(anyPage(), null, anyCallback());

        verify(galleryService).getPublic(any(), anyString());
    }

    @Test
    public void shouldCallGetFavorite() throws Exception {
        when(galleryService.getFavorite(any())).thenReturn(listCall);

        target.getFavorite(anyPage(), anyCallback());

        verify(galleryService).getFavorite(any());
    }

    @Test
    public void shouldCallGetFeatured() throws Exception {
        when(galleryService.getFeatured(any())).thenReturn(listCall);

        target.getFeatured(anyPage(), anyCallback());

        verify(galleryService).getFeatured(any());
    }

    @Test
    public void shouldCallGetByUserWithCurrentUserValue() throws Exception {
        when(galleryService.getByUser(any(), any(), any())).thenReturn(listCall);

        target.getMine(anyPage(), null, anyCallback());

        verify(galleryService).getByUser(eq(UserRepository.CURRENT_USER), any(), any());
    }

    @Test
    public void shouldCallGetByUserWithId() throws Exception {
        when(galleryService.getByUser(any(), any(), any())).thenReturn(listCall);

        target.getByUser(anyPage(), anyId(), anyCallback());

        verify(galleryService).getByUser(eq(anyId()), any(), any());
    }

    @Test
    public void shouldCallGetById() {
        when(galleryService.getById(anyString())).thenReturn(singleCall);

        target.getById(anyPage(), anyString(), anyCallback());

        verify(galleryService).getById(anyString());
    }

    @Test
    public void shouldCallGetByCreation() throws Exception {
        when(galleryService.getByCreation(any(), any())).thenReturn(listCall);

        target.getByCreation(anyPage(), anyId(), anyCallback());

        verify(galleryService).getByCreation(eq(anyId()), any());
    }

    @Test
    public void shouldCallCreate() throws Exception {
        when(galleryService.create(any())).thenReturn(singleCall);
        Gallery gallery = anyGallery();

        target.create(gallery, anyCallback());

        verify(galleryService).create(gallery);
    }

    @Test
    public void shouldCallUpdate() throws Exception {
        when(galleryService.update(any(), any())).thenReturn(voidCall);
        Gallery gallery = anyGallery();

        target.update(anyId(), gallery, anyCallback());

        verify(galleryService).update(anyId(), gallery);
    }

    private Gallery anyGallery() {
        return mock(Gallery.class);
    }

    @NonNull
    private String anyId() {
        return "ID";
    }

    @Nullable
    private Integer anyPage() {
        return 0;
    }

    @Nullable
    private <T> ResponseCallback<T> anyCallback() {
        return null;
    }
}
