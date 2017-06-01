package com.creatubbles.api;

import android.app.Application;
import android.support.annotation.NonNull;

import com.creatubbles.api.exception.InvalidParametersException;

import okhttp3.Interceptor;


/**
 * Created by Janek on 11.10.2016.
 */

public class Configuration {

    static final String INVALID_CLIENT_ID_MESSAGE = "ClientId can't be null!";
    static final String INVALID_CLIENT_SECRET_MESSAGE = "ClientSecret can't be null!";
    static final String INVALID_BASE_URL_MESSAGE = "BaseUrl can't be null!";
    static final String INVALID_APPLICATION_CONTEXT_MESSAGE = "Application Context can't be null!";

    private final String clientId;
    private final String clientSecret;
    private final String clientCallbackUrl;
    private final String baseUrl;
    private final Application context;
    private final Locale locale;
    private final Interceptor interceptor;
    private final Class[] additionalApiModels;

    public Configuration(@NonNull Builder builder) {
        this.clientId = builder.clientId;
        this.clientSecret = builder.clientSecret;
        this.clientCallbackUrl = builder.clientCallbackUrl;
        this.baseUrl = builder.baseUrl;
        this.context = builder.context;
        this.locale = builder.locale;
        this.interceptor = builder.interceptor;
        this.additionalApiModels = builder.additionalApiModels;
    }

    public static class Builder {

        String clientId;
        String clientSecret;
        String clientCallbackUrl;
        String baseUrl;
        Application context;
        Locale locale;
        Interceptor interceptor;
        Class[] additionalApiModels;

        public Builder clientId(@NonNull String clientId) {
            this.clientId = clientId;
            return this;
        }

        public Builder clientSecret(@NonNull String clientSecret) {
            this.clientSecret = clientSecret;
            return this;
        }

        public Builder clientCallbackUrl(@NonNull String clientCallbackUrl) {
            this.clientCallbackUrl = clientCallbackUrl;
            return this;
        }

        public Builder baseUrl(@NonNull String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        public Builder application(@NonNull Application application) {
            this.context = application;
            return this;
        }

        public Builder locale(@NonNull Locale locale) {
            this.locale = locale;
            return this;
        }

        public Builder interceptor(Interceptor interceptor) {
            this.interceptor = interceptor;
            return this;
        }

        /**
         * For internal use only.
         */
        public Builder additionalApiModels(Class[] additionalApiModels) {
            this.additionalApiModels = additionalApiModels;
            return this;
        }

        @NonNull
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

    public String getClientCallbackUrl() {
        return clientCallbackUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public Application getContext() {
        return context;
    }

    public Locale getLocale() {
        return locale;
    }

    public Interceptor getInterceptor() {
        return interceptor;
    }

    public Class[] getAdditionalApiModels() {
        return additionalApiModels;
    }

}
