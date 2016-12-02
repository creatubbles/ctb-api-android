package com.creatubbles.api.repository;

import android.support.annotation.NonNull;

import com.creatubbles.api.di.components.DaggerApiComponent;
import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.model.auth.AccessToken;
import com.creatubbles.api.service.CommentService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;

/**
 * @author Pawel Szymanski
 */
public class CommentRepositoryBuilder {
    @Inject
    CommentService commentService;

    @Inject
    ObjectMapper objectMapper;

    private final AccessToken accessToken;

    /**
     * * Access Restrictions:
     * <ul>
     * <li>With an application only access token you get the published comments and cannot create new comments.</li>
     * <li>With an user access token you get all published comments and comments the user can approve.</li>
     */
    public CommentRepositoryBuilder(AccessToken accessToken) {
        if (accessToken == null) {
            throw new NullPointerException("accessToken can't be null");
        }
        this.accessToken = accessToken;
    }

    @NonNull
    public CommentRepository build() {
        DaggerApiComponent.builder().apiModule(ApiModule.getInstance(accessToken)).build()
                .inject(this);
        return new CommentRepositoryImpl(commentService, objectMapper);
    }
}
