package com.creatubbles.api.repository

import com.creatubbles.api.CreatubblesApi
import com.creatubbles.api.TestUtils
import spock.lang.Specification

/**
 * @author Pawel Szymanski
 */
class UploadRepositoryBuilderTest extends Specification {

    void setup() {
        TestUtils.initializeCreatubblesApi();
    }

    void cleanup() {
        TestUtils.resetModule();
        CreatubblesApi.reset();
    }

    def "should create repository instance"() {
        given:
        def builder = new UploadRepositoryBuilder()
        when:
        def repository = builder.build()
        then:
        noExceptionThrown()
        repository != null
    }
}
