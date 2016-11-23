package com.creatubbles.api.repository

import com.creatubbles.api.CreatubblesApi
import com.creatubbles.api.TestUtils
import com.creatubbles.api.model.auth.AccessToken
import spock.lang.Specification

/**
 * @author Pawel Szymanski
 */
class ContentRepositoryBuilderTest extends Specification {
    void setup() {
        TestUtils.initializeCreatubblesApi();
    }

    void cleanup() {
        TestUtils.resetModule();
        CreatubblesApi.reset();
    }

    def "should fail to create without access token"() {
        when:
        new ContentRepositoryBuilder(null)
        then:
        thrown(NullPointerException)
    }

    def "should create repository instance"() {
        given:
        def builder = new ContentRepositoryBuilder(anyToken())
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
