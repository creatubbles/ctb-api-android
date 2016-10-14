package com.creatubbles.api.repository;

import com.creatubbles.api.CreatubblesApi;
import com.creatubbles.api.exception.InitializationException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static junit.framework.Assert.assertNotNull;

public class OAuthRepositoryBuilderTest {

    private OAuthRepositoryBuilder target;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        CreatubblesApi.reset();
        TestUtils.resetModule();
        target = new OAuthRepositoryBuilder();
    }

    @Test(expected = InitializationException.class)
    public void testThrowsWhenCreatubblesApiIsNotInitialized() {
        target.build();
    }

    @Test
    public void testIsNotNullWhenPassedCorrectParameters() {
        TestUtils.initializeCreatubblesApi();
        OAuthRepository repository = target.build();
        assertNotNull(repository);
    }

}
