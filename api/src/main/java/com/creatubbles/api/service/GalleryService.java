package com.creatubbles.api.service;


import com.creatubbles.api.EndPoints;
import com.creatubbles.api.model.GallerySubmission;
import com.creatubbles.api.model.creation.Creation;
import com.creatubbles.api.model.gallery.Gallery;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Janek on 05.02.2016.
 */
public interface GalleryService {

    String PARAM_ID = "id";
    String PATH_ID_GALLERIES = "/{" + PARAM_ID + "}/galleries";
    String PARAM_PAGE = "page";
    String PARAM_SORT = "sort";
    String PARAM_FILTER = "filter";
    String PARAM_QUERY = "query";

    @GET(EndPoints.GALLERIES)
    Call<JSONAPIDocument<List<Gallery>>> getPublic(@Query(PARAM_QUERY) String query,
                                                   @Query(PARAM_PAGE) Integer page,
                                                   @Query(PARAM_SORT) String sort);

    @GET(EndPoints.USERS + PATH_ID_GALLERIES)
    Call<JSONAPIDocument<List<Gallery>>> getByUser(@Path(PARAM_ID) String userId,
                                                   @Query(PARAM_PAGE) Integer page,
                                                   @Query(PARAM_QUERY) String query,
                                                   @Query(PARAM_FILTER) String filter);

    @GET(EndPoints.CREATIONS + PATH_ID_GALLERIES)
    Call<JSONAPIDocument<List<Gallery>>> getByCreation(@Path(PARAM_ID) String creationId,
                                                       @Query(PARAM_PAGE) Integer page);

    @GET(EndPoints.USERS + "/me/favorite_galleries")
    Call<JSONAPIDocument<List<Gallery>>> getFavorite(@Query(PARAM_PAGE) Integer page);

    @GET(EndPoints.FEATURED_GALLERIES)
    Call<JSONAPIDocument<List<Gallery>>> getFeatured(@Query(PARAM_PAGE) Integer page);

    @GET(EndPoints.GALLERIES + "/{" + PARAM_ID + "}")
    Call<JSONAPIDocument<Gallery>> getById(@Path(PARAM_ID) String galleryId);

    @POST(EndPoints.GALLERIES)
    Call<JSONAPIDocument<Gallery>> create(@Body Gallery gallery);

    @PUT(EndPoints.GALLERIES + "/{" + PARAM_ID + "}")
    Call<Void> update(@Path(PARAM_ID) String galleryId, @Body Gallery gallery);

    @POST(EndPoints.GALLERY_SUBMISSIONS)
    Call<JSONAPIDocument<GallerySubmission>> postSubmission(@Body GallerySubmission gallerySubmission);

    @HTTP(method = "DELETE", path = EndPoints.GALLERIES + "/{" + PARAM_ID + "}/relationships/creations", hasBody = true)
    Call<Void> removeCreations(@Path(PARAM_ID) String galleryId, @Body List<Creation> creations);
}
