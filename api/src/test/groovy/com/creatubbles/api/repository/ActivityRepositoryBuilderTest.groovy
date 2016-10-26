package com.creatubbles.api.repository

import com.creatubbles.api.CreatubblesApi
import com.creatubbles.api.TestUtils
import com.creatubbles.api.model.AuthToken
import spock.lang.Specification

/**
 * Created by mariuszostapowicz on 26.10.2016.
 */
class ActivityRepositoryBuilderTest extends Specification {

    void setup() {
        TestUtils.initializeCreatubblesApi();
    }

    void cleanup() {
        TestUtils.resetModule();
        CreatubblesApi.reset();
    }

    def "should not create repository without auth token"() {
        when:
        new ActivityRepositoryBuilder(null)

        then:
        thrown(NullPointerException)
    }

    def "should create repository with auth token"() {
        given:
        def builder = new ActivityRepositoryBuilder(anyToken());

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
