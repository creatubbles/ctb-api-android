package com.creatubbles.api.repository

import com.creatubbles.api.CreatubblesApi
import com.creatubbles.api.TestUtils
import spock.lang.Specification

class OAuthRepositoryBuilderTest extends Specification {


    void setup() {
        TestUtils.initializeCreatubblesApi();
    }

    void cleanup() {
        TestUtils.resetModule();
        CreatubblesApi.reset();
    }

    def "should create repository with access token"() {
        given:
        def builder = new OAuthRepositoryBuilder();

        when:
        def repository = builder.build()

        then:
        noExceptionThrown()
        repository != null
    }

}