package com.creatubbles.api.repository;

import com.creatubbles.api.exception.InvalidParametersException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import static junit.framework.Assert.assertNotNull;


@RunWith(RobolectricTestRunner.class)
public class OAuthRepositoryBuilderTest {

    private OAuthRepositoryBuilder target;

    @Before
    public void setUp() {
        target = new OAuthRepositoryBuilder();
    }

    @Test(expected = InvalidParametersException.class)
    public void testThrowsWhenPassedNullParameters() {
        target.build();
    }

    @Test
    public void testIsNotNullWhenPassedCorrectParameters() {
        target.setClientId("testString");
        target.setClientSecret("testString");
        target.setContext(RuntimeEnvironment.application.getApplicationContext());

        OAuthRepository repository = target.build();
        assertNotNull(repository);
    }

}
