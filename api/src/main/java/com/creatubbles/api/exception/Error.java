package com.creatubbles.api.exception;

import android.support.annotation.NonNull;

/**
 * Created by mariuszostapowicz on 08.03.2016.
 */
public class Error {
    private Integer status;
    private String code;
    private String title;
    private String detail;

    @NonNull
    public Integer getStatus() {
        return status;
    }

    @NonNull
    public String getCode() {
        return code;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    @NonNull
    public String getDetail() {
        return detail;
    }

    @Override
    public String toString() {
        return "Error{" +
                "status=" + status +
                ", code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
