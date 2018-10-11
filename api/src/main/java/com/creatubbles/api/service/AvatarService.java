package com.creatubbles.api.service;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AvatarService {
    @GET("/v2/avatar/editor_config")
    Call<String> getConfig();
}