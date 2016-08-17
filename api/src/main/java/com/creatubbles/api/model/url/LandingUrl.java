
package com.creatubbles.api.model.url;

import com.google.gson.annotations.SerializedName;

public class LandingUrl {

    @SerializedName("data")
    private Data data;

    public Data getData() {
        return data;
    }

}
