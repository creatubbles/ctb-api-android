package com.creatubbles.api.converter;

import com.creatubbles.api.model.creation.ImageStatus;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;


public class ImageStatusTypeAdapter extends TypeAdapter<ImageStatus> {
    @Override
    public void write(JsonWriter out, ImageStatus value) throws IOException {
        if (value == null) {
            out.nullValue();
            return;
        }
        out.value(value.toInt());
    }

    @Override
    public ImageStatus read(JsonReader in) throws IOException {
        int imageStatusInt = in.nextInt();
        return ImageStatus.getStatus(imageStatusInt);
    }
}
