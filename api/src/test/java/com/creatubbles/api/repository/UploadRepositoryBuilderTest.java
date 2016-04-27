package com.creatubbles.api.repository;

import com.creatubbles.api.model.AuthToken;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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
        UploadRepository repository = target.build();
        assertNotNull(repository);
    }
}
