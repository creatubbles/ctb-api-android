package com.creatubbles.api.exception;

/**
 * Created by mariuszostapowicz on 08.03.2016.
 */
public class Error {
    private Integer status;
    private String code;
    private String source;
    private String title;
    private String detail;

    public Integer getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public String getSource() {
        return source;
    }

    public String getTitle() {
        return title;
    }

    public String getDetail() {
        return detail;
    }

}
