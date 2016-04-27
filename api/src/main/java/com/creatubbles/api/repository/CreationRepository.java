package com.creatubbles.api.repository;

import com.creatubbles.api.model.CreationListResponse;
import com.creatubbles.api.model.CreationResponse;
import com.creatubbles.api.model.UploadResponse;
import com.creatubbles.api.request.CreationListRequest;
import com.creatubbles.api.request.CreationRequest;
import com.creatubbles.api.request.UploadRequest;
import com.creatubbles.api.response.ResponseCallback;

/**
 * Created by Janek on 07.03.2016.
 */
public interface CreationRepository {

    void getCretiationsList(CreationListRequest body, ResponseCallback<CreationListResponse>
            callback);

    void getCreationById(String id, ResponseCallback<CreationResponse> callback);

    void updateCreation(String id, CreationRequest body, ResponseCallback<Void>
            callback);

    void createCreation(CreationRequest body, ResponseCallback<CreationResponse> callback);

    void createUpload(String id, UploadRequest body, ResponseCallback<UploadResponse> callback);

    void updateCreationUpload(String pingUrl, ResponseCallback<String> callback);
}
