package com.creatubbles.api.service;

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


    String res;

    LandingUrlType(String res) {
        this.res = res;
    }

    public String getRes() {
        return res;
    }
}
