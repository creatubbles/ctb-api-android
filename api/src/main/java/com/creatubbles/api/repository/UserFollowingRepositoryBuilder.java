package com.creatubbles.api.repository;

import com.creatubbles.api.di.components.DaggerApiComponent;
import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.model.AuthToken;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;

/**
 * Class used to construct an instance of UserFollowingRepository.
 *
 * @author Pawel Szymanski
 */
public class UserFollowingRepositoryBuilder {

    @Inject
    UserService userService;
    @Inject
    ObjectMapper objectMapper;

    private final AuthToken authToken;

    /**
     * @param authToken an instance of {@link AuthToken}. This must be user access token acquired
     *                  using {@link OAuthRepository#authorize(String, String, ResponseCallback)}.
     */
    public UserFollowingRepositoryBuilder(AuthToken authToken) {
        if (authToken == null) {
            throw new NullPointerException("authToken can't be null");
        }
        DaggerApiComponent.builder().apiModule(ApiModule.getInstance(authToken))
                .build()
                .inject(this);
        this.authToken = authToken;
    }

    public UserFollowingRepository build() {
        return new UserFollowingRepositoryImpl(userService, objectMapper);
    }

}
