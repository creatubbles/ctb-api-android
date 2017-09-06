package com.creatubbles.api.repository;

import android.support.annotation.Nullable;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.search.SearchCategory;
import com.creatubbles.api.response.ResponseCallback;

import java.util.List;

public interface SearchCategoryRepository {
    void getCategories(@Nullable Integer page, @Nullable ResponseCallback<CreatubblesResponse<List<SearchCategory>>> callback);
}
