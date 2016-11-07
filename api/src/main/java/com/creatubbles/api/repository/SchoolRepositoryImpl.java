package com.creatubbles.api.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.school.School;
import com.creatubbles.api.response.JsonApiResponseMapper;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.SchoolService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;

/**
 * @author Pawel Szymanski
 */
class SchoolRepositoryImpl implements SchoolRepository {
    private final SchoolService service;
    private final ObjectMapper objectMapper;

    SchoolRepositoryImpl(SchoolService service, ObjectMapper objectMapper) {
        this.service = service;
        this.objectMapper = objectMapper;
    }

    @Override
    public void search(@Nullable Integer page, @NonNull SchoolQuery query, ResponseCallback<CreatubblesResponse<List<School>>> callback) {
        Map<String, String> filterParams = new HashMap<>(SchoolService.FILTERS_COUNT);
        if (query.getNameContaining() != null) {
            filterParams.put(SchoolService.KEY_FILTER_NAME, query.getNameContaining());
        }
        if (query.getCountryCode() != null) {
            filterParams.put(SchoolService.KEY_COUNTRY, query.getCountryCode());
        }
        if (query.getIds() != null && query.getIds().length > 0) {
            filterParams.put(SchoolService.KEY_FILTER_IDS, Arrays.toString(query.getIds()));
        }
        Call<JSONAPIDocument<List<School>>> call = service.getSchools(filterParams, page);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }
}
