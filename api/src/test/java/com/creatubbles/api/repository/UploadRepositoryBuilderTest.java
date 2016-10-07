package com.creatubbles.api.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Mariusz Ostapowicz on 20.03.2016.
 */
@RunWith(RobolectricTestRunner.class)
public class UploadRepositoryBuilderTest {

    private UploadRepositoryBuilder target;

    @Before
    public void setUp() {
        target = new UploadRepositoryBuilder();
    }

    @Test
    public void testIsNotNullWhenPassedCorrectParameters() {
        target.setContext(RuntimeEnvironment.application.getApplicationContext());
        UploadRepository repository = target.build();
        assertNotNull(repository);
    }
}
