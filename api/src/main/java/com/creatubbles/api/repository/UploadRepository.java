package com.creatubbles.api.repository;

import com.creatubbles.api.response.ResponseCallback;

import java.io.File;

import okhttp3.MediaType;

/**
 * Created by Mariusz Ostapowicz on 20.03.2016.
 */
public interface UploadRepository {

    void uploadFile(String url, MediaType contentType, File file, ResponseCallback<String>
            callback);
}
