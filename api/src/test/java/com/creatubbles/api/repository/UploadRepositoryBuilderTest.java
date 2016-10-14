package com.creatubbles.api.repository;

import android.app.Application;

import com.creatubbles.api.CreatubblesApi;
import com.creatubbles.api.exception.InitializationException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Mariusz Ostapowicz on 20.03.2016.
 */
public class UploadRepositoryBuilderTest {

    @Mock
    Application context;

    private UploadRepositoryBuilder target;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        CreatubblesApi.reset();
        TestUtils.resetModule();
        target = new UploadRepositoryBuilder();
    }

    @Test(expected = InitializationException.class)
    public void testThrowsWhenCreatubblesApiIsNotInitialized() {
        target.build();
    }

    @Test
    public void testIsNotNullWhenPassedCorrectParameters() {
        TestUtils.initializeCreatubblesApi();
        UploadRepository repository = target.build();
        assertNotNull(repository);
    }
}
