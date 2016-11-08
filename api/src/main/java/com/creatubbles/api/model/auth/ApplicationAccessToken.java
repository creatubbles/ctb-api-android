package com.creatubbles.api.model.auth;

/**
 * @author Pawel Szymanski
 */
public class ApplicationAccessToken extends AccessToken {
    public ApplicationAccessToken(String token, String type) {
        super(token, type);
    }
}
