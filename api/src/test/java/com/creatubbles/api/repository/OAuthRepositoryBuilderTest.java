package com.creatubbles.api.repository;

import com.creatubbles.api.CreatubblesApi;
import com.creatubbles.api.TestUtils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static junit.framework.Assert.assertNotNull;

public class OAuthRepositoryBuilderTest {

    private OAuthRepositoryBuilder target;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        TestUtils.initializeCreatubblesApi();
        target = new OAuthRepositoryBuilder();
    }

    @After
    public void tearDown() throws Exception {
        TestUtils.resetModule();
        CreatubblesApi.reset();
    }

    @Test
    public void testIsNotNullWhenPassedCorrectParameters() {
        OAuthRepository repository = target.build();
        assertNotNull(repository);
    }

}
