package com.creatubbles.api.service;

import com.creatubbles.api.EndPoints;
import com.creatubbles.api.model.group.Group;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * @author Pawel Szymanski
 */
public interface GroupService {

    String PARAM_ID = "id";
    String PATH_ID = "/{" + PARAM_ID + "}";

    @GET(EndPoints.GROUPS)
    Call<JSONAPIDocument<List<Group>>> getGroups();

    @GET(EndPoints.GROUPS + PATH_ID)
    Call<JSONAPIDocument<Group>> getGroup(@Path(PARAM_ID) String id);

    @POST(EndPoints.GROUPS)
    Call<JSONAPIDocument<Group>> postGroup(@Body Group group);

    @PUT(EndPoints.GROUPS + PATH_ID)
    Call<Void> putGroup(@Path(PARAM_ID) String groupId, @Body Group group);

    @DELETE(EndPoints.GROUPS + PATH_ID)
    Call<Void> deleteGroup(@Path(PARAM_ID) String groupId);
}
