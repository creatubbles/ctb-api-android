
package com.creatubbles.api.model.school;

import com.google.gson.annotations.SerializedName;

public class School {

    @SerializedName("data")
    private Data data;

    public Data getData() {
        return data;
    }
}
