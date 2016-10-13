package com.creatubbles.api.model.group;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Group {

    private Integer id;

    private String name;

    @JsonProperty("taggings_count")
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
