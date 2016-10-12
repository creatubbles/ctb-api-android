package com.creatubbles.api.repository;

import com.creatubbles.api.model.CtbResponse;
import com.creatubbles.api.model.gallery.Gallery;
import com.creatubbles.api.response.ResponseCallback;

import java.util.List;

/**
 * Created by Janek on 07.03.2016.
 */
public interface GalleryRepository {

    void getGalleryById(String id, ResponseCallback<CtbResponse<Gallery>> callback);

    void createGallery(Gallery gallery, ResponseCallback<CtbResponse<Gallery>> callback);

    void getGalleriesByUser(String id, ResponseCallback<CtbResponse<List<Gallery>>> callback);

    void getGalleriesByCreation(String id, ResponseCallback<CtbResponse<List<Gallery>>> callback);
}
