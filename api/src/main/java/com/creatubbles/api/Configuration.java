package com.creatubbles.api;

import android.app.Application;

import com.creatubbles.api.exception.InvalidParametersException;

/**
 * Created by Janek on 11.10.2016.
 */

public class Configuration {

    private static final String INVALID_CLIENT_ID_MESSAGE = "ClientId can't be null!";
    private static final String INVALID_CLIENT_SECRET_MESSAGE = "ClientSecret can't be null!";
    private static final String INVALID_BASE_URL_MESSAGE = "BaseUrl can't be null!";
    private static final String INVALID_APPLICATION_CONTEXT_MESSAGE = "Application Context can't be null!";

    private final String clientId;
    private final String clientSecret;
    private final String baseUrl;
    private final Application context;

    public Configuration(Builder builder) {
        this.clientId = builder.clientId;
        this.clientSecret = builder.clientSecret;
        this.baseUrl = builder.baseUrl;
        this.context = builder.context;
    }

    public static class Builder {

        String clientId;
        String clientSecret;
        String baseUrl;
        Application context;

        public Builder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        public Builder clientSecret(String clientSecret) {
            this.clientSecret = clientSecret;
            return this;
        }

        public Builder baseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        public Builder application(Application application) {
            this.context = application;
            return this;
        }

        public Configuration build() {
            if (clientId == null) {
                throw new InvalidParametersException(INVALID_CLIENT_ID_MESSAGE);
            } else if (clientSecret == null) {
                throw new InvalidParametersException(INVALID_CLIENT_SECRET_MESSAGE);
            } else if (baseUrl == null) {
                throw new InvalidParametersException(INVALID_BASE_URL_MESSAGE);
            } else if (context == null) {
                throw new InvalidParametersException(INVALID_APPLICATION_CONTEXT_MESSAGE);
            } else {
                return new Configuration(this);
            }
        }
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public Application getContext() {
        return context;
    }
}
