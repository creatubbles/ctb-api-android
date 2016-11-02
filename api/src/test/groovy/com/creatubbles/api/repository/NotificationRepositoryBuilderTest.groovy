package com.creatubbles.api.repository

import com.creatubbles.api.CreatubblesApi
import com.creatubbles.api.TestUtils
import com.creatubbles.api.model.AuthToken
import spock.lang.Specification

/**
 * @author Pawel Szymanski
 */
class NotificationRepositoryBuilderTest extends Specification {

    void setup() {
        TestUtils.initializeCreatubblesApi();
    }

    void cleanup() {
        TestUtils.resetModule();
        CreatubblesApi.reset();
    }

    def "should fail to create without auth token"() {
        when:
        new NotificationRepositoryBuilder(null)
        then:
        thrown(NullPointerException)
    }

    def "should create repository instance"() {
        given:
        def builder = new NotificationRepositoryBuilder(anyToken())
        when:
        def repository = builder.build()
        then:
        noExceptionThrown()
        repository != null
    }

    def anyToken() {
        Mock(AuthToken)
    }
}
