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
    public static final String GALLERY_SUBMISSIONS = "gallery_submissions";
    public static final String CONTENTS = "contents";
    public static final String BUBBLES = "bubbles";
    public static final String COMMENTS = "comments";
    public static final String NOTIFICATIONS = "notifications";
    public static final String GROUPS = "groups";
    public static final String PARTNER_APPLICATIONS = "partner_applications";
    public static final String SCHOOLS = "schools";
    public static final String AVATAR_SUGGESTIONS = "avatar_suggestions";
    public static final String SWITCH_USERS = "user_switch/users";

    public static boolean SET_STAGING = false;
}
