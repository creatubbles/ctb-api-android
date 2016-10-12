package com.creatubbles.api.service;

import com.creatubbles.api.EndPoints;
import com.creatubbles.api.model.creation.Creation;
import com.creatubbles.api.model.upload.Upload;
import com.creatubbles.api.request.CreationListRequest;
import com.creatubbles.api.request.UploadRequest;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Janek on 11.02.2016.
 */
public interface CreationService {


    @GET(EndPoints.CREATIONS)
    Call<JSONAPIDocument<List<Creation>>> getListOfCreation(@Body CreationListRequest body);

    @GET(EndPoints.CREATIONS + "/{creationId}")
    Call<JSONAPIDocument<Creation>> getCreationById(@Path("creationId") String creationId);

    @PUT(EndPoints.CREATIONS + "/{creationId}")
    Call<Void> updateCreation(@Path("creationId") String creationId, @Body Creation body);

    @POST(EndPoints.CREATIONS)
    Call<JSONAPIDocument<Creation>> createCreation(@Body Creation creation);

    @POST(EndPoints.CREATIONS_UPLOADS)
    Call<JSONAPIDocument<Upload>> createUpload(@Path("id") String id, @Body UploadRequest body);

    @PUT(EndPoints.PING_CREATIONS_UPLOADS)
    Call<Void> updateCreationUpload(@Path("id") String id);
}
