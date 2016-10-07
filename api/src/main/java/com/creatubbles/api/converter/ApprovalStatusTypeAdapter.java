package com.creatubbles.api.converter;

import com.creatubbles.api.model.creation.ApprovalStatus;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;


public class ApprovalStatusTypeAdapter extends TypeAdapter<ApprovalStatus> {
    @Override
    public void write(JsonWriter out, ApprovalStatus value) throws IOException {
        if (value == null) {
            out.nullValue();
            return;
        }
        out.value(value.getStatus());
    }

    @Override
    public ApprovalStatus read(JsonReader in) throws IOException {
        return ApprovalStatus.fromName(in.nextString());
    }
}
