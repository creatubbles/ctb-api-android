package com.creatubbles.api.repository;

import com.creatubbles.api.exception.ErrorResponse;
import com.creatubbles.api.model.CtbResponse;
import com.creatubbles.api.model.user.NewUser;
import com.creatubbles.api.model.user.User;
import com.creatubbles.api.request.ISO_3166_CountryCode;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;


public class UserRepositoryTest {

    private static final String ERROR_MESSAGE = "What an error!";
    private UserRepository target;

    @Mock
    ResponseCallback<CtbResponse<List<User>>> userListResponseResponseCallback;

    @Mock
    ResponseCallback<CtbResponse<User>> userResponseCallback;

    @Mock
    UserService mockedUserService;

    @Mock
    Call<User> userCall;

    @Mock
    Call<List<User>> listCall;

    @Mock
    ErrorResponse errorResponse;

    @Mock
    NewUser newUser;

    @Mock
    JSONAPIDocument<?> body;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        target = new UserRepositoryImpl(new ObjectMapper(), mockedUserService);
    }


    @SuppressWarnings("unchecked")
    @Test
    public void testUserByIdSuccessfulRequest() {

        Answer successfulAnswer = invocation -> {
            Object[] getUserByIdArguments = invocation.getArguments();
            Callback<JSONAPIDocument<?>> retrofitCallback = (Callback<JSONAPIDocument<?>>) getUserByIdArguments[getUserByIdArguments
                    .length - 1];
            retrofitCallback.onResponse(null, Response.success(body));
            return null;
        };
        mockUserServiceAnswerForUserById(successfulAnswer);
        target.getUserById(any(String.class), userResponseCallback);
        verify(userResponseCallback, never()).onError(any(String.class));
        verify(userResponseCallback).onSuccess(any());
    }

    @Test
    public void testUserByIdFailedRequest() {
        Answer failedAnswer = invocation -> {
            Object[] getUserByIdArguments = invocation.getArguments();
            Callback<?> retrofitCallback = ((Callback) getUserByIdArguments[getUserByIdArguments
                    .length - 1]);
            retrofitCallback.onFailure(null, new Exception(ERROR_MESSAGE));
            return null;
        };
        mockUserServiceAnswerForUserById(failedAnswer);
        target.getUserById(any(String.class), userResponseCallback);
        verify(userResponseCallback).onError(ERROR_MESSAGE);
        verify(userResponseCallback, never()).onSuccess(any());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testUserSuccessfulRequest() {
        Answer successfulAnswer = invocation -> {
            Object[] getUserArguments = invocation.getArguments();
            Callback<JSONAPIDocument<?>> retrofitCallback = ((Callback<JSONAPIDocument<?>>) getUserArguments[getUserArguments
                    .length - 1]);
            retrofitCallback.onResponse(null, Response.success(body));
            return null;
        };
        mockUserServiceAnswerForUser(successfulAnswer);
        target.getUser(userResponseCallback);
        verify(userResponseCallback, never()).onError(any(String.class));
        verify(userResponseCallback).onSuccess(any());
    }

    @Test
    public void testUserFailedRequest() {
        Answer failedAnswer = invocation -> {
            Object[] getUserArguments = invocation.getArguments();
            Callback<?> retrofitCallback = ((Callback) getUserArguments[getUserArguments
                    .length - 1]);
            retrofitCallback.onFailure(null, new Exception(ERROR_MESSAGE));
            return null;
        };
        mockUserServiceAnswerForUser(failedAnswer);
        target.getUser(userResponseCallback);
        verify(userResponseCallback).onError(ERROR_MESSAGE);
        verify(userResponseCallback, never()).onSuccess(any());
    }

    private void mockUserServiceAnswerForUserById(Answer answer) {
        doAnswer(answer).when(userCall).enqueue(any());

        doReturn(userCall).when(mockedUserService).getUserById(any(String.class));
    }

    private void mockUserServiceAnswerForUser(Answer answer) {
        doAnswer(answer).when(userCall).enqueue(any());

        doReturn(userCall).when(mockedUserService).getUser();
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testUsersListSuccessfulRequest() {
        Answer successfulAnswer = new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocation) {
                Object[] getUsersListAguments = invocation.getArguments();
                Callback<JSONAPIDocument<?>> retrofitCallback = ((Callback<JSONAPIDocument<?>>) getUsersListAguments[getUsersListAguments
                        .length - 1]);
                retrofitCallback.onResponse(null, Response.success(body));
                return null;
            }
        };
        mockUserServiceAnswerForUsersList(successfulAnswer);

        target.getUsersList(userListResponseResponseCallback);

        verify(userListResponseResponseCallback, never()).onError(any(String.class));
        verify(userListResponseResponseCallback).onSuccess(any());

    }

    @Test
    @SuppressWarnings("unchecked")
    public void testUsersListFailedRequest() {
        Answer failedAnswer = new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocation) {
                Object[] getUsersListArguments = invocation.getArguments();
                Callback retrofitCallback = ((Callback)
                        getUsersListArguments[getUsersListArguments.length - 1]);
                retrofitCallback.onFailure(null, new Exception
                        (ERROR_MESSAGE));
                return null;
            }
        };
        mockUserServiceAnswerForUsersList(failedAnswer);
        target.getUsersList(userListResponseResponseCallback);
        verify(userListResponseResponseCallback).onError(ERROR_MESSAGE);
        verify(userListResponseResponseCallback, never()).onSuccess(any());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testCreatUserSuccessful() {
        Answer successfulAnswer = new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocation) {
                Object[] getUsersListArguments = invocation.getArguments();
                Callback<JSONAPIDocument<?>> retrofitCallback = ((Callback<JSONAPIDocument<?>>)
                        getUsersListArguments[getUsersListArguments.length - 1]);
                retrofitCallback.onResponse(null, Response.success(body));
                return null;
            }
        };
        mockUserServiceAnswerForCreateUser(successfulAnswer);
        target.createUser(newUser, userResponseCallback);
        verify(userResponseCallback, never()).onError(anyString());
        verify(userResponseCallback).onSuccess(any());
    }

    @Test
    public void testCreatUserFailed() {
        Answer failedAnswer = new Answer<Void>() {

            @Override
            public Void answer(InvocationOnMock invocation) {
                Object[] getUsersListArguments = invocation.getArguments();
                Callback<?> retrofitCallback = ((Callback)
                        getUsersListArguments[getUsersListArguments.length - 1]);
                retrofitCallback.onFailure(null, new Exception
                        (ERROR_MESSAGE));
                return null;
            }
        };
        mockUserServiceAnswerForCreateUser(failedAnswer);
        target.createUser(newUser, userResponseCallback);
        verify(userResponseCallback).onError(ERROR_MESSAGE);
        verify(userResponseCallback, never()).onSuccess(any());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testPasswordAuthorizationCredentialsRequest() {
        mockCreatorRequest();
        Answer paramsValidator = new Answer<Call<User>>() {
            public Call<User> answer(InvocationOnMock invocation) {
                Object[] getArguments = invocation.getArguments();
                assertEquals(newUser.getName(), ((NewUser) getArguments[0]).getName
                        ());

                Answer successfulAnswer = new Answer<Void>() {
                    @Override
                    public Void answer(InvocationOnMock invocation) throws Throwable {
                        Object[] getAccessTokenArguments = invocation.getArguments();
                        Callback<JSONAPIDocument<?>> retrofitCallback = ((Callback<JSONAPIDocument<?>>)
                                getAccessTokenArguments[getAccessTokenArguments.length - 1]);

                        retrofitCallback.onResponse(null, Response.success(body));
                        return null;
                    }
                };
                doAnswer(successfulAnswer)
                        .when(userCall)
                        .enqueue(any());

                return userCall;
            }
        };

        doAnswer(paramsValidator)
                .when(mockedUserService)
                .createUser(any(NewUser.class));

        target.createUser(newUser, userResponseCallback);
        verify(userResponseCallback, never()).onError(anyString());
        verify(userResponseCallback, only()).onSuccess(any());
    }

    private void mockCreatorRequest() {
        doReturn("name").when(newUser).getName();
        doReturn("displayName").when(newUser).getDisplayName();
        doReturn(ISO_3166_CountryCode.POLAND.getCountryCodeA2()).when(newUser).getCountry();
        doReturn(2000).when(newUser).getBirthMonth();
        doReturn(1).when(newUser).getBirthYear();
    }

    private void mockUserServiceAnswerForCreateUser(Answer answer) {
        doAnswer(answer).when(listCall).enqueue(any());
        doReturn(listCall).when(mockedUserService).createUser(any(NewUser.class));
    }

    private void mockUserServiceAnswerForUsersList(Answer answer) {
        doAnswer(answer).when(listCall).enqueue(any());
        doReturn(listCall).when(mockedUserService).getUsers();
    }

}
