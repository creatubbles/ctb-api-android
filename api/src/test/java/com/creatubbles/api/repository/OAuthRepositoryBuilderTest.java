package com.creatubbles.api.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;


@RunWith(RobolectricTestRunner.class)
public class OAuthRepositoryBuilderTest {

    private OAuthRepositoryBuilder target;

    @Before
    public void setUp() {
        target = new OAuthRepositoryBuilder();
    }

    @Test
    public void testIsNullWhenPassedNullParameters() {
        OAuthRepository repository = target.build();
        assertNull(repository);
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
