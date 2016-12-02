package com.creatubbles.api.model.landing_url;

import android.support.annotation.NonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by Janek on 05.08.2016.
 */
public enum LandingUrlType {

    ABOUT_US("ctb-about_us"),
    TERMS_OF_USE("ctb-terms_of_use"),
    PRIVACY_POLICY("ctb-privacy_policy"),
    COMMON_REGISTRATION("ctb-registration"),
    COMMON_FORGOT_PASSWORD("ctb-forgot_password"),
    EXPLORE("ctb-explore"),
    USER_PROFILE("ctb-user_profile"),
    USER_ACCOUNT_DASHBOARD("ctb-account_dashboard"),
    USER_UPLOAD_GUIDELINES("ctb-upload_guidelines");


    private String res;

    @JsonCreator
    LandingUrlType(String res) {
        this.res = res;
    }

    @JsonValue
    @NonNull
    public String getRes() {
        return res;
    }
}
