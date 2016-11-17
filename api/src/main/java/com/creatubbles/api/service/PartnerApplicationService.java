package com.creatubbles.api.service;

import com.creatubbles.api.EndPoints;
import com.creatubbles.api.model.partner_application.PartnerApplication;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author Pawel Szymanski
 */
public interface PartnerApplicationService {

    String PARAM_ID = "id";
    String PARAM_PAGE = "page";
    String PARAM_QUERY = "query";

    @GET(EndPoints.PARTNER_APPLICATIONS)
    Call<JSONAPIDocument<List<PartnerApplication>>> getList(@Query(PARAM_PAGE) Integer page,
                                                            @Query(PARAM_QUERY) String query);

    @GET(EndPoints.PARTNER_APPLICATIONS + "/{" + PARAM_ID + "}")
    Call<JSONAPIDocument<PartnerApplication>> getById(@Path(PARAM_ID) String id);

}
