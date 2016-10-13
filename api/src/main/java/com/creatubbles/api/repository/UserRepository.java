package com.creatubbles.api.repository;

import android.support.annotation.NonNull;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.user.MultipleCreators;
import com.creatubbles.api.model.user.NewUser;
import com.creatubbles.api.model.user.User;
import com.creatubbles.api.response.ResponseCallback;

import java.util.List;

/**
 * Created by Janek on 18.02.2016.
 */
public interface UserRepository {

    String CURRENT_USER = "me";

    /**
     * Method used to obtain user's profile.
     *
     * @param id the ID of the user for which we want to get the results
     */
    void getUser(@NonNull String id, ResponseCallback<CreatubblesResponse<User>> callback);

    /**
     * Method used to obtain current user's profile.
     */
    void getUser(ResponseCallback<CreatubblesResponse<User>> callback);

    /**
     * Method used to obtain current user's creators.
     */
    void getCreators(ResponseCallback<CreatubblesResponse<List<User>>> callback);

    /**
     * Method used to obtain current user's managers.
     */
    void getManagers(ResponseCallback<CreatubblesResponse<List<User>>> callback);

    /**
     * Method used to obtain current user's 'My Connections'.
     */
    void getConnections(ResponseCallback<CreatubblesResponse<List<User>>> callback);

    /**
     * Method used to obtain current user's followed users.
     */
    void getFollowedUsers(ResponseCallback<CreatubblesResponse<List<User>>> callback);

    /**
     * Method used to obtain user's creators.
     *
     * @param userId the ID of the user for which we want to get the results
     */
    void getCreators(@NonNull String userId, ResponseCallback<CreatubblesResponse<List<User>>> callback);

    /**
     * Method used to obtain user's managers.
     *
     * @param userId the ID of the user for which we want to get the results
     */
    void getManagers(@NonNull String userId, ResponseCallback<CreatubblesResponse<List<User>>> callback);

    /**
     * Method used to obtain user's followed users.
     *
     * @param userId the ID of the user for which we want to get the results
     */
    void getFollowedUsers(@NonNull String userId, ResponseCallback<CreatubblesResponse<List<User>>> callback);

    /**
     * Method used to obtain user's 'My Connections'.
     *
     * @param userId the ID of the user for which we want to get the results
     */
    void getConnections(@NonNull String userId, ResponseCallback<CreatubblesResponse<List<User>>> callback);

    void createUser(@NonNull NewUser newUser, ResponseCallback<CreatubblesResponse<User>> callback);

}
