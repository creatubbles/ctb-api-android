package com.creatubbles.api.repository;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.gallery.Gallery;
import com.creatubbles.api.response.JsonApiResponseMapper;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.GalleryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import java.util.List;

import retrofit2.Call;

/**
 * Created by Janek on 07.03.2016.
 */
public class GalleryRepositoryImpl implements GalleryRepository {

    private GalleryService galleryService;
    private ObjectMapper objectMapper;

    public GalleryRepositoryImpl(ObjectMapper objectMapper, GalleryService galleryService) {
        this.objectMapper = objectMapper;
        this.galleryService = galleryService;
    }

    @Override
    public void getGalleryById(String id, ResponseCallback<CreatubblesResponse<Gallery>> callback) {
        Call<JSONAPIDocument<Gallery>> call = galleryService.getGalleryById(id);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void createGallery(Gallery gallery, ResponseCallback<CreatubblesResponse<Gallery>>
            callback) {
        Call<JSONAPIDocument<Gallery>> call = galleryService.createGallery(gallery);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getGalleriesByUser(String id, ResponseCallback<CreatubblesResponse<List<Gallery>>> callback) {
        Call<JSONAPIDocument<List<Gallery>>> call = galleryService.getGalleriesByUser(id);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }

    @Override
    public void getGalleriesByCreation(String id, ResponseCallback<CreatubblesResponse<List<Gallery>>> callback) {
        Call<JSONAPIDocument<List<Gallery>>> call = galleryService.getGalleriesByCreation(id);
        call.enqueue(new JsonApiResponseMapper<>(objectMapper, callback));
    }
}
