package com.creatubbles.api.repository;

import android.content.Context;

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
public class GalleryRepositoryBuilderTest {

    @Mock
    Context context;

    private GalleryRepositoryBuilder target;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        target = new GalleryRepositoryBuilder();
    }

    @Test(expected = InvalidParametersException.class)
    public void testThrowsWhenPassedNullParameters() {
        target.build();
    }

    @Test
    public void testIsNotNullWhenPassedCorrectParameters() {
        target.setAuthToken(new AuthToken("testToken", "testTokenType", 3L));
        target.setContext(context);
        GalleryRepository repository = target.build();
        assertNotNull(repository);
    }
}
