package com.creatubbles.api.service;

import com.creatubbles.api.EndPoints;
import com.creatubbles.api.model.creation.Creation;
import com.creatubbles.api.model.creation.ToybooDetails;
import com.creatubbles.api.model.image_manipulation.ImageManipulation;
import com.creatubbles.api.model.upload.Upload;
import com.creatubbles.api.request.UploadRequest;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface CreationService {

    String PARAM_PAGE = "page";
    String PARAM_USER_ID = "user_id";
    String PARAM_ONLY_PUBLIC = "filter[public]";
    String PARAM_GALLERY_ID = "gallery_id";
    String PARAM_SEARCH = "search";
    String PARAM_ABORTED_WITH = "aborted_with";
    String PARAM_CREATION_ID = "creation_id";
    String PARAM_PARTNER_APPLICATION_ID = "partner_application_id";

    String PATH_USER_ID = "{" + PARAM_USER_ID + "}";
    String PATH_CREATION_ID = "{" + PARAM_CREATION_ID + "}";

    @GET(EndPoints.CREATIONS)
    Call<JSONAPIDocument<List<Creation>>> getRecent(@Query(PARAM_PAGE) Integer page,
                                                    @Query(PARAM_ONLY_PUBLIC) Boolean onlyPublic);

    @GET(EndPoints.CREATIONS)
    Call<JSONAPIDocument<List<Creation>>> getFromGallery(@Query(PARAM_PAGE) Integer page,
                                                         @Query(PARAM_GALLERY_ID) String galleryId,
                                                         @Query(PARAM_ONLY_PUBLIC) Boolean onlyPublic);

    @GET(EndPoints.CREATIONS)
    Call<JSONAPIDocument<List<Creation>>> getByUser(@Query(PARAM_PAGE) Integer page,
                                                    @Query(PARAM_USER_ID) String userId,
                                                    @Query(PARAM_ONLY_PUBLIC) Boolean onlyPublic);

    @GET(EndPoints.CREATIONS)
    Call<JSONAPIDocument<List<Creation>>> searchByName(@Query(PARAM_PAGE) Integer page,
                                                       @Query(PARAM_SEARCH) String name,
                                                       @Query(PARAM_ONLY_PUBLIC) Boolean onlyPublic);

    @GET(EndPoints.CREATIONS + "/" + PATH_CREATION_ID + "/recommended_creations")
    Call<JSONAPIDocument<List<Creation>>> getRecommendedByCreation(@Query(PARAM_PAGE) Integer page,
                                                                   @Path(PARAM_CREATION_ID) String creationId,
                                                                   @Query(PARAM_ONLY_PUBLIC) Boolean onlyPublic);

    @GET(EndPoints.USERS + "/" + PATH_USER_ID + "/recommended_creations")
    Call<JSONAPIDocument<List<Creation>>> getRecommendedByUser(@Query(PARAM_PAGE) Integer page,
                                                               @Path(PARAM_USER_ID) String userId,
                                                               @Query(PARAM_ONLY_PUBLIC) Boolean onlyPublic);

    @GET(EndPoints.CREATIONS + "/" + PATH_CREATION_ID)
    Call<JSONAPIDocument<Creation>> getCreation(@Path(PARAM_CREATION_ID) String creationId);

    @POST(EndPoints.CREATIONS)
    Call<JSONAPIDocument<Creation>> createCreation(@Body Creation creation);

    @PUT(EndPoints.CREATIONS + "/" + PATH_CREATION_ID)
    Call<Void> updateCreation(@Path(PARAM_CREATION_ID) String creationId, @Body Creation body);

    @DELETE(EndPoints.CREATIONS + "/" + PATH_CREATION_ID)
    Call<Void> removeCreation(@Path(PARAM_CREATION_ID) String creationId);

    @POST(EndPoints.CREATIONS + "/" + PATH_CREATION_ID + "/uploads")
    Call<JSONAPIDocument<Upload>> createUpload(@Path(PARAM_CREATION_ID) String id, @Body UploadRequest body);

    @PUT
    @FormUrlEncoded
    Call<Void> updateCreationUpload(@Url String pingUrl, @Field(PARAM_ABORTED_WITH) String abortedWith);

    @PUT(EndPoints.CREATIONS + "/" + PATH_CREATION_ID + "/image_manipulation")
    Call<Void> putImageManipulation(@Path(PARAM_CREATION_ID) String id, @Body ImageManipulation imageManipulation);

    @GET(EndPoints.CREATIONS + "/" + PATH_CREATION_ID + "/toyboo_details")
    Call<JSONAPIDocument<ToybooDetails>> getToybooDetails(@Path(PARAM_CREATION_ID) String id);

    @GET(EndPoints.CREATIONS)
    Call<JSONAPIDocument<List<Creation>>> getByPartnerApplication(@Query(PARAM_PAGE) Integer page,
                                                                  @Query(PARAM_PARTNER_APPLICATION_ID) String partnerAppId);

    @PUT(EndPoints.CREATIONS + "/" + PATH_CREATION_ID + "/view")
    Call<Void> updateViewsCount(@Path(PARAM_CREATION_ID) String creationId);
}
