package com.creatubbles.api.repository;

import com.creatubbles.api.model.CreateGalleryResponse;
import com.creatubbles.api.model.GalleryResponse;
import com.creatubbles.api.model.gallery.Gallery;
import com.creatubbles.api.request.CreateGalleryRequest;
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
    public void createGallery(CreateGalleryRequest body, ResponseCallback<CreateGalleryResponse>
            callback) {
        Call<CreateGalleryResponse> call = galleryService.createGallery(body);
        call.enqueue(new CallbackMapper<CreateGalleryResponse>().map(callback));
    }

    @Override
    public void getGalleriesByUser(String id, ResponseCallback<GalleryResponse> callback) {
        Call<GalleryResponse> call = galleryService.getGalleriesByUser(id);
        call.enqueue(new CallbackMapper<GalleryResponse>().map(callback));
    }

    @Override
    public void getGalleriesByCreation(String id, ResponseCallback<GalleryResponse> callback) {
        Call<GalleryResponse> call = galleryService.getGalleriesByCreation(id);
        call.enqueue(new CallbackMapper<GalleryResponse>().map(callback));
    }
}
