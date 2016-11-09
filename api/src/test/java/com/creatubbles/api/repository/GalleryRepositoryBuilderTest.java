package com.creatubbles.api.repository;

import com.creatubbles.api.CreatubblesApi;
import com.creatubbles.api.TestUtils;
import com.creatubbles.api.model.AuthToken;
import com.creatubbles.api.model.auth.AccessToken;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

/**
 * Created by Janek on 07.03.2016.
 */
public class GalleryRepositoryBuilderTest {

    @Mock
    AuthToken authToken;

    private GalleryRepositoryBuilder target;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        TestUtils.initializeCreatubblesApi();
        target = new GalleryRepositoryBuilder(anyToken());
    }

    @After
    public void tearDown() throws Exception {
        TestUtils.resetModule();
        CreatubblesApi.reset();
    }

    @Test(expected = NullPointerException.class)
    public void testThrowsWhenMissedAuthToken() {
        new GalleryRepositoryBuilder(null);
    }

    @Test
    public void testIsNotNullWhenPassedCorrectParameters() {
        GalleryRepository repository = target.build();
        assertNotNull(repository);
    }

    private AccessToken anyToken() {
        return mock(AccessToken.class);
    }
}
