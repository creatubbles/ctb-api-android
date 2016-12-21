package com.creatubbles.api.model.image_manipulation;

/**
 * @author Pawel Szymanski
 */
public class Cropping {
    private final int x;
    private final int y;
    private final int width;
    private final int height;

    /**
     * @param x      the x position of the top left corner of the cropping
     * @param y      the x position of the top left corner of the cropping
     * @param width  the width of the cropping
     * @param height the height of the cropping
     */
    public Cropping(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
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
