package com.creatubbles.api.repository;

import com.creatubbles.api.model.creation.Creation;
import com.creatubbles.api.model.upload.Upload;
import com.creatubbles.api.request.CreationListRequest;
import com.creatubbles.api.request.CreationRequest;
import com.creatubbles.api.request.UploadRequest;
import com.creatubbles.api.response.ResponseCallback;

import java.util.List;

/**
 * Created by Janek on 07.03.2016.
 */
public interface CreationRepository {

    void getCretiationsList(CreationListRequest body, ResponseCallback<List<Creation>>
            callback);

    void getCreationById(String id, ResponseCallback<Creation> callback);

    void updateCreation(String id, CreationRequest body, ResponseCallback<Void>
            callback);

    void createCreation(Creation creation, ResponseCallback<Creation> callback);

    void createUpload(String id, UploadRequest body, ResponseCallback<Upload> callback);

    void updateCreationUpload(String pingUrl, ResponseCallback<String> callback);
}
