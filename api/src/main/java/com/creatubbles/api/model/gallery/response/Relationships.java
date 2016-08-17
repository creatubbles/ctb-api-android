package com.creatubbles.api.model.gallery.response;

import com.google.gson.annotations.SerializedName;

public class Relationships {

    @SerializedName("owner")
    private Owner owner;

    @SerializedName("partner_application")
    private PartnerApplication partnerApplication;

    public Owner getOwner() {
        return owner;
    }

    public PartnerApplication getPartnerApplication() {
        return partnerApplication;
    }
}
