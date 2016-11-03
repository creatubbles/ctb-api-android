package com.creatubbles.api.service;

import com.creatubbles.api.EndPoints;
import com.creatubbles.api.model.user.MultipleCreators;
import com.creatubbles.api.model.user.NewUser;
import com.creatubbles.api.model.user.User;
import com.creatubbles.api.model.user.UserFollowing;
import com.creatubbles.api.model.user.avatar.Avatar;
import com.creatubbles.api.model.user.avatar.AvatarSuggestion;
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

import static com.creatubbles.api.EndPoints.USER_AVATAR;

/**
 * Created by Janek on 05.02.2016.
 */
public interface UserService {

    String PARAM_ID = "id";
    String PARAM_PAGE = "page";
    String PATH_ID = "{" + PARAM_ID + "}";

    @GET(EndPoints.USERS + "/" + PATH_ID)
    Call<JSONAPIDocument<User>> getUserById(@Path(PARAM_ID) String id);

    @GET(EndPoints.USERS + "/" + PATH_ID + "/creators")
    Call<JSONAPIDocument<List<User>>> getCreators(@Path(PARAM_ID) String id, @Query(PARAM_PAGE) Integer page);

    @GET(EndPoints.USERS + "/" + PATH_ID + "/managers")
    Call<JSONAPIDocument<List<User>>> getManagers(@Path(PARAM_ID) String id, @Query(PARAM_PAGE) Integer page);

    @GET(EndPoints.USERS + "/" + PATH_ID + "/connected_users")
    Call<JSONAPIDocument<List<User>>> getConnections(@Path(PARAM_ID) String id, @Query(PARAM_PAGE) Integer page);

    @GET(EndPoints.USERS + "/" + PATH_ID + "/followed_users")
    Call<JSONAPIDocument<List<User>>> getFollowedUsers(@Path(PARAM_ID) String id, @Query(PARAM_PAGE) Integer page);

    @POST(EndPoints.CREATORS)
    Call<JSONAPIDocument<User>> createUser(@Body NewUser newUser);

    @GET(EndPoints.SWITCH_USERS)
    Call<JSONAPIDocument<List<User>>> getSwitchUsers(@Query(PARAM_PAGE) Integer page);

    @POST(EndPoints.CREATOR_BUILDER_JOBS)
    Call<JSONAPIDocument<MultipleCreators>> createMultipleCreators(@Body MultipleCreators request);

    @GET(EndPoints.GROUPS + "/" + PATH_ID + "/creators")
    Call<JSONAPIDocument<List<User>>> getCreatorsFromGroup(@Path(PARAM_ID) String groupId, @Query(PARAM_PAGE) Integer page);

    @POST(EndPoints.USERS + "/" + PATH_ID + "/following")
    Call<JSONAPIDocument<UserFollowing>> postFollowing(@Path(PARAM_ID) String userId);

    @DELETE(EndPoints.USERS + "/" + PATH_ID + "/following")
    Call<Void> deleteFollowing(@Path(PARAM_ID) String userId);

    @PUT(EndPoints.USERS + "/" + PATH_ID + "/" + USER_AVATAR)
    Call<JSONAPIDocument<Avatar>> updateAvatar(@Path(PARAM_ID) String userId, @Body Avatar body);

    @GET(EndPoints.AVATAR_SUGGESTIONS)
    Call<JSONAPIDocument<List<AvatarSuggestion>>> getSuggestedAvatars();

}
