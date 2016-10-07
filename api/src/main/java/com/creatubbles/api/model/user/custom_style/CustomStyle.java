
package com.creatubbles.api.model.user.custom_style;

import com.google.gson.annotations.SerializedName;

public class CustomStyle {

    @SerializedName("data")
    private Data data;

    public Data getData() {
        return data;
    }
}
