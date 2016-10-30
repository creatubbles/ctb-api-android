package com.creatubbles.api.model.image_manipulation;

import android.support.annotation.NonNull;

/**
 * @author Pawel Szymanski
 */
public class Cropping {
    private final Integer x;
    private final Integer y;
    private final Integer width;
    private final Integer height;

    /**
     * @param x      the x position of the top left corner of the cropping
     * @param y      the x position of the top left corner of the cropping
     * @param width  the width of the cropping
     * @param height the height of the cropping
     */
    public Cropping(@NonNull Integer x, @NonNull Integer y, @NonNull Integer width, @NonNull Integer height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Cropping{" +
                "x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
