package com.creatubbles.api.response;

import com.creatubbles.api.model.AuthToken;
import com.creatubbles.api.model.auth.AccessToken;
import com.creatubbles.api.model.auth.ApplicationAccessToken;
import com.creatubbles.api.model.auth.UserAccessToken;
import com.creatubbles.api.service.GrantType;
import com.fasterxml.jackson.databind.ObjectMapper;

import retrofit2.Response;

/**
 * @author Pawel Szymanski
 */
public class AuthResponseMapper<C extends AccessToken> extends BaseResponseMapper<AuthToken, C> {

    private final GrantType grantType;

    public AuthResponseMapper(ObjectMapper objectMapper, GrantType grantType, ResponseCallback<C> responseCallback) {
        super(objectMapper, responseCallback);
        this.grantType = grantType;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected C processResponse(Response<AuthToken> response) {
        AuthToken authToken = response.body();
        String token = authToken.getAccessToken();
        String type = authToken.getTokenType();
        switch (grantType) {
            case PASSWORD:
            case USER_SWITCH:
                return (C) new UserAccessToken(token, type);
            case CLIENT_CREDENTIALS:
                return (C) new ApplicationAccessToken(token, type);
        }
        throw new IllegalStateException("Unknown grant type!");
    }
}
