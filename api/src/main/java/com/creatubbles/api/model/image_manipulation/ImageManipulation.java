package com.creatubbles.api.model.image_manipulation;

import com.creatubbles.api.exception.InvalidParametersException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Type;

/**
 * Class representing manipulations made to creation's image.
 * To create and instance use {@link Builder}.
 *
 * @author Pawel Szymanski
 */
@Type("image_manipulations")
public class ImageManipulation {
    @Id
    private String id;

    private Rotation rotation;

    private Cropping cropping;

    @JsonCreator
    public ImageManipulation() {
    }

    @SuppressWarnings("WeakerAccess")
    ImageManipulation(Rotation rotation, Cropping cropping) {
        this.rotation = rotation;
        this.cropping = cropping;
    }

    public Rotation getRotation() {
        return rotation;
    }

    public Cropping getCropping() {
        return cropping;
    }

    public static class Builder {
        private Rotation rotation;
        private Cropping cropping;

        public Builder() {
        }

        public Builder setRotation(Rotation rotation) {
            this.rotation = rotation;
            return this;
        }


        public Builder setCropping(Cropping cropping) {
            this.cropping = cropping;
            return this;
        }

        public ImageManipulation build() {
            if (rotation == null && cropping == null) {
                throw new InvalidParametersException("Cannot create ImageManipulation. You should set either rotation, cropping or both.");
            }
            return new ImageManipulation(rotation, cropping);
        }
    }

    @Override
    public String toString() {
        return "ImageManipulation{" +
                "id='" + id + '\'' +
                ", rotation=" + rotation +
                ", cropping=" + cropping +
                '}';
    }
}
