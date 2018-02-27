package com.creatubbles.api.service;

import com.creatubbles.api.EndPoints;
import com.creatubbles.api.model.Following;
import com.creatubbles.api.model.hashtag.Hashtag;
import com.creatubbles.api.model.user.User;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface HashtagService {

    String PARAM_HASH_TAG = "hash_tag";
    String PATH_FOLLOW = EndPoints.HASH_TAGS + "/{" + PARAM_HASH_TAG + "}/follow";
    String PARAM_PAGE = "page";
    String PARAM_QUERY = "query";

    @GET(EndPoints.HASH_TAGS + "/{" + PARAM_HASH_TAG + "}")
    Call<JSONAPIDocument<Hashtag>> get(@Path(PARAM_HASH_TAG) String hashTag);

    @POST(PATH_FOLLOW)
    Call<JSONAPIDocument<Following>> postFollow(@Path(PARAM_HASH_TAG) String hashTag);

    @DELETE(PATH_FOLLOW)
    Call<Void> deleteFollow(@Path(PARAM_HASH_TAG) String hashTag);

    @GET(EndPoints.HASH_TAGS + "/suggested")
    Call<JSONAPIDocument<List<Hashtag>>> getSuggested(@Query(PARAM_PAGE) Integer page);

    @GET(EndPoints.HASH_TAGS + "/{" + PARAM_HASH_TAG + "}/followers")
    Call<JSONAPIDocument<List<User>>> getFollowers(@Path(PARAM_HASH_TAG) String hashTag, @Query(PARAM_PAGE) Integer page, @Query(PARAM_QUERY) String query);
}
