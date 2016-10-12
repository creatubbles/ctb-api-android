package com.creatubbles.api.di.modules;

import android.content.Context;

import com.creatubbles.api.Configuration;
import com.creatubbles.api.ContentType;
import com.creatubbles.api.ServiceGenerator;
import com.creatubbles.api.exception.InvalidParametersException;
import com.creatubbles.api.model.AuthToken;
import com.creatubbles.api.repository.CreationRepository;
import com.creatubbles.api.repository.CreationRepositoryImpl;
import com.creatubbles.api.repository.GalleryRepository;
import com.creatubbles.api.repository.GalleryRepositoryImpl;
import com.creatubbles.api.repository.LandingUrlsRepository;
import com.creatubbles.api.repository.LandingUrlsRepositoryImpl;
import com.creatubbles.api.repository.OAuthRepository;
import com.creatubbles.api.repository.OAuthRepositoryImpl;
import com.creatubbles.api.repository.UploadRepository;
import com.creatubbles.api.repository.UploadRepositoryImpl;
import com.creatubbles.api.repository.UserRepository;
import com.creatubbles.api.repository.UserRepositoryImpl;
import com.creatubbles.api.service.CreationService;
import com.creatubbles.api.service.GalleryService;
import com.creatubbles.api.service.LandingUrlsService;
import com.creatubbles.api.service.OAuthService;
import com.creatubbles.api.service.UploadService;
import com.creatubbles.api.service.UserService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Janek on 16.02.2016.
 */
@Module
public class ApiModule {

    private static ApiModule instance = null;
    private Configuration configuration = null;

    @Provides
    @Singleton
    ServiceGenerator provideServiceGenerator(Configuration configuration) {
        return new ServiceGenerator(configuration);
    }

    @Provides
    @Singleton
    Configuration provideConfiguration() {
        return configuration;
    }

    private static AuthToken authToken = null;

    private ApiModule(Configuration configuration) {
        this.configuration = configuration;
        provideServiceGenerator(configuration).initialize();
    }

    public static void initialize(Configuration apiConfiguration) {
        if (instance == null) {
            instance = new ApiModule(apiConfiguration);
        }
    }

    public static ApiModule getInstance(AuthToken token) {
        if (instance == null) {
            throw new InvalidParametersException("Creatubbles Api wasn't initialized!");
        } else {
            authToken = token;
            return instance;
        }
    }

    public static ApiModule getInstance() {
        if (instance == null) {
            throw new InvalidParametersException("CreatubblesApi wasn't initialized!");
        } else {
            return instance;
        }
    }

    @Provides
    @Singleton
    Context provideContext() {
        return configuration.getContext();
    }

    @Provides
    @Singleton
    OAuthService provideOAuthService(ServiceGenerator serviceGenerator) {
        return serviceGenerator.createService(OAuthService.class, ContentType.URL_ENCODED);
    }

    @Provides
    @Singleton
    OAuthRepository provideOAuthRepository(OAuthService oAuthService) {
        return new OAuthRepositoryImpl(oAuthService);
    }

    @Provides
    @Singleton
    GalleryService provideGalleryService(ServiceGenerator serviceGenerator) {
        return serviceGenerator.createService(GalleryService.class, ContentType.VND_JSON,
                authToken);
    }

    @Provides
    @Singleton
    GalleryRepository provideGalleryRepository(GalleryService galleryService) {
        return new GalleryRepositoryImpl(galleryService);
    }

    @Provides
    @Singleton
    CreationService provideCreationService(ServiceGenerator serviceGenerator) {
        return serviceGenerator.createService(CreationService.class, ContentType.VND_JSON,
                authToken);
    }

    @Provides
    @Singleton
    CreationRepository provideCreationRepository(CreationService creationService) {
        return new CreationRepositoryImpl(creationService);
    }

    @Provides
    @Singleton
    UserService provideUserService(ServiceGenerator serviceGenerator) {
        return serviceGenerator.createService(UserService.class, ContentType.VND_JSON, authToken);
    }

    @Provides
    @Singleton
    UserRepository provideUserRepository(UserService userService) {
        return new UserRepositoryImpl(userService);
    }

    @Provides
    @Singleton
    UploadService provideUploadService(ServiceGenerator serviceGenerator) {
        return serviceGenerator.createService(UploadService.class);
    }

    @Provides
    @Singleton
    UploadRepository provideUploadRepository(UploadService uploadService, Context context) {
        return new UploadRepositoryImpl(uploadService, context);
    }

    @Provides
    @Singleton
    LandingUrlsService provideLandingUrlsService(ServiceGenerator serviceGenerator) {
        return serviceGenerator.createService(LandingUrlsService.class, ContentType.URL_ENCODED,
                authToken);
    }

    @Provides
    @Singleton
    LandingUrlsRepository provideLandingUrlsRepository(LandingUrlsService landingUrlsService) {
        return new LandingUrlsRepositoryImpl(landingUrlsService);
    }

}
