package com.creatubbles.api.repository;

import com.creatubbles.api.CreatubblesApi;
import com.creatubbles.api.TestUtils;
import com.creatubbles.api.model.auth.AccessToken;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

/**
 * Created by Janek on 24.10.2016.
 */

public class CustomStyleRepositoryBuilderTest {

    private CustomStyleRepositoryBuilder builder;

    @Before
    public void setUp() throws Exception {
        TestUtils.initializeCreatubblesApi();
    }

    @After
    public void tearDown() throws Exception {
        TestUtils.resetModule();
        CreatubblesApi.reset();
    }

    @Test(expected = NullPointerException.class)
    public void shouldNotCreateRepositoryWithoutAuthToken() throws Exception {
        builder = new CustomStyleRepositoryBuilder(null);
    }

    @Test
    public void shouldCreateRepositoryWithAuthToken() throws Exception {
        builder = new CustomStyleRepositoryBuilder(anyToken());

        assertNotNull(builder.build());
    }

    private AccessToken anyToken() {
        return mock(AccessToken.class);
    }
}
