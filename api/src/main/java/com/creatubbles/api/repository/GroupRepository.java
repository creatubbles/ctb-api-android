package com.creatubbles.api.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.group.Group;
import com.creatubbles.api.response.ResponseCallback;

import java.util.List;

/**
 * Interface with methods allowing to manage user's Groups.
 *
 * @author Pawel Szymanski
 */
public interface GroupRepository {

    /**
     * Method used to obtain all of current user's groups.
     */
    void getAll(@Nullable ResponseCallback<CreatubblesResponse<List<Group>>> callback);

    /**
     * Method used to obtain Group specified by {@code groupId} param.
     */
    void getById(@NonNull String groupId, @Nullable ResponseCallback<CreatubblesResponse<Group>> callback);

    /**
     * Method used to create a Group with params as specified in {@code group} object.
     */
    void create(@NonNull Group group, @Nullable ResponseCallback<CreatubblesResponse<Group>> callback);

    /**
     * Method used to update Group specified by {@code groupId} param with fields specified in {@code group} object.
     */
    void update(@NonNull String groupId, @NonNull Group group, @Nullable ResponseCallback<Void> callback);

    /**
     * Method used to delete Group specified by {@code groupId} param.
     */
    void delete(@NonNull String groupId, @Nullable ResponseCallback<Void> callback);

}
