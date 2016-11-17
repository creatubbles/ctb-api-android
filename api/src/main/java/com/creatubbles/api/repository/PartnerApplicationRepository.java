package com.creatubbles.api.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.partner_application.PartnerApplication;
import com.creatubbles.api.response.ResponseCallback;

import java.util.List;

/**
 * @author Pawel Szymanski
 */
public interface PartnerApplicationRepository {

    void search(@Nullable Integer page, @NonNull String query,
                ResponseCallback<CreatubblesResponse<List<PartnerApplication>>> callback);

    void getById(@NonNull String partnerApplicationId,
                 ResponseCallback<CreatubblesResponse<PartnerApplication>> callback);
}
