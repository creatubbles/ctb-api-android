package com.creatubbles.api.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.PasswordChange;
import com.creatubbles.api.model.school.School;
import com.creatubbles.api.model.user.AccountDetails;
import com.creatubbles.api.model.user.MultipleCreators;
import com.creatubbles.api.model.user.NewUser;
import com.creatubbles.api.model.user.User;
import com.creatubbles.api.request.SchoolRequest;
import com.creatubbles.api.response.BaseResponseMapper;
import com.creatubbles.api.response.JsonApiResponseMapper;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.UserService;
import com.creatubbles.api.service.UserSortMode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import java.util.List;

import retrofit2.Call;

/**
 * Created by Janek on 18.02.2016.
 */
class UserRepositoryImpl implements UserRepository {

    private UserService userService;
    private ObjectMapper objectMapper;

    UserRepositoryImpl(ObjectMapper objectMapper, UserService service) {
        this.objectMapper = objectMapper;
        this.userService = service;
    }

    @Override
    public void searchUsers(@Nullable Integer page, @NonNull String query, @Nullable ResponseCallback<CreatubblesResponse<List<User>>> callback) {
        Call<JSONAPIDocument<List<User>>> call = userService.getUsers(page, query);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getUser(@NonNull String id, ResponseCallback<CreatubblesResponse<User>> callback) {
        Call<JSONAPIDocument<User>> call = userService.getUserById(id);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getUser(ResponseCallback<CreatubblesResponse<User>> callback) {
        Call<JSONAPIDocument<User>> call = userService.getUserById(CURRENT_USER);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getCreators(@Nullable Integer page, @Nullable String query, UserSortMode sortMode, ResponseCallback<CreatubblesResponse<List<User>>> callback) {
        Call<JSONAPIDocument<List<User>>> call = userService.getCreators(CURRENT_USER, query, page, getSortParam(sortMode));
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getManagers(@Nullable Integer page, @Nullable String query, UserSortMode sortMode, ResponseCallback<CreatubblesResponse<List<User>>> callback) {
        Call<JSONAPIDocument<List<User>>> call = userService.getManagers(CURRENT_USER, query, page, getSortParam(sortMode));
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getConnections(@Nullable Integer page, @Nullable String query, UserSortMode sortMode, ResponseCallback<CreatubblesResponse<List<User>>> callback) {
        Call<JSONAPIDocument<List<User>>> call = userService.getConnections(CURRENT_USER, query, page, getSortParam(sortMode));
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getFollowedUsers(@Nullable Integer page, @Nullable String query, UserSortMode sortMode, ResponseCallback<CreatubblesResponse<List<User>>> callback) {
        Call<JSONAPIDocument<List<User>>> call = userService.getFollowedUsers(CURRENT_USER, query, page, getSortParam(sortMode));
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getCreators(@NonNull String userId, @Nullable String query, @Nullable Integer page, UserSortMode sortMode, ResponseCallback<CreatubblesResponse<List<User>>> callback) {
        Call<JSONAPIDocument<List<User>>> call = userService.getCreators(userId, query, page, getSortParam(sortMode));
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getManagers(@NonNull String userId, @Nullable String query, @Nullable Integer page, UserSortMode sortMode, ResponseCallback<CreatubblesResponse<List<User>>> callback) {
        Call<JSONAPIDocument<List<User>>> call = userService.getManagers(userId, query, page, getSortParam(sortMode));
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getFollowedUsers(@NonNull String userId, @Nullable String query, @Nullable Integer page, UserSortMode sortMode, ResponseCallback<CreatubblesResponse<List<User>>> callback) {
        Call<JSONAPIDocument<List<User>>> call = userService.getFollowedUsers(userId, query, page, getSortParam(sortMode));
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getConnections(@NonNull String userId, @Nullable String query, @Nullable Integer page, UserSortMode sortMode, ResponseCallback<CreatubblesResponse<List<User>>> callback) {
        Call<JSONAPIDocument<List<User>>> call = userService.getConnections(userId, query, page, getSortParam(sortMode));
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void createUser(@NonNull NewUser newUser, ResponseCallback<CreatubblesResponse<User>> callback) {
        Call<JSONAPIDocument<User>> call = userService.createUser(newUser);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getUsersAvailableForSwitching(@Nullable Integer page, ResponseCallback<CreatubblesResponse<List<User>>> callback) {
        Call<JSONAPIDocument<List<User>>> call = userService.getSwitchUsers(page, null);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getUsersAvailableForSwitching(@Nullable Integer page, @Nullable String query, @Nullable ResponseCallback<CreatubblesResponse<List<User>>> callback) {
        Call<JSONAPIDocument<List<User>>> call = userService.getSwitchUsers(page, query);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void createMultipleCreators(@NonNull MultipleCreators multipleCreators, ResponseCallback<CreatubblesResponse<MultipleCreators>> callback) {
        Call<JSONAPIDocument<MultipleCreators>> call = userService.createMultipleCreators(multipleCreators);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getCreatorsFromGroup(@NonNull String groupId, @Nullable Integer page, ResponseCallback<CreatubblesResponse<List<User>>> callback) {
        Call<JSONAPIDocument<List<User>>> call = userService.getCreatorsFromGroup(groupId, page);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getAccountDetails(ResponseCallback<CreatubblesResponse<AccountDetails>> callback) {
        Call<JSONAPIDocument<AccountDetails>> call = userService.getAccount(CURRENT_USER);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getAccountDetails(@NonNull String userId, ResponseCallback<CreatubblesResponse<AccountDetails>> callback) {
        Call<JSONAPIDocument<AccountDetails>> call = userService.getAccount(userId);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void updateAccountDetails(@NonNull String userId, @NonNull AccountDetails accountDetails, ResponseCallback<Void> callback) {
        Call<Void> call = userService.putAccountData(userId, accountDetails);
        call.enqueue(new BaseResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void linkSchoolWithAccount(@NonNull String userId, @NonNull School school, ResponseCallback<Void> callback) {
        SchoolRequest request = new SchoolRequest(school);
        Call<Void> call = userService.putSchool(userId, request);
        call.enqueue(new BaseResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void changePassword(@NonNull String userId, @NonNull PasswordChange passwordChange, ResponseCallback<CreatubblesResponse<User>> callback) {
        Call<JSONAPIDocument<User>> call = userService.postPasswordChange(userId, passwordChange);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void searchConnections(@NonNull String query, @Nullable Integer page, @Nullable UserSortMode sortMode, @Nullable ResponseCallback<CreatubblesResponse<List<User>>> callback) {
        Call<JSONAPIDocument<List<User>>> call = userService.getConnections(CURRENT_USER, query, page, getSortParam(sortMode));
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getSuggestions(@Nullable Integer page, @Nullable ResponseCallback<CreatubblesResponse<List<User>>> callback) {
        userService.getSuggested(page).enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    private String getSortParam(UserSortMode sortMode) {
        return sortMode != null ? sortMode.getParam() : null;
    }

}
