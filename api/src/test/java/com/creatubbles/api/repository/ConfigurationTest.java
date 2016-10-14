package com.creatubbles.api.repository;

import android.app.Application;

import com.creatubbles.api.Configuration;
import com.creatubbles.api.exception.InvalidParametersException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.fail;

/**
 * Created by Janek on 13.10.2016.
 */

public class ConfigurationTest {

    private static final String INVALID_CLIENT_ID_MESSAGE = "ClientId can't be null!";
    private static final String INVALID_CLIENT_SECRET_MESSAGE = "ClientSecret can't be null!";
    private static final String INVALID_BASE_URL_MESSAGE = "BaseUrl can't be null!";
    private static final String INVALID_APPLICATION_CONTEXT_MESSAGE = "Application Context can't be null!";

    @Mock
    Application context;

    private Configuration target;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testThrowsWhenMissingClientSecret() {
        try {
            target = new Configuration.Builder()
                    .application(context)
                    .baseUrl("http://url.com")
                    .clientId("id")
                    .build();
        } catch (InvalidParametersException e) {
            assertEquals(e.getMessage(), INVALID_CLIENT_SECRET_MESSAGE);
            return;
        }
        fail();
    }

    @Test
    public void testThrowsWhenMissingClientId() {
        try {
            target = new Configuration.Builder()
                    .application(context)
                    .baseUrl("http://url.com")
                    .clientSecret("secret")
                    .build();
        } catch (InvalidParametersException e) {
            assertEquals(e.getMessage(), INVALID_CLIENT_ID_MESSAGE);
            return;
        }
        fail();
    }

    @Test
    public void testThrowsWhenMissingBaseUrl() {
        try {
            target = new Configuration.Builder()
                    .application(context)
                    .clientSecret("secret")
                    .clientId("id")
                    .build();
        } catch (InvalidParametersException e) {
            assertEquals(e.getMessage(), INVALID_BASE_URL_MESSAGE);
            return;
        }
        fail();
    }

    @Test
    public void testThrowsWhenMissingApplicationContext() {
        try {
            target = new Configuration.Builder()
                    .baseUrl("http://url.com")
                    .clientSecret("secret")
                    .clientId("id")
                    .build();
        } catch (InvalidParametersException e) {
            assertEquals(e.getMessage(), INVALID_APPLICATION_CONTEXT_MESSAGE);
            return;
        }
        fail();
    }

    @Test
    public void isNotNullWhenPassedCorrectParameters() {
        target = new Configuration.Builder()
                .application(context)
                .baseUrl("http://url.com")
                .clientSecret("secret")
                .clientId("id")
                .build();
        assertNotNull(target);
    }
}
