package com.creatubbles.api.repository;

import com.creatubbles.api.model.GalleryResponse;
import com.creatubbles.api.request.CreateGalleryRequest;
import com.creatubbles.api.request.GalleryListRequest;
import com.creatubbles.api.response.ResponseCallback;

/**
 * Created by Janek on 07.03.2016.
 */
public interface GalleryRepository {

    void getGalleryById(String id, ResponseCallback<GalleryResponse> callback);

    void getGalleries(GalleryListRequest body, ResponseCallback<GalleryResponse> callback);

    void createGallery(CreateGalleryRequest body, ResponseCallback<GalleryResponse> callback);
}
