package com.creatubbles.api.repository;

import com.creatubbles.api.CreatubblesApi;
import com.creatubbles.api.TestUtils;
import com.creatubbles.api.exception.InvalidParametersException;
import com.creatubbles.api.model.AuthToken;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Janek on 07.03.2016.
 */
public class CreationRepositoryBuilderTest {

    private CreationRepositoryBuilder target;

    @Before
    public void setUp() {
        TestUtils.initializeCreatubblesApi();
        target = new CreationRepositoryBuilder();
    }

    @After
    public void tearDown() throws Exception {
        TestUtils.resetModule();
        CreatubblesApi.reset();
    }

    @Test(expected = InvalidParametersException.class)
    public void testThrowsWhenMissedAuthToken() {
        target.build();
    }

    @Test
    public void testIsNotNullWhenCreatubblesApiIsInitialized() {
        target.setAuthToken(new AuthToken("testToken", "testTokenType", 3L));
        CreationRepository repository = target.build();
        assertNotNull(repository);
    }
}
