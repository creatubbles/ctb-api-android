package com.creatubbles.api.repository;

import android.support.annotation.NonNull;

import com.creatubbles.api.AbilityOperationVerifier;
import com.creatubbles.api.model.Ability;
import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.ObjectType;
import com.creatubbles.api.model.Operation;
import com.creatubbles.api.response.JsonApiResponseMapper;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.AbilityService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import retrofit2.Call;

/**
 * Created by Janek on 04.11.2016.
 */

public class AbilityRepositoryImpl implements AbilityRepository {

    private final ObjectMapper objectMapper;
    private final AbilityService abilityService;

    AbilityRepositoryImpl(ObjectMapper objectMapper, AbilityService abilityService) {
        this.objectMapper = objectMapper;
        this.abilityService = abilityService;
    }

    @Override
    public void getSpecitfic(@NonNull ObjectType objectType, @NonNull String id, @NonNull Operation operation, ResponseCallback<CreatubblesResponse<Ability>> callback) {
        AbilityOperationVerifier.verify(objectType, operation);
        Call<JSONAPIDocument<Ability>> call = abilityService.getSpecific(concatenate(objectType, id, operation));
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    private String concatenate(ObjectType objectType, String id, Operation operation) {
        return objectType.getTypeName() + ":" + id + ":" + operation.getOperationName();
    }
}
