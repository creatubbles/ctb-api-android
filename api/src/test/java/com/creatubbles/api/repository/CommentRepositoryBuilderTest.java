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
 * @author Pawel Szymanski
 */
public class CommentRepositoryBuilderTest {
    private CommentRepositoryBuilder builder;

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
        builder = new CommentRepositoryBuilder(null);
    }

    @Test
    public void shouldCreateRepositoryWithAuthToken() throws Exception {
        builder = new CommentRepositoryBuilder(anyAuthToken());

        assertNotNull(builder.build());
    }

    private AccessToken anyAuthToken() {
        return mock(AccessToken.class);
    }
}