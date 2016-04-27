package com.creatubbles.api.repository;

import com.creatubbles.api.exception.ErrorResponse;
import com.creatubbles.api.model.UserListResponse;
import com.creatubbles.api.model.user.User;
import com.creatubbles.api.request.CreatorRequest;
import com.creatubbles.api.request.Gender;
import com.creatubbles.api.request.ISO_3166_CountryCode;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.UserService;

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

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;


/**
 * Created by Janek on 18.02.2016.
 */
@RunWith(RobolectricTestRunner.class)
public class UserRepositoryTest {

    private static final String ERROR_MESSAGE = "What an error!";
    private UserRepository target;

    @Mock
    ResponseCallback<UserListResponse> userListResponseResponseCallback;

    @Mock
    ResponseCallback<User> userResponseCallback;

    @Mock
    UserService mockedUserService;

    @Mock
    Call<User> userCall;

    @Mock
    Call<UserListResponse> listCall;

    @Mock
    ErrorResponse errorResponse;

    @Mock
    CreatorRequest creatorRequest;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        target = new UserRepositoryImpl(mockedUserService);
    }


    @Test
    public void testUserByIdSuccessfulRequest() {

        Answer successfulAnswer = new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] getUserByIdArguments = invocation.getArguments();
                Callback retrofitCallback = ((Callback) getUserByIdArguments[getUserByIdArguments
                        .length - 1]);
                retrofitCallback.onResponse(null, Response.success(any(User.class)));
                return null;
            }
        };
        mockUserServiceAnswerForUserById(successfulAnswer);
        target.getUserById(any(String.class), userResponseCallback);
        verify(userResponseCallback, never()).onError(any(String.class));
        verify(userResponseCallback).onSuccess(any(User.class));
    }

    @Test
    public void testUserByIdFailedRequest() {
        Answer failedAnswer = new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] getUserByIdArguments = invocation.getArguments();
                Callback retrofitCallback = ((Callback) getUserByIdArguments[getUserByIdArguments
                        .length - 1]);
                retrofitCallback.onFailure(null, new Exception(ERROR_MESSAGE));
                return null;
            }
        };
        mockUserServiceAnswerForUserById(failedAnswer);
        target.getUserById(any(String.class), userResponseCallback);
        verify(userResponseCallback).onError(ERROR_MESSAGE);
        verify(userResponseCallback, never()).onSuccess(any(User.class));
    }

    @Test
    public void testUserSuccessfulRequest() {


        Answer successfulAnswer = new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] getUserArguments = invocation.getArguments();
                Callback retrofitCallback = ((Callback) getUserArguments[getUserArguments
                        .length - 1]);
                retrofitCallback.onResponse(null, Response.success(any(User.class)));
                return null;
            }
        };
        mockUserServiceAnswerForUser(successfulAnswer);
        target.getUser(userResponseCallback);
        verify(userResponseCallback, never()).onError(any(String.class));
        verify(userResponseCallback).onSuccess(any(User.class));
    }

    @Test
    public void testUserFailedRequest() {
        Answer failedAnswer = new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] getUserArguments = invocation.getArguments();
                Callback retrofitCallback = ((Callback) getUserArguments[getUserArguments
                        .length - 1]);
                retrofitCallback.onFailure(null, new Exception(ERROR_MESSAGE));
                return null;
            }
        };
        mockUserServiceAnswerForUser(failedAnswer);
        target.getUser(userResponseCallback);
        verify(userResponseCallback).onError(ERROR_MESSAGE);
        verify(userResponseCallback, never()).onSuccess(any(User.class));
    }

    private void mockUserServiceAnswerForUserById(Answer answer) {
        doAnswer(answer).when(userCall).enqueue(any(Callback.class));

        doReturn(userCall).when(mockedUserService).getUserById(any(String.class));
    }

    private void mockUserServiceAnswerForUser(Answer answer) {
        doAnswer(answer).when(userCall).enqueue(any(Callback.class));

        doReturn(userCall).when(mockedUserService).getUser();
    }

    @Test
    public void testUsersListSuccessfulRequest() {
        Answer successfulAnswer = new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocation) {
                Object[] getUsersListAguments = invocation.getArguments();
                Callback retrofitCallback = ((Callback) getUsersListAguments[getUsersListAguments
                        .length - 1]);
                retrofitCallback.onResponse(null, Response.success(any(UserListResponse.class)));
                return null;
            }
        };
        mockUserServiceAnswerForUsersList(successfulAnswer);

        target.getUsersList(userListResponseResponseCallback);

        verify(userListResponseResponseCallback, never()).onError(any(String.class));
        verify(userListResponseResponseCallback).onSuccess(any(UserListResponse.class));

    }

    @Test
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
        verify(userListResponseResponseCallback, never()).onSuccess(any(UserListResponse.class));
    }

    @Test
    public void testCreatUserSuccessful() {
        Answer successfulAnswer = new Answer<Void>() {

            @Override
            public Void answer(InvocationOnMock invocation) {
                Object[] getUsersListArguments = invocation.getArguments();
                Callback retrofitCallback = ((Callback)
                        getUsersListArguments[getUsersListArguments.length - 1]);
                retrofitCallback.onResponse(null, Response.success(any(User.class)));
                return null;
            }
        };
        mockUserServiceAnswerForCreateUser(successfulAnswer);
        target.createUser(creatorRequest, userResponseCallback);
        verify(userResponseCallback, never()).onError(anyString());
        verify(userResponseCallback).onSuccess(any(User.class));
    }

    @Test
    public void testCreatUserFailed() {
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
        mockUserServiceAnswerForCreateUser(failedAnswer);
        target.createUser(creatorRequest, userResponseCallback);
        verify(userResponseCallback).onError(ERROR_MESSAGE);
        verify(userResponseCallback, never()).onSuccess(any(User.class));
    }

    @Test
    public void testPasswordAuthorizationCredentialsRequest() {
        mockCreatorRequest();
        Answer paramsValidator = new Answer<Call<User>>() {
            public Call<User> answer(InvocationOnMock invocation) {
                Object[] getArguments = invocation.getArguments();
                assertEquals(creatorRequest.getName(), ((CreatorRequest) getArguments[0]).getName
                        ());

                Answer successfulAnswer = new Answer<Void>() {
                    @Override
                    public Void answer(InvocationOnMock invocation) throws Throwable {
                        Object[] getAccessTokenArguments = invocation.getArguments();
                        Callback retrofitCallback = ((Callback)
                                getAccessTokenArguments[getAccessTokenArguments.length - 1]);

                        retrofitCallback.onResponse(null, Response.success(any(User.class)));
                        return null;
                    }
                };
                doAnswer(successfulAnswer)
                        .when(userCall)
                        .enqueue(any(Callback.class));

                return userCall;
            }
        };

        doAnswer(paramsValidator)
                .when(mockedUserService)
                .createUser(any(CreatorRequest.class));

        target.createUser(creatorRequest, userResponseCallback);
        verify(userResponseCallback, never()).onError(anyString());
        verify(userResponseCallback, only()).onSuccess(any(User.class));
    }

    private void mockCreatorRequest() {
        doReturn("name").when(creatorRequest).getName();
        doReturn("displayName").when(creatorRequest).getDisplayName();
        doReturn(ISO_3166_CountryCode.POLAND.getCountryCodeA2()).when(creatorRequest).getCountry();
        doReturn(2000).when(creatorRequest).getBirthMonth();
        doReturn(1).when(creatorRequest).getBirthYear();
        doReturn(Gender.MALE.toInt()).when(creatorRequest).getGender();
    }

    private void mockUserServiceAnswerForCreateUser(Answer answer) {
        doAnswer(answer).when(listCall).enqueue(any(Callback.class));
        doReturn(listCall).when(mockedUserService).createUser(any(CreatorRequest.class));
    }

    private void mockUserServiceAnswerForUsersList(Answer answer) {
        doAnswer(answer).when(listCall).enqueue(any(Callback.class));
        doReturn(listCall).when(mockedUserService).getUsers();
    }

}
