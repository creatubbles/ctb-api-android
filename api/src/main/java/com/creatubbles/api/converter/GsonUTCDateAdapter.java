package com.creatubbles.api.converter;

import android.support.annotation.NonNull;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * This is a custom adapter for Gson that allows us to serialize String dates from Json into Date object with proper time zone.
 */
public class GsonUTCDateAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {
    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    @Override
    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        DateFormat dateFormat = getDateFormat();
        try {
            return dateFormat.parse(json.getAsString());
        } catch (ParseException e) {
            throw new JsonParseException(e);
        }
    }

    @Override
    public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
        DateFormat dateFormat = getDateFormat();
        return new JsonPrimitive(dateFormat.format(src));
    }

    @NonNull
    private DateFormat getDateFormat() {
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT, Locale.US);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return dateFormat;
    }
}
