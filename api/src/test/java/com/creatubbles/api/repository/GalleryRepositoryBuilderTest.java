package com.creatubbles.api.repository;

import com.creatubbles.api.exception.InvalidParametersException;
import com.creatubbles.api.model.AuthToken;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertNotNull;

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

    @Test(expected = InvalidParametersException.class)
    public void testThrowsWhenPassedNullParameters() {
        target.build();
    }

    @Test
    public void testIsNotNullWhenPassedCorrectParameters() {
        target.setAuthToken(new AuthToken("testToken", "testTokenType", new Long("3")));
        GalleryRepository repository = target.build();
        assertNotNull(repository);
    }
}
