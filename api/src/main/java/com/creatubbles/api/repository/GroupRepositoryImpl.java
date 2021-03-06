package com.creatubbles.api.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.group.Group;
import com.creatubbles.api.response.BaseResponseMapper;
import com.creatubbles.api.response.JsonApiResponseMapper;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.GroupService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import java.util.List;

import retrofit2.Call;

/**
 * @author Pawel Szymanski
 */
class GroupRepositoryImpl implements GroupRepository {
    private final GroupService service;
    private final ObjectMapper objectMapper;

    GroupRepositoryImpl(GroupService service, ObjectMapper objectMapper) {
        this.service = service;
        this.objectMapper = objectMapper;
    }

    @Override
    public void getAll(@Nullable ResponseCallback<CreatubblesResponse<List<Group>>> callback) {
        Call<JSONAPIDocument<List<Group>>> call = service.getGroups();
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getById(@NonNull String groupId, @Nullable ResponseCallback<CreatubblesResponse<Group>> callback) {
        Call<JSONAPIDocument<Group>> call = service.getGroup(groupId);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void create(@NonNull Group group, ResponseCallback<CreatubblesResponse<Group>> callback) {
        Call<JSONAPIDocument<Group>> call = service.postGroup(group);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void update(@NonNull String groupId, @NonNull Group group, @Nullable ResponseCallback<Void> callback) {
        Call<Void> call = service.putGroup(groupId, group);
        call.enqueue(new BaseResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void delete(@NonNull String groupId, @Nullable ResponseCallback<Void> callback) {
        Call<Void> call = service.deleteGroup(groupId);
        call.enqueue(new BaseResponseMapper<>(objectMapper, callback));
    }
}
