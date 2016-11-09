package com.creatubbles.api.model.auth;

/**
 * @author Pawel Szymanski
 */
public class UserAccessToken extends AccessToken {
    public UserAccessToken(String token, String type) {
        super(token, type);
    }
}
