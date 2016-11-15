package com.creatubbles.api.repository;

import com.creatubbles.api.CreatubblesApi;
import com.creatubbles.api.TestUtils;
import com.creatubbles.api.model.auth.AccessToken;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

/**
 * Created by Janek on 07.03.2016.
 */
public class CreationRepositoryBuilderTest {

    private CreationRepositoryBuilder target;

    @Before
    public void setUp() {
        TestUtils.initializeCreatubblesApi();
        target = new CreationRepositoryBuilder(anyToken());
    }

    @After
    public void tearDown() throws Exception {
        TestUtils.resetModule();
        CreatubblesApi.reset();
    }

    @Test(expected = NullPointerException.class)
    public void testThrowsWhenMissedAuthToken() {
        new CreationRepositoryBuilder(null);
    }

    @Test
    public void testIsNotNullWhenCreatubblesApiIsInitialized() {
        CreationRepository repository = target.build();
        assertNotNull(repository);
    }

    private AccessToken anyToken() {
        return mock(AccessToken.class);
    }
}
