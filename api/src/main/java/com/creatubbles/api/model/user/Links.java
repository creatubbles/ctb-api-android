
package com.creatubbles.api.model.user;

import com.google.gson.annotations.SerializedName;

public class Links {

    @SerializedName("self")
    private String self;

    @SerializedName("first")
    private String first;

    @SerializedName("last")
    private String last;


    public String getSelf() {
        return self;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }
}
