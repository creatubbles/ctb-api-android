package com.creatubbles.api.service;

import com.creatubbles.api.EndPoints;
import com.creatubbles.api.model.search.SearchCategory;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CategoryService {
    String PARAM_PAGE = "page";
    String PARAM_TAG_FILTER = "filter[tag]";

    @GET(EndPoints.CATEGORIES)
    Call<JSONAPIDocument<List<SearchCategory>>> getCategories(@Query(PARAM_PAGE) Integer page);

    @GET(EndPoints.CATEGORIES)
    Call<JSONAPIDocument<List<SearchCategory>>> getCategories(@Query(PARAM_PAGE) Integer page, @Query(PARAM_TAG_FILTER) String tag);
}
