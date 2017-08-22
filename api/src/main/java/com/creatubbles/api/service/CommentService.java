package com.creatubbles.api.service;

import com.creatubbles.api.EndPoints;
import com.creatubbles.api.model.comment.Comment;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


/**
 * @author Pawel Szymanski
 */
public interface CommentService {

    String PARAM_ID = "id";
    String PARAM_PAGE = "page";
    String PART_ID_COMMENTS = "/{" + PARAM_ID + "}/comments";
    String PATH_CREATION_COMMENTS = EndPoints.CREATIONS + PART_ID_COMMENTS;
    String PATH_GALLERY_COMMENTS = EndPoints.GALLERIES + PART_ID_COMMENTS;
    String PATH_USER_COMMENTS = EndPoints.USERS + PART_ID_COMMENTS;
    String PATH_APPROVE_COMMENT = EndPoints.COMMENTS + "/{" + PARAM_ID + "}/approval";

    @GET(PATH_CREATION_COMMENTS)
    Call<JSONAPIDocument<List<Comment>>> getForCreation(@Path(PARAM_ID) String creationId, @Query(PARAM_PAGE) Integer page);

    @GET(PATH_GALLERY_COMMENTS)
    Call<JSONAPIDocument<List<Comment>>> getForGallery(@Path(PARAM_ID) String galleryId, @Query(PARAM_PAGE) Integer page);

    @GET(PATH_USER_COMMENTS)
    Call<JSONAPIDocument<List<Comment>>> getForUser(@Path(PARAM_ID) String userId, @Query(PARAM_PAGE) Integer page);

    @POST(PATH_CREATION_COMMENTS)
    Call<JSONAPIDocument<Comment>> createForCreation(@Path(PARAM_ID) String creationId, @Body Comment comment);

    @POST(PATH_GALLERY_COMMENTS)
    Call<JSONAPIDocument<Comment>> createForGallery(@Path(PARAM_ID) String galleryId, @Body Comment comment);

    @POST(PATH_USER_COMMENTS)
    Call<JSONAPIDocument<Comment>> createForUser(@Path(PARAM_ID) String userId, @Body Comment comment);

    @POST(PATH_APPROVE_COMMENT)
    Call<Void> approve(@Path(PARAM_ID) String commentId);

    @DELETE(PATH_APPROVE_COMMENT)
    Call<Void> decline(@Path(PARAM_ID) String commentId);
}
