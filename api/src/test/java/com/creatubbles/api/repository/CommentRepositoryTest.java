package com.creatubbles.api.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.model.comment.Comment;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.CommentService;
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
public class CommentRepositoryTest {

    private CommentRepository repository;
    @Mock
    CommentService service;
    @Mock
    Call<JSONAPIDocument<List<Comment>>> listCall;
    @Mock
    Call<JSONAPIDocument<Comment>> singleItemCall;
    @Mock
    Call<Void> voidCall;

    @Before
    public void setUp() throws Exception {
        ObjectMapper mapper = mock(ObjectMapper.class);
        repository = new CommentRepositoryImpl(service, mapper);
    }

    @Test
    public void shouldCallGetForCreationComments() throws Exception {
        when(service.getForCreation(any(), any())).thenReturn(listCall);

        repository.getForCreation(anyPage(), anyId(), anyCallback());

        verify(service).getForCreation(any(), any());
    }

    @Test
    public void shouldCallGetForGalleryComments() throws Exception {
        when(service.getForGallery(any(), any())).thenReturn(listCall);

        repository.getForGallery(anyPage(), anyId(), anyCallback());

        verify(service).getForGallery(any(), any());
    }

    @Test
    public void shouldCallGetForUserComments() throws Exception {
        when(service.getForUser(any(), any())).thenReturn(listCall);

        repository.getForUser(anyPage(), anyId(), anyCallback());

        verify(service).getForUser(any(), any());
    }

    @Test
    public void shouldCallCreateCommentForCreation() throws Exception {
        when(service.createForCreation(any(), any())).thenReturn(singleItemCall);

        repository.createForCreation(anyComment(), anyId(), anyCallback());

        verify(service).createForCreation(any(), any());
    }

    @Test
    public void shouldCallCreateCommentForGallery() throws Exception {
        when(service.createForGallery(any(), any())).thenReturn(singleItemCall);

        repository.createForGallery(anyComment(), anyId(), anyCallback());

        verify(service).createForGallery(any(), any());
    }

    @Test
    public void shouldCallCreateCommentForUser() throws Exception {
        when(service.createForUser(any(), any())).thenReturn(singleItemCall);

        repository.createForUser(anyComment(), anyId(), anyCallback());

        verify(service).createForUser(any(), any());
    }

    @Test
    public void shouldCallApproveWhenApproving() throws Exception {
        when(service.approve(any())).thenReturn(voidCall);

        repository.approve(anyId(), anyCallback());

        verify(service).approve(any());
    }

    @Test
    public void shouldCallDeclineWhenDeclining() throws Exception {
        when(service.decline(any())).thenReturn(voidCall);

        repository.decline(anyId(), anyCallback());

        verify(service).decline(any());
    }

    private Comment anyComment() {
        return mock(Comment.class);
    }

    @NonNull
    private String anyId() {
        return "";
    }

    @Nullable
    private Integer anyPage() {
        return null;
    }

    @Nullable
    private <T> ResponseCallback<T> anyCallback() {
        return null;
    }
}