package com.creatubbles.api.repository;

import android.content.Context;

import com.creatubbles.api.exception.InvalidParametersException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static junit.framework.Assert.assertNotNull;

public class OAuthRepositoryBuilderTest {

    @Mock
    Context context;

    private OAuthRepositoryBuilder target;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        target = new OAuthRepositoryBuilder();
    }

    @Test(expected = InvalidParametersException.class)
    public void testThrowsWhenPassedNullParameters() {
        target.build();
    }

    @Test
    public void testIsNotNullWhenPassedCorrectParameters() {
        OAuthRepository repository = target.build();
        assertNotNull(repository);
    }

}
