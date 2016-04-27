package com.creatubbles.api;

/**
 * Created by Janek on 08.02.2016.
 */
public enum ContentType {

    URL_ENCODED("application/x-www-form-urlencoded;charset=UTF-8"), VND_JSON("application/vnd" +
            ".api+json"), JSON("application/json"), PNG("png"), JPG("jpg"), JPEG
            ("jpeg"), H264("h264"), MPEG4("mpeg4"), WMV("wmv"), WEBM
            ("webm"), FLV("flv"), OGG("ogg"), OGV("ogv"), MP4
            ("mp4"), M4V("m4v"), F4V("f4v"), MOV("mov"), ZIP("zip");
    String res;

    ContentType(String res) {
        this.res = res;
    }

    public String getRes() {
        return res;
    }

}


