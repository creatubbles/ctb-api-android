package com.creatubbles.api.repository;

import android.support.annotation.NonNull;

import com.creatubbles.api.model.group.Group;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.GroupService;
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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Pawel Szymanski
 */
@RunWith(MockitoJUnitRunner.class)
public class GroupRepositoryTest {

    private GroupRepository repository;

    @Mock
    GroupService service;
    @Mock
    Call<JSONAPIDocument<List<Group>>> listCall;
    @Mock
    Call<JSONAPIDocument<Group>> singleCall;
    @Mock
    Call<Void> voidCall;


    @Before
    public void setUp() throws Exception {
        ObjectMapper objectMapper = mock(ObjectMapper.class);
        repository = new GroupRepositoryImpl(service, objectMapper);
    }

    @Test
    public void shouldCallGetGroupsWhenGettingAll() throws Exception {
        when(service.getGroups()).thenReturn(listCall);

        repository.getAll(anyCallback());

        verify(service).getGroups();
        verify(listCall).enqueue(any());
    }

    @Test
    public void shouldCallGetGroupWhenGettingById() throws Exception {
        when(service.getGroup(anyString())).thenReturn(singleCall);

        repository.getById(anyId(), anyCallback());

        verify(service).getGroup(anyString());
        verify(singleCall).enqueue(any());
    }

    @Test
    public void shouldCallPostGroupWhenCreatingGroup() throws Exception {
        when(service.postGroup(any())).thenReturn(singleCall);

        repository.create(anyGroup(), anyCallback());

        verify(service).postGroup(any());
        verify(singleCall).enqueue(any());
    }

    @Test
    public void shouldCallPutWhenUpdatingGroup() throws Exception {
        when(service.putGroup(any(), any())).thenReturn(voidCall);

        repository.update(anyId(), anyGroup(), anyCallback());

        verify(service).putGroup(any(), any());
        verify(voidCall).enqueue(any());
    }

    @Test
    public void shouldCallDeleteWhenRemovingGroup() throws Exception {
        when(service.deleteGroup(any())).thenReturn(voidCall);

        repository.delete(anyId(), anyCallback());

        verify(service).deleteGroup(any());
        verify(voidCall).enqueue(any());

    }

    private String anyId() {
        return "ID";
    }

    private <T> ResponseCallback<T> anyCallback() {
        return null;
    }

    @NonNull
    private Group anyGroup() {
        return mock(Group.class);
    }
}