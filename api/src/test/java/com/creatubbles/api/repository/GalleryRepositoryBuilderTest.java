package com.creatubbles.api.repository;

import com.creatubbles.api.model.AuthToken;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by Janek on 07.03.2016.
 */
@RunWith(RobolectricTestRunner.class)
public class GalleryRepositoryBuilderTest {

    private GalleryRepositoryBuilder target;

    @Before
    public void setUp() {
        target = new GalleryRepositoryBuilder();
    }

    @Test
    public void testIsNullWhenPassedNullParameters() {
        GalleryRepository repository = target.build();
        assertNull(repository);
    }

    @Test
    public void testIsNotNullWhenPassedCorrectParameters() {
        target.setAuthToken(new AuthToken("testToken", "testTokenType", new Long("3")));
        GalleryRepository repository = target.build();
        assertNotNull(repository);
    }
}
