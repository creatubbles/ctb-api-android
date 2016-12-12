package com.creatubbles.api.exception;

/**
 * Created by mariuszostapowicz on 08.03.2016.
 */
public class Error {
    private Integer status;
    private String code;
    private String title;
    private String detail;

    public Integer getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

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
