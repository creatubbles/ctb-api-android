package com.creatubbles.api.repository;

import com.creatubbles.api.exception.InvalidParametersException;
import com.creatubbles.api.model.AuthToken;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Janek on 18.02.2016.
 */
@RunWith(RobolectricTestRunner.class)
public class UserRepositoryBuilderTest {

    private UserRepositoryBuilder target;

    @Before
    public void setUp() {
        target = new UserRepositoryBuilder();
    }

    @Test(expected = InvalidParametersException.class)
    public void testThrowsWhenPassedNullParameters() {
        target.build();
    }

    @Test
    public void testIsNotNullWhenPassedCorrectParameters() {
        target.setAuthToken(new AuthToken("testToken", "testTokenType", new Long("3")));
        target.setContext(RuntimeEnvironment.application.getApplicationContext());
        UserRepository repository = target.build();
        assertNotNull(repository);
    }
}
