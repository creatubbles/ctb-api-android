package com.creatubbles.api.repository

import com.creatubbles.api.CreatubblesApi
import com.creatubbles.api.TestUtils
import com.creatubbles.api.model.auth.AccessToken
import spock.lang.Specification

class PartnerApplicationRepositoryBuilderTest extends Specification {

    void setup() {
        TestUtils.initializeCreatubblesApi()
    }

    void cleanup() {
        TestUtils.resetModule()
        CreatubblesApi.reset()
    }

    def "shouldn't create repository without access token"() {
        when:
        new PartnerApplicationRepositoryBuilder(null)

        then:
        thrown(NullPointerException)
    }

    def "should create repository with AuthToken"() {
        given:
        def builder = new PartnerApplicationRepositoryBuilder(anyToken())

        when:
        def repository = builder.build()

        then:
        noExceptionThrown()
        repository != null
    }

    def anyToken() {
        Mock(AccessToken)
    }

}