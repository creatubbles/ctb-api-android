package com.creatubbles.api.service;


import com.creatubbles.api.EndPoints;
import com.creatubbles.api.model.gallery.Gallery;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Janek on 05.02.2016.
 */
public interface GalleryService {

    @GET(EndPoints.USERS + "/{userId}/galleries")
    Call<JSONAPIDocument<List<Gallery>>> getGalleriesByUser(@Path("userId") String userId);

    @GET(EndPoints.CREATIONS)
    Call<JSONAPIDocument<List<Gallery>>> getGalleriesByCreation(@Path("creationId") String creationId);

    @GET(EndPoints.GALLERIES + "/{galleryId}/galleries")
    Call<JSONAPIDocument<Gallery>> getGalleryById(@Path("galleryId") String galleryId);

    @POST(EndPoints.GALLERIES)
    Call<JSONAPIDocument<Gallery>> createGallery(@Body Gallery gallery);
}
