package com.creatubbles.api;

/**
 * Created by Janek on 05.02.2016.
 */
public class EndPoints {
    public static final String URL_BASE = "https://www.creatubbles.com/api/v2/";

    // TODO add your stagging server url
    public static String URL_BASE_STAGING = null;

    //API v2
    public static final String GALLERIES = "galleries";
    public static final String CREATORS = "creators";
    public static final String OAUTH_TOKEN = "oauth/token";
    public static final String USERS = "users";
    public static final String CREATIONS = "creations";
    public static final String CREATIONS_UPLOADS = "creations/{id}/uploads";
    public static final String PING_CREATIONS_UPLOADS = "uploads/{id}";
    public static final String LANDING_URLS = "landing_urls";

    public static boolean SET_STAGING = false;
}
