package com.creatubbles.api.model.creation;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Creators {

    @SerializedName("data")
    private List<Datum> data = new ArrayList<Datum>();


    public List<Datum> getData() {
        return data;
    }
}
