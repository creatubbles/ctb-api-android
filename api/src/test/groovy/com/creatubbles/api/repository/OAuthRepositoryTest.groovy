package com.creatubbles.api.repository

import com.creatubbles.api.model.auth.UserAccessToken
import com.creatubbles.api.service.GrantType
import com.creatubbles.api.service.OAuthService
import com.fasterxml.jackson.databind.ObjectMapper
import retrofit2.Call
import spock.lang.Specification

/**
 * @author Pawel Szymanski
 */
class OAuthRepositoryTest extends Specification {

    def service = Mock(OAuthService)
    def repository = new OAuthRepositoryImpl(Mock(ObjectMapper), service)

    def "should call get auth token when authorize without credentials"() {
        when:
        repository.authorize(anyCallback())
        then:
        service.getAccessToken(_, _, GrantType.CLIENT_CREDENTIALS) >> anyCall()
    }

    def "should call get auth token when authorize with login and password"() {
        when:
        repository.authorize(anyString(), anyString(), anyCallback())
        then:
        service.getAccessToken(_, _, GrantType.PASSWORD, _, _) >> anyCall()
    }

    def "should call switch user with current token when switching"() {
        given:
        def currentToken = "asd"
        def currentUserAccessToken = Mock(UserAccessToken) {
            getToken() >> currentToken
        }
        when:
        repository.switchUser(currentUserAccessToken, anyString(), anyString(), anyCallback())
        then:
        service.switchUser(currentToken, GrantType.USER_SWITCH, _, _) >> anyCall()
    }

    private String anyString() {
        ""
    }

    private Call anyCall() {
        Mock(Call)
    }

    private anyCallback() {
        null
    }
}