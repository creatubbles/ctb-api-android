package com.creatubbles.api.exception;

/**
 * Created by mariuszostapowicz on 08.03.2016.
 */
public class Error {
    String code;
    String title;
    String detail;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
