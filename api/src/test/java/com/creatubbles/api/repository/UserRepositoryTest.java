package com.creatubbles.api.repository;

import com.creatubbles.api.exception.ErrorResponse;
import com.creatubbles.api.model.CreatubblesResponse;
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

import static com.creatubbles.api.repository.RepositoryTestUtil.getFailedAnswer;
import static com.creatubbles.api.repository.RepositoryTestUtil.getSuccessfulAnswer;
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

    private NewUser newUser;

    @Mock
    ResponseCallback<CreatubblesResponse<List<User>>> userListResponseResponseCallback;

    @Mock
    ResponseCallback<CreatubblesResponse<User>> userResponseCallback;

    @Mock
    UserService mockedUserService;

    @Mock
    Call<User> userCall;

    @Mock
    Call<List<User>> listCall;

    @Mock
    ErrorResponse errorResponse;

    @Mock
    JSONAPIDocument<?> body;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        target = new UserRepositoryImpl(new ObjectMapper(), mockedUserService);
        newUser = new NewUser.Builder("name")
                .displayName("displayName")
                .country(ISO_3166_CountryCode.POLAND.getCountryCodeA2())
                .birthYear(2000)
                .birthMonth(1)
                .build();
    }


    @Test
    public void testUserByIdSuccessfulRequest() {
        mockUserServiceAnswerForUserById(getSuccessfulAnswer(body));

        target.getUser(any(String.class), userResponseCallback);

        verify(userResponseCallback, never()).onError(any(String.class));
        verify(userResponseCallback).onSuccess(any());
    }

    @Test
    public void testUserByIdFailedRequest() {
        mockUserServiceAnswerForUserById(getFailedAnswer(ERROR_MESSAGE));

        target.getUser(userResponseCallback);

        verify(userResponseCallback).onError(ERROR_MESSAGE);
        verify(userResponseCallback, never()).onSuccess(any());
    }

    @Test
    public void testCreatorsSuccessfulRequest() {

        doAnswer(getSuccessfulAnswer(body)).when(listCall).enqueue(any());
        doReturn(listCall).when(mockedUserService).getCreators(anyString());

        target.getCreators(anyString(), userListResponseResponseCallback);

        verify(userListResponseResponseCallback, never()).onError(anyString());
        verify(userListResponseResponseCallback).onSuccess(any());

    }

    @Test
    public void testCreatorsFailedRequest() {
        doAnswer(getFailedAnswer(ERROR_MESSAGE)).when(listCall).enqueue(any());
        doReturn(listCall).when(mockedUserService).getCreators(anyString());

        target.getCreators(userListResponseResponseCallback);

        verify(userListResponseResponseCallback).onError(ERROR_MESSAGE);
        verify(userListResponseResponseCallback, never()).onSuccess(any());
    }

    @Test
    public void testFollowedSuccessfulRequest() {
        doAnswer(getSuccessfulAnswer(body)).when(listCall).enqueue(any());
        doReturn(listCall).when(mockedUserService).getFollowedUsers(anyString());

        target.getFollowedUsers(anyString(), userListResponseResponseCallback);

        verify(userListResponseResponseCallback, never()).onError(any(String.class));
        verify(userListResponseResponseCallback).onSuccess(any());

    }

    @Test
    public void testFollowedFailedRequest() {
        doAnswer(getFailedAnswer(ERROR_MESSAGE)).when(listCall).enqueue(any());
        doReturn(listCall).when(mockedUserService).getFollowedUsers(anyString());

        target.getFollowedUsers(userListResponseResponseCallback);

        verify(userListResponseResponseCallback).onError(ERROR_MESSAGE);
        verify(userListResponseResponseCallback, never()).onSuccess(any());
    }

    @Test
    public void testManagersSuccessfulRequest() {
        doAnswer(getSuccessfulAnswer(body)).when(listCall).enqueue(any());
        doReturn(listCall).when(mockedUserService).getManagers(anyString());

        target.getManagers(anyString(), userListResponseResponseCallback);

        verify(userListResponseResponseCallback, never()).onError(any(String.class));
        verify(userListResponseResponseCallback).onSuccess(any());

    }

    @Test
    public void testManagersFailedRequest() {
        doAnswer(getFailedAnswer(ERROR_MESSAGE)).when(listCall).enqueue(any());
        doReturn(listCall).when(mockedUserService).getManagers(anyString());

        target.getManagers(userListResponseResponseCallback);

        verify(userListResponseResponseCallback).onError(ERROR_MESSAGE);
        verify(userListResponseResponseCallback, never()).onSuccess(any());
    }

    @Test
    public void testConnectionsSuccessfulRequest() {
        doAnswer(getSuccessfulAnswer(body)).when(listCall).enqueue(any());
        doReturn(listCall).when(mockedUserService).getConnections(anyString());

        target.getConnections(anyString(), userListResponseResponseCallback);

        verify(userListResponseResponseCallback, never()).onError(any(String.class));
        verify(userListResponseResponseCallback).onSuccess(any());

    }

    @Test
    public void testConnectionsFailedRequest() {
        doAnswer(getFailedAnswer(ERROR_MESSAGE)).when(listCall).enqueue(any());
        doReturn(listCall).when(mockedUserService).getConnections(anyString());

        target.getConnections(userListResponseResponseCallback);

        verify(userListResponseResponseCallback).onError(ERROR_MESSAGE);
        verify(userListResponseResponseCallback, never()).onSuccess(any());
    }

    @Test
    public void testCreateUserSuccessful() {
        mockUserServiceAnswerForCreateUser(getSuccessfulAnswer(body));

        target.createUser(newUser, userResponseCallback);

        verify(userResponseCallback, never()).onError(anyString());
        verify(userResponseCallback).onSuccess(any());
    }

    @Test
    public void testCreateUserFailed() {
        mockUserServiceAnswerForCreateUser(getFailedAnswer(ERROR_MESSAGE));

        target.createUser(newUser, userResponseCallback);

        verify(userResponseCallback).onError(ERROR_MESSAGE);
        verify(userResponseCallback, never()).onSuccess(any());
    }

    @Test
    public void testPasswordAuthorizationCredentialsRequest() {
        Answer paramsValidator = new Answer<Call<User>>() {
            public Call<User> answer(InvocationOnMock invocation) {
                Object[] getArguments = invocation.getArguments();
                assertEquals(newUser.getName(), ((NewUser) getArguments[0]).getName
                        ());

                doAnswer(getSuccessfulAnswer(body))
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


    private void mockUserServiceAnswerForUserById(Answer answer) {
        doAnswer(answer).when(userCall).enqueue(any());

        doReturn(userCall).when(mockedUserService).getUserById(any(String.class));
    }

    private void mockUserServiceAnswerForCreateUser(Answer answer) {
        doAnswer(answer).when(listCall).enqueue(any());
        doReturn(listCall).when(mockedUserService).createUser(any(NewUser.class));
    }

}
