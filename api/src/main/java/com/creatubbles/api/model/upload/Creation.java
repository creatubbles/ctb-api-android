package com.creatubbles.api.model.upload;

import com.google.gson.annotations.SerializedName;

public class Creation {

    @SerializedName("data")
    private Data data;

    public Data getData() {
        return data;
    }


    public class Data {

        @SerializedName("id")
        private String id;

        @SerializedName("type")
        private String type;

        public String getId() {
            return id;
        }

        public String getType() {
            return type;
        }

    }

}
