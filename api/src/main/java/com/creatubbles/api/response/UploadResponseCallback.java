package com.creatubbles.api.response;

import com.creatubbles.api.model.upload.UploadState;

public interface UploadResponseCallback<T> extends ResponseCallback<T> {

    void onStateChanged(UploadState uploadState);

}
