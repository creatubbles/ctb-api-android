package com.creatubbles.api.model.creation;

import com.google.gson.annotations.SerializedName;

public class Relationships {

    @SerializedName("user")
    private User user;

    @SerializedName("creators")
    private Creators creators;

    public User getUser() {
        return user;
    }

    public Creators getCreators() {
        return creators;
    }
}
