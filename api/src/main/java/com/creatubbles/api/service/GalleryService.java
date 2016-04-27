package com.creatubbles.api.service;


import com.creatubbles.api.EndPoints;
import com.creatubbles.api.model.GalleryResponse;
import com.creatubbles.api.request.CreateGalleryRequest;
import com.creatubbles.api.request.GalleryListRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Janek on 05.02.2016.
 */
public interface GalleryService {

    @GET(EndPoints.GALLERIES)
    Call<GalleryResponse> userGallery(@Body GalleryListRequest galleryListRequest);

    @GET(EndPoints.GALLERIES + "/{galleryId}")
    Call<GalleryResponse> getGalleryById(@Path("galleryId") String galleryId);


    @POST(EndPoints.GALLERIES)
    Call<GalleryResponse> createGallery(@Body CreateGalleryRequest galleryRequest);
}
