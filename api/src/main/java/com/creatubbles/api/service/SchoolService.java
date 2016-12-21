package com.creatubbles.api.service;

import com.creatubbles.api.EndPoints;
import com.creatubbles.api.model.school.School;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * @author Pawel Szymanski
 */
public interface SchoolService {
    int FILTERS_COUNT = 3;
    String KEY_FILTER_NAME = "filter[name]";
    String KEY_COUNTRY = "preferred_country";
    String KEY_FILTER_IDS = "filter[id]";
    String PARAM_PAGE = "page";

    @GET(EndPoints.SCHOOLS)
    Call<JSONAPIDocument<List<School>>> getSchools(@QueryMap Map<String, String> filters,
                                                   @Query(PARAM_PAGE) Integer page);
}
