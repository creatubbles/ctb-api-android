package com.creatubbles.api.repository;

import com.creatubbles.api.CreatubblesApi;
import com.creatubbles.api.TestUtils;
import com.creatubbles.api.model.AuthToken;
import com.creatubbles.api.model.auth.AccessToken;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

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
        TestUtils.initializeCreatubblesApi();
        target = new UserRepositoryBuilder(anyToken());
    }

    @After
    public void tearDown() throws Exception {
        CreatubblesApi.reset();
        TestUtils.resetModule();
    }

    @Test(expected = NullPointerException.class)
    public void testThrowsWhenMissedAuthToken() {
        new UserRepositoryBuilder(null);
    }

    @Test
    public void testIsNotNullWhenPassedCorrectParameters() {
        UserRepository repository = target.build();
        assertNotNull(repository);
    }

    private AccessToken anyToken() {
        return mock(AccessToken.class);
    }
}
