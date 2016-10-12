package com.creatubbles.api.repository;

import com.creatubbles.api.model.CtbResponse;
import com.creatubbles.api.model.creation.Creation;
import com.creatubbles.api.model.upload.Upload;
import com.creatubbles.api.request.CreationListRequest;
import com.creatubbles.api.request.UploadRequest;
import com.creatubbles.api.response.ResponseCallback;

import java.util.List;

/**
 * Created by Janek on 07.03.2016.
 */
public interface CreationRepository {

    void getCretiationsList(CreationListRequest body, ResponseCallback<CtbResponse<List<Creation>>>
            callback);

    void getCreationById(String id, ResponseCallback<CtbResponse<Creation>> callback);

    void updateCreation(String id, Creation creation, ResponseCallback<Void>
            callback);

    void createCreation(Creation creation, ResponseCallback<CtbResponse<Creation>> callback);

    void createUpload(String id, UploadRequest body, ResponseCallback<CtbResponse<Upload>> callback);

    void updateCreationUpload(String pingUrl, ResponseCallback<Void> callback);
}
