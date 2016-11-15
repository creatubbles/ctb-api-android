package com.creatubbles.api;

/**
 * Created by Janek on 09.11.2016.
 */

public enum Locale {

    ENGLISH("en"), JAPANESE("ja"), ITALIAN("it");
    String res;

    Locale(String res) {
        this.res = res;
    }

    public String getRes() {
        return res;
    }
}
