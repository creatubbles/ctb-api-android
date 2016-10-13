package com.creatubbles.api.repository;

import android.content.Context;

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
    Context context;

    private UserRepositoryBuilder target;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        target = new UserRepositoryBuilder();
    }

    @Test(expected = InvalidParametersException.class)
    public void testThrowsWhenPassedNullParameters() {
        target.build();
    }

    @Test
    public void testIsNotNullWhenPassedCorrectParameters() {
        target.setAuthToken(new AuthToken("testToken", "testTokenType", 3L));
        UserRepository repository = target.build();
        assertNotNull(repository);
    }
}
