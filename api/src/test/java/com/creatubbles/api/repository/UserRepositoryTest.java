package com.creatubbles.api.repository;

import com.creatubbles.api.exception.ErrorResponse;
import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.PasswordChange;
import com.creatubbles.api.model.school.School;
import com.creatubbles.api.model.user.AccountDetails;
import com.creatubbles.api.model.user.MultipleCreators;
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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class UserRepositoryTest {

    private static final String ERROR_MESSAGE = "What an error!";
    private UserRepository target;

    private NewUser newUser;

    @Mock
    ResponseCallback<CreatubblesResponse<List<User>>> userListResponseResponseCallback;

    @Mock
    ResponseCallback<CreatubblesResponse<User>> userResponseCallback;

    @Mock
    ResponseCallback<CreatubblesResponse<MultipleCreators>> multipleCreatorsCallback;

    @Mock
    UserService mockedUserService;


    @Mock
    ErrorResponse errorResponse;

    @Mock
    JSONAPIDocument<?> body;

    @Mock
    Call<JSONAPIDocument<AccountDetails>> accountCall;

    @Mock
    Call<Void> voidCall;

    @Mock
    Call<JSONAPIDocument<User>> userCall;

    @Mock
    Call<JSONAPIDocument<List<User>>> listCall;

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
        doReturn(listCall).when(mockedUserService).getCreators(anyString(), any());

        target.getCreators(anyString(), any(), userListResponseResponseCallback);

        verify(userListResponseResponseCallback, never()).onError(anyString());
        verify(userListResponseResponseCallback).onSuccess(any());

    }

    @Test
    public void testCreatorsFailedRequest() {
        doAnswer(getFailedAnswer(ERROR_MESSAGE)).when(listCall).enqueue(any());
        doReturn(listCall).when(mockedUserService).getCreators(anyString(), any());

        target.getCreators(null, userListResponseResponseCallback);

        verify(userListResponseResponseCallback).onError(ERROR_MESSAGE);
        verify(userListResponseResponseCallback, never()).onSuccess(any());
    }

    @Test
    public void testFollowedSuccessfulRequest() {
        doAnswer(getSuccessfulAnswer(body)).when(listCall).enqueue(any());
        doReturn(listCall).when(mockedUserService).getFollowedUsers(anyString(), any());

        target.getFollowedUsers(anyString(), any(), userListResponseResponseCallback);

        verify(userListResponseResponseCallback, never()).onError(any(String.class));
        verify(userListResponseResponseCallback).onSuccess(any());

    }

    @Test
    public void testFollowedFailedRequest() {
        doAnswer(getFailedAnswer(ERROR_MESSAGE)).when(listCall).enqueue(any());
        doReturn(listCall).when(mockedUserService).getFollowedUsers(anyString(), any());

        target.getFollowedUsers(null, userListResponseResponseCallback);

        verify(userListResponseResponseCallback).onError(ERROR_MESSAGE);
        verify(userListResponseResponseCallback, never()).onSuccess(any());
    }

    @Test
    public void testManagersSuccessfulRequest() {
        doAnswer(getSuccessfulAnswer(body)).when(listCall).enqueue(any());
        doReturn(listCall).when(mockedUserService).getManagers(anyString(), any());

        target.getManagers(anyString(), any(), userListResponseResponseCallback);

        verify(userListResponseResponseCallback, never()).onError(any(String.class));
        verify(userListResponseResponseCallback).onSuccess(any());

    }

    @Test
    public void testManagersFailedRequest() {
        doAnswer(getFailedAnswer(ERROR_MESSAGE)).when(listCall).enqueue(any());
        doReturn(listCall).when(mockedUserService).getManagers(anyString(), any());

        target.getManagers(null, userListResponseResponseCallback);

        verify(userListResponseResponseCallback).onError(ERROR_MESSAGE);
        verify(userListResponseResponseCallback, never()).onSuccess(any());
    }

    @Test
    public void testConnectionsSuccessfulRequest() {
        doAnswer(getSuccessfulAnswer(body)).when(listCall).enqueue(any());
        doReturn(listCall).when(mockedUserService).getConnections(anyString(), any());

        target.getConnections(anyString(), any(), userListResponseResponseCallback);

        verify(userListResponseResponseCallback, never()).onError(any(String.class));
        verify(userListResponseResponseCallback).onSuccess(any());

    }

    @Test
    public void testConnectionsFailedRequest() {
        doAnswer(getFailedAnswer(ERROR_MESSAGE)).when(listCall).enqueue(any());
        doReturn(listCall).when(mockedUserService).getConnections(anyString(), any());

        target.getConnections(null, userListResponseResponseCallback);

        verify(userListResponseResponseCallback).onError(ERROR_MESSAGE);
        verify(userListResponseResponseCallback, never()).onSuccess(any());
    }

    @Test
    public void testSwitchUsersSuccessfulRequest() {
        doAnswer(getSuccessfulAnswer(body)).when(listCall).enqueue(any());
        doReturn(listCall).when(mockedUserService).getSwitchUsers(any());

        target.getUsersAvailableForSwitching(any(), userListResponseResponseCallback);

        verify(userListResponseResponseCallback, never()).onError(any(String.class));
        verify(userListResponseResponseCallback).onSuccess(any());

    }

    @Test
    public void testSwitchUsersFailedRequest() {
        doAnswer(getFailedAnswer(ERROR_MESSAGE)).when(listCall).enqueue(any());
        doReturn(listCall).when(mockedUserService).getSwitchUsers(any());

        target.getUsersAvailableForSwitching(any(), userListResponseResponseCallback);

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
    public void testCreateMultipleCreatorsSuccess() {

        doAnswer(getSuccessfulAnswer(body)).when(listCall).enqueue(any());
        doReturn(listCall).when(mockedUserService).createMultipleCreators(any());

        MultipleCreators multipleCreators = new MultipleCreators.Builder(10, 2000)
                .build();

        target.createMultipleCreators(multipleCreators, multipleCreatorsCallback);

        verify(multipleCreatorsCallback, never()).onError(anyString());
        verify(multipleCreatorsCallback).onSuccess(any());
    }

    @Test
    public void testCreateMultipleCreatorsFailed() {
        doAnswer(getFailedAnswer(ERROR_MESSAGE)).when(listCall).enqueue(any());
        doReturn(listCall).when(mockedUserService).createMultipleCreators(any());
        MultipleCreators multipleCreators = new MultipleCreators.Builder(10, 2000)
                .build();

        target.createMultipleCreators(multipleCreators, multipleCreatorsCallback);

        verify(multipleCreatorsCallback).onError(ERROR_MESSAGE);
        verify(multipleCreatorsCallback, never()).onSuccess(any());
    }

    @Test
    public void testPasswordAuthorizationCredentialsRequest() {
        Answer paramsValidator = new Answer<Call<JSONAPIDocument<User>>>() {
            public Call<JSONAPIDocument<User>> answer(InvocationOnMock invocation) {
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

    @Test
    public void testCreatorsFromGroupSuccessful() {
        doAnswer(getSuccessfulAnswer(body)).when(listCall).enqueue(any());
        doReturn(listCall).when(mockedUserService).getCreatorsFromGroup(anyString(), any());

        target.getCreatorsFromGroup(anyString(), any(), userListResponseResponseCallback);

        verify(userListResponseResponseCallback, never()).onError(any(String.class));
        verify(userListResponseResponseCallback).onSuccess(any());

    }

    @Test
    public void testCreatorsFromGroupFailedRequest() {
        doAnswer(getFailedAnswer(ERROR_MESSAGE)).when(listCall).enqueue(any());
        doReturn(listCall).when(mockedUserService).getCreatorsFromGroup(anyString(), any());

        target.getCreatorsFromGroup(anyString(), any(), userListResponseResponseCallback);

        verify(userListResponseResponseCallback).onError(ERROR_MESSAGE);
        verify(userListResponseResponseCallback, never()).onSuccess(any());
    }

    @Test
    public void shouldCallGetAccountWhenObtainingAccountDetails() throws Exception {
        when(mockedUserService.getAccount(any())).thenReturn(accountCall);

        target.getAccountDetails(anyCallback());

        verify(mockedUserService).getAccount(any());
        verify(accountCall).enqueue(any());
    }

    @Test
    public void shouldCallPutAccountDataWhenUpdating() throws Exception {
        when(mockedUserService.putAccountData(any(), any())).thenReturn(voidCall);

        target.updateAccountDetails("", mock(AccountDetails.class), anyCallback());

        verify(mockedUserService).putAccountData(any(), any());
        verify(voidCall).enqueue(any());
    }

    @Test
    public void shouldPutAccountDataChangeWhenLinkingSchool() throws Exception {
        when(mockedUserService.putSchool(any(), any())).thenReturn(voidCall);

        target.linkSchoolWithAccount("", mock(School.class), anyCallback());

        verify(mockedUserService).putSchool(any(), any());
        verify(voidCall).enqueue(any());
    }


    @Test
    public void shouldPostPasswordChangeWhenChangingPassword() throws Exception {
        when(mockedUserService.postPasswordChange(any(), any())).thenReturn(userCall);

        target.changePassword("", mock(PasswordChange.class), anyCallback());

        verify(mockedUserService).postPasswordChange(any(), any());
        verify(userCall).enqueue(any());
    }

    private <T> ResponseCallback<T> anyCallback() {
        return null;
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
