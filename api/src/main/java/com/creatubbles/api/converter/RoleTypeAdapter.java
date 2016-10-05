package com.creatubbles.api.converter;

import com.creatubbles.api.model.user.Role;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;


public class RoleTypeAdapter extends TypeAdapter<Role> {
    @Override
    public void write(JsonWriter out, Role value) throws IOException {
        if (value == null) {
            out.nullValue();
            return;
        }

        out.value(value.getRoleName());
    }

    @Override
    public Role read(JsonReader in) throws IOException {
        return Role.fromName(in.nextString());
    }
}
