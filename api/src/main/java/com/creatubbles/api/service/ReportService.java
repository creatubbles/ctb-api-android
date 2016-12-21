package com.creatubbles.api.service;

import com.creatubbles.api.EndPoints;
import com.creatubbles.api.model.Report;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * @author Pawel Szymanski
 */
public interface ReportService {

    String PARAM_ID = "id";
    String PATH_ID_REPORT = "/{" + PARAM_ID + "}/report";

    @POST(EndPoints.USERS + PATH_ID_REPORT)
    Call<Void> postForUser(@Path(PARAM_ID) String id, @Body Report report);

    @POST(EndPoints.CREATIONS + PATH_ID_REPORT)
    Call<Void> postForCreation(@Path(PARAM_ID) String id, @Body Report report);

    @POST(EndPoints.GALLERIES + PATH_ID_REPORT)
    Call<Void> postForGallery(@Path(PARAM_ID) String id, @Body Report report);

    @POST(EndPoints.COMMENTS + PATH_ID_REPORT)
    Call<Void> postForComment(@Path(PARAM_ID) String id, @Body Report report);
}
