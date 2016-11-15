package com.creatubbles.api.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.partner_application.PartnerApplication;
import com.creatubbles.api.response.JsonApiResponseMapper;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.PartnerApplicationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import java.util.List;

import retrofit2.Call;

/**
 * @author Pawel Szymanski
 */
class PartnerApplicationRepositoryImpl implements PartnerApplicationRepository {

    private final PartnerApplicationService service;
    private final ObjectMapper objectMapper;

    PartnerApplicationRepositoryImpl(PartnerApplicationService service, ObjectMapper objectMapper) {
        this.service = service;
        this.objectMapper = objectMapper;
    }

    @Override
    public void search(@Nullable Integer page, @NonNull String query, ResponseCallback<CreatubblesResponse<List<PartnerApplication>>> callback) {
        Call<JSONAPIDocument<List<PartnerApplication>>> call = service.getList(page, query);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getById(@NonNull String partnerApplicationId, ResponseCallback<CreatubblesResponse<PartnerApplication>> callback) {
        Call<JSONAPIDocument<PartnerApplication>> call = service.getById(partnerApplicationId);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }
}
