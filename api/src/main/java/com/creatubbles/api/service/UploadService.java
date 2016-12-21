package com.creatubbles.api.service;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.PUT;
import retrofit2.http.Url;

/**
 * Created by Mariusz Ostapowicz on 20.03.2016.
 */
public interface UploadService {

    @PUT
    Call<Void> uploadFile(@Url String url, @Body RequestBody image);
}
