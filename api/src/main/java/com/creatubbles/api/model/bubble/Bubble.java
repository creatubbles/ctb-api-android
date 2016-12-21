package com.creatubbles.api.model.bubble;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.exception.InvalidParametersException;
import com.creatubbles.api.model.creation.Creation;
import com.creatubbles.api.model.gallery.Gallery;
import com.creatubbles.api.model.user.User;
import com.creatubbles.api.response.ResponseCallback;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;

import java.util.Date;

/**
 * Class representing a bubble on either creation, gallery or user.
 *
 * @author Pawel Szymanski
 */
@Type("bubbles")
public class Bubble {
    @Id
    private String id;

    @JsonProperty("x_pos")
    private Double xPos;

    @JsonProperty("y_pos")
    private Double yPos;

    @JsonProperty("random_pos")
    private boolean randomPos;

    private String color;

    @JsonProperty("color_hex")
    private String colorHex;

    @JsonProperty("created_at")
    private Date createdAt;

    @Relationship("bubbler")
    private User bubbler;

    @Relationship("creation")
    private Creation creation;

    @Relationship("gallery")
    private Gallery gallery;

    @Relationship("user")
    private User user;

    @JsonCreator
    public Bubble() {
    }

    @SuppressWarnings("WeakerAccess")
    Bubble(Double xPos, Double yPos, String color) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.color = color;
    }

    @NonNull
    public String getId() {
        return id;
    }

    /**
     * @return bubble X position, 0 < xPos < 1, {@code null} if bubble is not on Creation
     */
    @Nullable
    public Double getXPos() {
        return xPos;
    }

    /**
     * @return bubble Y position, 0 < yPos < 1, {@code null} if bubble is not on Creation
     */
    @Nullable
    public Double getYPos() {
        return yPos;
    }

    /**
     * @return {@code null} if bubble is not on Creation
     */
    public boolean isRandomPos() {
        return randomPos;
    }

    /**
     * @return the name of the color of this bubble, {@code null} if bubble is not on Creation
     */
    @Nullable
    public String getColor() {
        return color;
    }

    /**
     * @return hex value of the color of this bubble, {@code null} if bubble is not on Creation
     */
    @Nullable
    public String getColorHex() {
        return colorHex;
    }

    @NonNull
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @return object representing User who created this bubble
     */
    @NonNull
    public User getBubbler() {
        return bubbler;
    }

    /**
     * @return {@code null} if bubble is not on Creation
     */
    @Nullable
    public Creation getCreation() {
        return creation;
    }

    /**
     * @return {@code null} if bubble is not on Gallery
     */
    @Nullable
    public Gallery getGallery() {
        return gallery;
    }

    /**
     * @return {@code null} if bubble is not on User
     */
    @Nullable
    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Bubble{" +
                "id='" + id + '\'' +
                ", xPos=" + xPos +
                ", yPos=" + yPos +
                ", randomPos=" + randomPos +
                ", color='" + color + '\'' +
                ", colorHex='" + colorHex + '\'' +
                ", createdAt=" + createdAt +
                ", bubbler=" + bubbler +
                ", creation=" + creation +
                ", gallery=" + gallery +
                ", user=" + user +
                '}';
    }

    public static class Builder {
        private Double xPos;
        private Double yPos;
        private String color;

        public Builder() {
        }

        /**
         * Set custom bubble position. This is only used for bubbles on Creations.
         *
         * @param xPos bubble X position, 0 < xPos < 1
         * @param yPos bubble Y position, 0 < yPos < 1
         * @throws InvalidParametersException when either of params is smaller than 0 or greater than 1
         */
        @NonNull
        public Builder setPosition(double xPos, double yPos) {
            if (xPos < 0.0D || xPos > 1.0D) {
                throw new InvalidParametersException("xPos has to be a number between 0 and 1");
            }
            if (yPos < 0.0D || yPos > 1.0D) {
                throw new InvalidParametersException("yPos has to be a number between 0 and 1");
            }
            this.xPos = xPos;
            this.yPos = yPos;
            return this;
        }

        /**
         * Set color of this creation. To obtain all available colors use {@link com.creatubbles.api.repository.BubbleRepository#getColors(ResponseCallback)}.
         * This is only used for bubbles on Creations.
         *
         * @param color the name of the color taken from {@link BubbleColor#getColor()}
         */
        @NonNull
        public Builder setColor(@NonNull String color) {
            this.color = color;
            return this;
        }

        @NonNull
        public Bubble build() {
            return new Bubble(xPos, yPos, color);
        }
    }
}
