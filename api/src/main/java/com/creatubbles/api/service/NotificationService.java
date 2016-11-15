package com.creatubbles.api.service;

import com.creatubbles.api.EndPoints;
import com.creatubbles.api.model.notification.Notification;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author Pawel Szymanski
 */
public interface NotificationService {

    String PARAM_PAGE = "page";
    String PARAM_FILTER = "filter";
    String PARAM_ID = "id";

    @GET(EndPoints.NOTIFICATIONS)
    Call<JSONAPIDocument<List<Notification>>> getNotifications(@Query(PARAM_PAGE) Integer page,
                                                               @Query(PARAM_FILTER) String filter);

    @POST(EndPoints.NOTIFICATIONS + "/{" + PARAM_ID + "}/read")
    Call<Void> postReadNotification(@Path(PARAM_ID) String id);

    @PUT(EndPoints.NOTIFICATIONS + "/view_tracker")
    Call<Void> putLastViewedAt();
}
