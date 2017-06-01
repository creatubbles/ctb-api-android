package com.creatubbles.app.backend.builders;

import android.support.annotation.NonNull;

import com.creatubbles.api.Configuration;
import com.creatubbles.api.ContentType;
import com.creatubbles.api.repository.PrivateRepositoryDependencyProvider;
import com.creatubbles.app.backend.services.PrivateOAuthService;

public class PrivateOAuthRepositoryBuilder {

    PrivateRepositoryDependencyProvider provider = new PrivateRepositoryDependencyProvider();

    @NonNull
    public PrivateOAuthRepository build() {
        Configuration configuration = provider.provideConfiguration();
        PrivateOAuthService service = provider.provideService(PrivateOAuthService.class, ContentType.URL_ENCODED);
        return new PrivateOAuthRepositoryImpl(
                provider.provideObjectMapper(),
                service,
                configuration.getClientId(),
                configuration.getClientSecret()
        );
    }

}
