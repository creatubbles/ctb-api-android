package com.creatubbles.api.service;


import com.creatubbles.api.EndPoints;
import com.creatubbles.api.model.GallerySubmission;
import com.creatubbles.api.model.creation.Creation;
import com.creatubbles.api.model.gallery.Gallery;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by Janek on 05.02.2016.
 */
public interface GalleryService {

    String PARAM_ID = "id";
    String PATH_ID_GALLERIES = "/{" + PARAM_ID + "}/galleries";
    String PARAM_PAGE = "page";
    String PARAM_SORT = "sort";
    String PARAM_FILTER = "filter[%s]";
    String PARAM_FILTER_LOCATION = "location";
    String PARAM_FILTER_SHARED_WITH = "shared_with";
    String PARAM_FILTER_OWNED_BY = "owned_by";
    String PARAM_QUERY = "query";
    String RELATIONSHIPS_CREATIONS = "/relationships/creations";

    @GET(EndPoints.GALLERIES)
    Call<JSONAPIDocument<List<Gallery>>> getPublic(@Query(PARAM_QUERY) String query,
                                                   @Query(PARAM_PAGE) Integer page,
                                                   @Query(PARAM_SORT) String sort);

    @GET(EndPoints.USERS + PATH_ID_GALLERIES)
    Call<JSONAPIDocument<List<Gallery>>> getByUser(@Path(PARAM_ID) String userId,
                                                   @Query(PARAM_PAGE) Integer page,
                                                   @Query(PARAM_QUERY) String query,
                                                   @QueryMap Map<String, String> filters);

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

    @HTTP(method = "DELETE", path = EndPoints.GALLERIES + "/{" + PARAM_ID + "}" + RELATIONSHIPS_CREATIONS, hasBody = true)
    Call<Void> removeCreations(@Path(PARAM_ID) String galleryId, @Body List<Creation> creations);

    @POST(EndPoints.GALLERIES + "/{" + PARAM_ID + "}" + RELATIONSHIPS_CREATIONS)
    Call<JSONAPIDocument<Gallery>> submitCreations(@Path(PARAM_ID) String galleryId, @Body List<Creation> creations);

    @PUT(EndPoints.GALLERIES + "/{" + PARAM_ID + "}/view")
    Call<Void> updateViewsCount(@Path(PARAM_ID) String galleryId);
}
