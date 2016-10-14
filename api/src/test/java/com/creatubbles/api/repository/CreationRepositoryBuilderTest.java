package com.creatubbles.api.repository;

import com.creatubbles.api.CreatubblesApi;
import com.creatubbles.api.exception.InitializationException;
import com.creatubbles.api.exception.InvalidParametersException;
import com.creatubbles.api.model.AuthToken;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Janek on 07.03.2016.
 */
public class CreationRepositoryBuilderTest {

    private CreationRepositoryBuilder target;

    @Mock
    AuthToken authToken;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        TestUtils.resetModule();
        CreatubblesApi.reset();
        target = new CreationRepositoryBuilder();
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
    public void testIsNotNullWhenCreatubblesApiIsInitialized() {
        TestUtils.initializeCreatubblesApi();
        target.setAuthToken(new AuthToken("testToken", "testTokenType", 3L));
        CreationRepository repository = target.build();
        assertNotNull(repository);
    }
}
