
package com.creatubbles.api.model;

import com.creatubbles.api.model.creator.Datum;
import com.creatubbles.api.model.creator.Links;
import com.creatubbles.api.model.creator.Meta;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class UserListResponse {

    @SerializedName("data")
    public List<Datum> data = new ArrayList<Datum>();

    @SerializedName("links")
    public Links links;

    @SerializedName("meta")
    public Meta meta;

    public List<Datum> getData() {
        return data;
    }

    public Links getLinks() {
        return links;
    }

    public Meta getMeta() {
        return meta;
    }

}
