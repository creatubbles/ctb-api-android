package com.creatubbles.api.service;

import com.creatubbles.api.EndPoints;
import com.creatubbles.api.model.Following;
import com.creatubbles.api.model.hashtag.Hashtag;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface HashtagService {

    String PARAM_HASH_TAG = "hash_tag";
    String PATH_FOLLOW = EndPoints.HASH_TAGS + "/{" + PARAM_HASH_TAG + "}/follow";

    @GET(EndPoints.HASH_TAGS + "/{" + PARAM_HASH_TAG + "}")
    Call<JSONAPIDocument<Hashtag>> get(@Path(PARAM_HASH_TAG) String hashTag);

    @POST(PATH_FOLLOW)
    Call<JSONAPIDocument<Following>> postFollow(@Path(PARAM_HASH_TAG) String hashTag);

    @DELETE(PATH_FOLLOW)
    Call<Void> deleteFollow(@Path(PARAM_HASH_TAG) String hashTag);
}
