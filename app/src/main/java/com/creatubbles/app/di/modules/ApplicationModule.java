package com.creatubbles.app.di.modules;

import android.content.Context;

import com.creatubbles.api.OAuthUtil;
import com.creatubbles.api.repository.OAuthRepository;
import com.creatubbles.api.repository.OAuthRepositoryBuilder;
import com.creatubbles.app.CreatubblesApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Janek on 16.02.2016.
 */
@Module
public class ApplicationModule {

    private final CreatubblesApplication application;

    public ApplicationModule(CreatubblesApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides
    @Singleton
    OAuthRepository provideOAuthRepository() {
        return new OAuthRepositoryBuilder().setClientId(OAuthUtil
                .CLIENT_ID).setClientSecret(OAuthUtil.CLIENT_SECRET).setContext(application).build();
    }

}
