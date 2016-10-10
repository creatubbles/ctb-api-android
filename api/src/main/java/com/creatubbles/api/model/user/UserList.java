
package com.creatubbles.api.model.user;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class UserList {

    @SerializedName("data")
    private List<Data> data = new ArrayList<Data>();

    @SerializedName("links")
    private Links links;

    @SerializedName("meta")
    private Meta meta;

    public List<Data> getData() {
        return data;
    }

    public Links getLinks() {
        return links;
    }

    public Meta getMeta() {
        return meta;
    }

}
