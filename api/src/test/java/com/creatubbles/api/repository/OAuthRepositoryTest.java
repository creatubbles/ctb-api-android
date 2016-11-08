package com.creatubbles.api.repository;

import com.creatubbles.api.model.AuthToken;
import com.creatubbles.api.model.auth.AccessToken;
import com.creatubbles.api.model.auth.ApplicationAccessToken;
import com.creatubbles.api.model.auth.UserAccessToken;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.GrantType;
import com.creatubbles.api.service.OAuthService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import retrofit2.Call;
import retrofit2.Callback;

import static com.creatubbles.api.repository.RepositoryTestUtil.getFailedAnswer;
import static com.creatubbles.api.repository.RepositoryTestUtil.getSuccessfulAnswer;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

/**
 * @author Matthew Platek on 12.02.2016.
 */
public class OAuthRepositoryTest {

    private static final String ERROR_MESSAGE = "What an error!";
    private OAuthRepository target;

    @Mock
    ResponseCallback<? extends AccessToken> authTokenResponseCallback;

    @Mock
    OAuthService mockedOAuthService;

    @Mock
    Call<AuthToken> call;

    @Mock
    AuthToken body;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        target = new OAuthRepositoryImpl(new ObjectMapper(), mockedOAuthService);
    }


    @Test
    public void testSimpleAuthorizationSuccessfulRequest() {
        mockOAuthServiceAnswerForSimpleUser(getSuccessfulAnswer(body));

        target.authorize((ResponseCallback<ApplicationAccessToken>) authTokenResponseCallback);

        verify(authTokenResponseCallback, never()).onError(any(String.class));
        verify(authTokenResponseCallback).onSuccess(any());
    }

    @Test
    public void testSimpleAuthorizationFailedRequest() {
        mockOAuthServiceAnswerForSimpleUser(getFailedAnswer(ERROR_MESSAGE));
        target.authorize((ResponseCallback<ApplicationAccessToken>) authTokenResponseCallback);
        verify(authTokenResponseCallback).onError(ERROR_MESSAGE);
        verify(authTokenResponseCallback, never()).onSuccess(any());
    }

    @Test
    public void testPasswordAuthorizationSuccessfulRequest() {
        mockOAuthServiceAnswerForPasswordUser(getSuccessfulAnswer(body));

        target.authorize("", "", (ResponseCallback<UserAccessToken>) authTokenResponseCallback);

        verify(authTokenResponseCallback, never()).onError(any(String.class));
        verify(authTokenResponseCallback).onSuccess(any());
    }

    @Test
    public void testPasswordAuthorizationCredentialsRequest() {
        final String login = "login";
        final String password = "password";
        Answer paramsValidator = new Answer<Call<AuthToken>>() {
            public Call<AuthToken> answer(InvocationOnMock invocation) {
                Object[] getAccessTokenArguments = invocation.getArguments();
                assertEquals(login, getAccessTokenArguments[3]);
                assertEquals(password, getAccessTokenArguments[4]);


                doAnswer(getSuccessfulAnswer(body))
                        .when(call)
                        .enqueue(any());

                return call;
            }
        };

        doAnswer(paramsValidator)
                .when(mockedOAuthService)
                .getAccessToken(any(String.class), any(String.class), any(GrantType.class),
                        any(String.class), any(String.class));

        target.authorize(login, password, (ResponseCallback<UserAccessToken>) authTokenResponseCallback);
    }

    @Test
    public void testPasswordAuthorizationFailedRequest() {
        mockOAuthServiceAnswerForPasswordUser(getFailedAnswer(ERROR_MESSAGE));

        target.authorize("", "", (ResponseCallback<UserAccessToken>) authTokenResponseCallback);

        verify(authTokenResponseCallback).onError(ERROR_MESSAGE);
        verify(authTokenResponseCallback, never()).onSuccess(any());
    }

    @Test
    public void testswitchUserSuccessfulRequest() {
        mockOAuthServiceAnswerForSwitchUser(getSuccessfulAnswer(body));

        target.switchUser(anyToken(), "", null, (ResponseCallback<UserAccessToken>) authTokenResponseCallback);

        verify(authTokenResponseCallback, never()).onError(any(String.class));
        verify(authTokenResponseCallback).onSuccess(any());
    }

    @Test
    public void testswitchUserFailedRequest() {
        mockOAuthServiceAnswerForSwitchUser(getFailedAnswer(ERROR_MESSAGE));

        target.switchUser(anyToken(), "", null, (ResponseCallback<UserAccessToken>) authTokenResponseCallback);

        verify(authTokenResponseCallback).onError(ERROR_MESSAGE);
        verify(authTokenResponseCallback, never()).onSuccess(any());
    }

    private void mockOAuthServiceAnswerForSimpleUser(Answer answer) {
        doAnswer(answer)
                .when(call)
                .enqueue(any(Callback.class));

        doReturn(call)
                .when(mockedOAuthService)
                .getAccessToken(any(String.class), any(String.class), any(GrantType.class));
    }

    private void mockOAuthServiceAnswerForPasswordUser(Answer answer) {
        doAnswer(answer)
                .when(call)
                .enqueue(any());

        doReturn(call)
                .when(mockedOAuthService)
                .getAccessToken(any(String.class), any(String.class), any(GrantType.class),
                        any(String.class), any(String.class));
    }

    private void mockOAuthServiceAnswerForSwitchUser(Answer answer) {
        doAnswer(answer)
                .when(call)
                .enqueue(any());

        doReturn(call)
                .when(mockedOAuthService)
                .switchUser(anyString(), any(GrantType.class), anyString(),
                        anyString());
    }

    private UserAccessToken anyToken() {
        return mock(UserAccessToken.class);
    }

}
