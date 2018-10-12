package com.creatubbles.api.repository

import com.creatubbles.api.CreatubblesApi
import com.creatubbles.api.TestUtils
import com.creatubbles.api.model.auth.AccessToken
import spock.lang.Specification
/**
 * Created by Janek on 03.11.2016.
 */
class AvatarRepositoryBuilderTest extends Specification {

    void setup() {
        TestUtils.initializeCreatubblesApi()
    }

    void cleanup() {
        TestUtils.resetModule()
        CreatubblesApi.reset()
    }

    def "shouldn't create repository without AuthToken"() {
        when:
        new AvatarRepositoryBuilder(null)

        then:
        thrown(NullPointerException)
    }

    def "should create repository with AuthToken"() {
        given:
        def builder = new AvatarRepositoryBuilder(anyToken())

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