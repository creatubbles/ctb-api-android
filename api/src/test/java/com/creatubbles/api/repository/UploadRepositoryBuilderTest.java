package com.creatubbles.api.repository;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Mariusz Ostapowicz on 20.03.2016.
 */
public class UploadRepositoryBuilderTest {

    @Mock
    Context context;

    private UploadRepositoryBuilder target;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        target = new UploadRepositoryBuilder();
    }

    @Test
    public void testIsNotNullWhenPassedCorrectParameters() {
        UploadRepository repository = target.build();
        assertNotNull(repository);
    }
}
