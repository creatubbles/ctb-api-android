package com.creatubbles.api.repository;

import com.creatubbles.api.CreatubblesApi;
import com.creatubbles.api.TestUtils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Mariusz Ostapowicz on 20.03.2016.
 */
public class UploadRepositoryBuilderTest {

    private UploadRepositoryBuilder target;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        TestUtils.initializeCreatubblesApi();
        target = new UploadRepositoryBuilder();
    }

    @After
    public void tearDown() throws Exception {
        CreatubblesApi.reset();
        TestUtils.resetModule();
    }

    @Test
    public void testIsNotNullWhenPassedCorrectParameters() {
        UploadRepository repository = target.build();
        assertNotNull(repository);
    }
}
