package com.creatubbles.api.repository

import com.creatubbles.api.CreatubblesApi
import com.creatubbles.api.TestUtils
import com.creatubbles.api.model.auth.UserAccessToken
import spock.lang.Specification

/**
 * Created by Janek on 04.11.2016.
 */
class AbilityRepositoryBuilderTest extends Specification {


    void setup() {
        TestUtils.initializeCreatubblesApi();
    }

    void cleanup() {
        TestUtils.resetModule();
        CreatubblesApi.reset();
    }

    def "should not create repository without access token"() {
        when:
        new AbilityRepositoryBuilder(null)

        then:
        thrown(NullPointerException)
    }

    def "should create repository with access token"() {
        given:
        def builder = new AbilityRepositoryBuilder(anyToken());

        when:
        def repository = builder.build()

        then:
        noExceptionThrown()
        repository != null
    }

    def anyToken() {
        Mock(UserAccessToken)
    }

}