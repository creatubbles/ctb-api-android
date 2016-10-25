package com.creatubbles.api.repository;

import com.creatubbles.api.model.user.UserFollowing;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import retrofit2.Call;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Pawel Szymanski
 */
@RunWith(MockitoJUnitRunner.class)
public class UserFollowingRepositoryTest {

    @Mock
    UserService userService;
    @Mock
    Call<JSONAPIDocument<UserFollowing>> call;
    @Mock
    Call<Void> voidCall;

    private UserFollowingRepository repository;

    @Before
    public void setUp() throws Exception {
        ObjectMapper objectMapper = mock(ObjectMapper.class);
        repository = new UserFollowingRepositoryImpl(userService, objectMapper);
    }

    @Test
    public void shouldCallPostFollowingWhenFollow() throws Exception {
        when(userService.postFollowing(any())).thenReturn(call);

        repository.follow(anyId(), anyCallback());

        verify(userService).postFollowing(anyId());
    }

    @Test
    public void shouldCallDeleteFollowingWhenUnfollow() throws Exception {
        when(userService.deleteFollowing(any())).thenReturn(voidCall);

        repository.unfollow(anyId(), anyCallback());

        verify(userService).deleteFollowing(anyId());
    }

    private String anyId() {
        return "ID";
    }

    private <T> ResponseCallback<T> anyCallback() {
        return null;
    }

}