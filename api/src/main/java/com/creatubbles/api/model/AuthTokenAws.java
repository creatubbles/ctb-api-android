package com.creatubbles.api.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Janek on 05.02.2016.
 */
public class AuthTokenAws {

    @SerializedName("session_token")
    private String sessionToken;

    @SerializedName("secret_access_key")
    private String secretAccessKey;

    @SerializedName("access_key_id")
    private String accessKeyId;

    public AuthTokenAws() {
    }

    public AuthTokenAws(String sessionToken, String secretAccessKey, String accessKeyId) {
        this.sessionToken = sessionToken;
        this.secretAccessKey = secretAccessKey;
        this.accessKeyId = accessKeyId;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public String getSecretAccessKey() {
        return secretAccessKey;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }
}
