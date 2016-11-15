package com.creatubbles.api.repository;

import android.support.annotation.NonNull;

import com.creatubbles.api.model.Ability;
import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.ObjectType;
import com.creatubbles.api.model.Operation;
import com.creatubbles.api.response.ResponseCallback;

/**
 * Created by Janek on 04.11.2016.
 */

public interface AbilityRepository {

    void getSpecitfic(@NonNull ObjectType objectType, @NonNull String id, @NonNull Operation operation, ResponseCallback<CreatubblesResponse<Ability>> callback);
}
