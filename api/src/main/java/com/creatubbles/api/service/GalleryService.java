package com.creatubbles.api.service;


import com.creatubbles.api.EndPoints;
import com.creatubbles.api.model.CreateGalleryResponse;
import com.creatubbles.api.model.GalleryResponse;
import com.creatubbles.api.request.CreateGalleryRequest;

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
    Call<GalleryResponse> getGalleriesByUser(@Path("userId") String userId);

    @GET(EndPoints.CREATIONS)
    Call<GalleryResponse> getGalleriesByCreation(@Path("creationId") String creationId);

    @GET(EndPoints.GALLERIES + "/{galleryId}/galleries")
    Call<GalleryResponse> getGalleryById(@Path("galleryId") String galleryId);


    @POST(EndPoints.GALLERIES)
    Call<CreateGalleryResponse> createGallery(@Body CreateGalleryRequest galleryRequest);
}
