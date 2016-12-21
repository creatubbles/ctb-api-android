package com.creatubbles.api.service;

import com.creatubbles.api.EndPoints;
import com.creatubbles.api.model.bubble.Bubble;
import com.creatubbles.api.model.bubble.BubbleColor;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author Pawel Szymanski
 */
public interface BubbleService {

    String PARAM_ID = "id";
    String PATH_ID = "/{" + PARAM_ID + "}";
    String PATH_ID_BUBBLE = PATH_ID + "/bubbles";
    String PARAM_PAGE = "page";

    @GET(EndPoints.CREATIONS + PATH_ID_BUBBLE)
    Call<JSONAPIDocument<List<Bubble>>> getForCreation(@Path(PARAM_ID) String creationId, @Query(PARAM_PAGE) Integer page);

    @GET(EndPoints.GALLERIES + PATH_ID_BUBBLE)
    Call<JSONAPIDocument<List<Bubble>>> getForGallery(@Path(PARAM_ID) String galleryId, @Query(PARAM_PAGE) Integer page);

    @GET(EndPoints.USERS + PATH_ID_BUBBLE)
    Call<JSONAPIDocument<List<Bubble>>> getForUser(@Path(PARAM_ID) String userId, @Query(PARAM_PAGE) Integer page);

    @POST(EndPoints.CREATIONS + PATH_ID_BUBBLE)
    Call<JSONAPIDocument<Bubble>> postForCreation(@Path(PARAM_ID) String creationId, @Body Bubble bubble);

    @POST(EndPoints.GALLERIES + PATH_ID_BUBBLE)
    Call<JSONAPIDocument<Bubble>> postForGallery(@Path(PARAM_ID) String galleryId, @Body Bubble bubble);

    @POST(EndPoints.USERS + PATH_ID_BUBBLE)
    Call<JSONAPIDocument<Bubble>> postForUser(@Path(PARAM_ID) String userId, @Body Bubble bubble);

    @PUT(EndPoints.BUBBLES + PATH_ID)
    Call<Void> putBubble(@Path(PARAM_ID) String bubbleId, @Body Bubble bubble);

    @DELETE(EndPoints.BUBBLES + PATH_ID)
    Call<Void> deleteBubble(@Path(PARAM_ID) String bubbleId);

    @GET(EndPoints.BUBBLES + "/colors")
    Call<JSONAPIDocument<List<BubbleColor>>> getColors();
}
