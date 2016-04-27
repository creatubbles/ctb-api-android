package com.creatubbles.api.repository;

import com.creatubbles.api.model.GalleryResponse;
import com.creatubbles.api.request.CreateGalleryRequest;
import com.creatubbles.api.request.GalleryListRequest;
import com.creatubbles.api.response.CallbackMapper;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.GalleryService;

import retrofit2.Call;

/**
 * Created by Janek on 07.03.2016.
 */
public class GalleryRepositoryImpl implements GalleryRepository {

    GalleryService galleryService;

    public GalleryRepositoryImpl(GalleryService galleryService) {
        this.galleryService = galleryService;
    }

    @Override
    public void getGalleryById(String id, ResponseCallback<GalleryResponse> callback) {
        Call<GalleryResponse> call = galleryService.getGalleryById(id);
        call.enqueue(new CallbackMapper<GalleryResponse>().map(callback));
    }

    @Override
    public void getGalleries(GalleryListRequest body, ResponseCallback<GalleryResponse> callback) {
        Call<GalleryResponse> call = galleryService.userGallery(body);
        call.enqueue(new CallbackMapper<GalleryResponse>().map(callback));
    }

    @Override
    public void createGallery(CreateGalleryRequest body, ResponseCallback<GalleryResponse> callback) {
        Call<GalleryResponse> call = galleryService.createGallery(body);
        call.enqueue(new CallbackMapper<GalleryResponse>().map(callback));
    }
}
