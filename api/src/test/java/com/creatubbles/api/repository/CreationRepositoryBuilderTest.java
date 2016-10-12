package com.creatubbles.api.repository;

import com.creatubbles.api.exception.InvalidParametersException;
import com.creatubbles.api.model.AuthToken;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Janek on 07.03.2016.
 */
@RunWith(RobolectricTestRunner.class)
public class CreationRepositoryBuilderTest {

    private CreationRepositoryBuilder target;

    @Before
    public void setUp() {
        target = new CreationRepositoryBuilder();
    }

    @Test(expected = InvalidParametersException.class)
    public void testThrowsWhenPassedNullParameters() {
        target.build();
    }

    @Test
    public void testIsNotNullWhenPassedCorrectParameters() {
        target.setAuthToken(new AuthToken("testToken", "testTokenType", new Long(3)));
        CreationRepository repository = target.build();
        assertNotNull(repository);
    }
}
