package com.creatubbles.api.repository;

import com.creatubbles.api.CreatubblesApi;
import com.creatubbles.api.TestUtils;
import com.creatubbles.api.exception.InitializationException;
import com.creatubbles.api.exception.InvalidParametersException;
import com.creatubbles.api.model.AuthToken;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Janek on 18.02.2016.
 */
public class UserRepositoryBuilderTest {

    @Mock
    AuthToken authToken;

    private UserRepositoryBuilder target;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        CreatubblesApi.reset();
        TestUtils.resetModule();
        target = new UserRepositoryBuilder();
    }

    @Test(expected = InitializationException.class)
    public void testThrowsWhenCreatubblesApiIsNotInitialized() {
        target.setAuthToken(authToken).build();
    }

    @Test(expected = InvalidParametersException.class)
    public void testThrowsWhenMissedAuthToken() {
        target.build();
    }

    @Test
    public void testIsNotNullWhenPassedCorrectParameters() {
        TestUtils.initializeCreatubblesApi();
        target.setAuthToken(new AuthToken("testToken", "testTokenType", 3L));
        UserRepository repository = target.build();
        assertNotNull(repository);
    }
}
