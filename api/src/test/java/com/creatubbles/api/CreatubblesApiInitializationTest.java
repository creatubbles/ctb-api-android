package com.creatubbles.api;

import com.creatubbles.api.exception.InitializationException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

/**
 * Created by Janek on 13.10.2016.
 */
public class CreatubblesApiInitializationTest {

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        CreatubblesApi.reset();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test(expected = NullPointerException.class)
    public void testThrowsWhenPassedNullParameters() {
        CreatubblesApi.initialize(null);
    }

    @Test(expected = InitializationException.class)
    public void testThrowsWhenTryToInitializeMoreThanOnce() {
        TestUtils.initializeCreatubblesApi();
        TestUtils.initializeCreatubblesApi();
    }

    @Test
    public void testCanInitializeCreatubblesApiAfterReset() {
        TestUtils.initializeCreatubblesApi();
        CreatubblesApi.reset();
        TestUtils.initializeCreatubblesApi();
    }

}
