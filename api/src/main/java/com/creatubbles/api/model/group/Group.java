package com.creatubbles.api.model.group;

import com.google.gson.annotations.SerializedName;

public class Group {

    @SerializedName("id")
    private Integer id;

    @SerializedName("name")
    private String name;

    @SerializedName("taggings_count")
    private Integer taggingsCount;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getTaggingsCount() {
        return taggingsCount;
    }
}
