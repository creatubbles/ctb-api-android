package com.creatubbles.api.service;

import com.creatubbles.api.EndPoints;
import com.creatubbles.api.model.content.Content;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ContentService {

    String PARAM_PAGE = "page";
    String PARAM_ID = "id";
    String PARAM_HASH_TAG = "hash_tag";

    @GET(EndPoints.CONTENTS)
    Call<JSONAPIDocument<List<Content>>> getContents(@Query(PARAM_PAGE) Integer page,
                                                     @Query("query") String query);

    @GET(EndPoints.CONTENTS + "/recent")
    Call<JSONAPIDocument<List<Content>>> getRecent(@Query(PARAM_PAGE) Integer page);

    @GET(EndPoints.CONTENTS + "/trending")
    Call<JSONAPIDocument<List<Content>>> getTrending(@Query(PARAM_PAGE) Integer page);

    @GET(EndPoints.CONTENTS + "/connected")
    Call<JSONAPIDocument<List<Content>>> getConnected(@Query(PARAM_PAGE) Integer page);

    @GET(EndPoints.CONTENTS + "/followed")
    Call<JSONAPIDocument<List<Content>>> getFollowed(@Query(PARAM_PAGE) Integer page);

    @GET(EndPoints.USERS + "/{" + PARAM_ID + "}/contents")
    Call<JSONAPIDocument<List<Content>>> getByUser(@Path(PARAM_ID) String userId,
                                                   @Query(PARAM_PAGE) Integer page);

    @GET(EndPoints.USERS + "/{" + PARAM_ID + "}/bubbled_contents")
    Call<JSONAPIDocument<List<Content>>> getBubbledByUser(@Path(PARAM_ID) String userId,
                                                          @Query(PARAM_PAGE) Integer page);


    @GET(EndPoints.HASH_TAGS + "/{" + PARAM_HASH_TAG + "}/contents")
    Call<JSONAPIDocument<List<Content>>> getByHashTag(@Path(PARAM_HASH_TAG) String hashTag,
                                                      @Query(PARAM_PAGE) Integer page);
}
