package com.creatubbles.api.request;

/**
 * Created by mariuszostapowicz on 09.03.2016.
 */
public enum Gender {
    FEMALE(0),
    MALE(1),
    EMPTY(-1);

    private final Integer gender;

    Gender(Integer gender) {
        this.gender = gender;
    }

    public Integer toInt() {
        return this.gender;
    }

    public static Gender getGender(Integer gender) {
        switch (gender) {
            case 0:
                return FEMALE;
            case 1:
                return MALE;
            default:
                return EMPTY;
        }
    }
}
