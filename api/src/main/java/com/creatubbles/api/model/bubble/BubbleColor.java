package com.creatubbles.api.model.bubble;

import android.support.annotation.Nullable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Type;

/**
 * @author Pawel Szymanski
 */
@Type("bubble-colors")
public class BubbleColor {
    @Id
    private String id;
    private String color;

    @JsonProperty("color_hex")
    private String colorHex;

    /**
     * @return the name of this color
     */
    @Nullable
    public String getColor() {
        return color;
    }

    /**
     * @return hex value of this color
     */
    @Nullable
    public String getColorHex() {
        return colorHex;
    }

    @Override
    public String toString() {
        return "BubbleColor{" +
                "id='" + id + '\'' +
                ", color='" + color + '\'' +
                ", colorHex='" + colorHex + '\'' +
                '}';
    }
}
