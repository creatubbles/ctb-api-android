package com.creatubbles.api.model.image_manipulation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author Pawel Szymanski
 */
public enum Rotation {
    ROTATION_0(0),
    ROTATION_90(90),
    ROTATION_180(180),
    ROTATION_270(270);


    private int degrees;

    @JsonCreator
    Rotation(int degrees) {
        this.degrees = degrees;
    }

    @JsonValue
    public int getDegrees() {
        return degrees;
    }
}
