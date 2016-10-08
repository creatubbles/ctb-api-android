package com.creatubbles.api.converter;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class GsonUTCDateAdapterTest {

    private GsonUTCDateAdapter target;
    private String dateString = "2016-10-08T23:59:59.000Z";
    private long timestamp = 1475971199000L; // this is 2016-10-08T23:59:59.000Z in milliseconds (UTC)

    @Before
    public void setUp() throws Exception {
        target = new GsonUTCDateAdapter();
    }

    @Test
    public void deserialize() throws Exception {
        String jsonDateString = "{\"key\":\"" + dateString + "\"}";
        JsonObject jsonObject = new JsonParser().parse(jsonDateString).getAsJsonObject();

        Date deserializedDate = target.deserialize(jsonObject.get("key"), null, null);

        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTimeInMillis(timestamp);
        // we check if target treated date string as date in UTC and returned Date in local timezone
        assertEquals(calendar.getTime(), deserializedDate); // calendar.getTime() should return date in local timezone
    }

    @Test
    public void serialize() throws Exception {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTimeInMillis(timestamp);

        // we pass the date in local timezone
        JsonElement jsonElement = target.serialize(calendar.getTime(), null, null);

        // whe should get formatted date in UTC
        assertEquals(dateString, jsonElement.getAsString());

    }

}