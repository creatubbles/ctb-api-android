package com.creatubbles.api.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.user.AccountDetails;
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
    void getCreators(@Nullable Integer page, ResponseCallback<CreatubblesResponse<List<User>>> callback);

    /**
     * Method used to obtain current user's managers.
     */
    void getManagers(@Nullable Integer page, ResponseCallback<CreatubblesResponse<List<User>>> callback);

    /**
     * Method used to obtain current user's 'My Connections'.
     */
    void getConnections(@Nullable Integer page, ResponseCallback<CreatubblesResponse<List<User>>> callback);

    /**
     * Method used to obtain current user's followed users.
     */
    void getFollowedUsers(@Nullable Integer page, ResponseCallback<CreatubblesResponse<List<User>>> callback);

    /**
     * Method used to obtain user's creators.
     *
     * @param userId the ID of the user for which we want to get the results
     */
    void getCreators(@NonNull String userId, @Nullable Integer page, ResponseCallback<CreatubblesResponse<List<User>>> callback);

    /**
     * Method used to obtain user's managers.
     *
     * @param userId the ID of the user for which we want to get the results
     */
    void getManagers(@NonNull String userId, @Nullable Integer page, ResponseCallback<CreatubblesResponse<List<User>>> callback);

    /**
     * Method used to obtain user's followed users.
     *
     * @param userId the ID of the user for which we want to get the results
     */
    void getFollowedUsers(@NonNull String userId, @Nullable Integer page, ResponseCallback<CreatubblesResponse<List<User>>> callback);

    /**
     * Method used to obtain user's 'My Connections'.
     *
     * @param userId the ID of the user for which we want to get the results
     */
    void getConnections(@NonNull String userId, @Nullable Integer page, ResponseCallback<CreatubblesResponse<List<User>>> callback);

    /**
     * Method used to create new Creator managed by current user.
     */
    void createUser(@NonNull NewUser newUser, ResponseCallback<CreatubblesResponse<User>> callback);

    /**
     * Method used to obtain users available for user switching.
     */
    void getUsersAvailableForSwitching(@Nullable Integer page, ResponseCallback<CreatubblesResponse<List<User>>> callback);

    /**
     * This method adds multiple creators (managed users) to the list of creators managed by logged-in user.
     * Those creators have name generated automatically based on current user’s name.
     *
     * @param multipleCreators object defining required params
     */
    void createMultipleCreators(@NonNull MultipleCreators multipleCreators, ResponseCallback<CreatubblesResponse<MultipleCreators>> callback);

    /**
     * Method used to obtain current user’s creators by group.
     */
    void getCreatorsFromGroup(@NonNull String groupId, @Nullable Integer page, ResponseCallback<CreatubblesResponse<List<User>>> callback);

    /**
     * Method used to obtain current user's account details. This requires user access token
     * and the user must be manager of given user.
     *
     * @see AccountDetails
     */
    void getAccountDetails(ResponseCallback<CreatubblesResponse<AccountDetails>> callback);

    /**
     * Method used to obtain specific user's account details. This requires user access token
     * and the user must be manager of given user.
     *
     * @see AccountDetails
     */
    void getAccountDetails(@NonNull String userId, ResponseCallback<CreatubblesResponse<AccountDetails>> callback);
}
