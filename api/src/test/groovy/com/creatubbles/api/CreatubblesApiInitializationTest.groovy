package com.creatubbles.api

import android.app.Application
import com.creatubbles.api.exception.InitializationException
import spock.lang.Specification


/**
 * @author Pawel Szymanski
 */
class CreatubblesApiInitializationTest extends Specification {


    void cleanup() {
        TestUtils.resetModule();
        CreatubblesApi.reset();
    }

    def "testThrowsWhenPassedNullParameters"() {
        when:
        CreatubblesApi.initialize(null);
        then:
        thrown(NullPointerException)
    }

    def "testThrowsWhenTryToInitializeMoreThanOnce"() {
        given:
        CreatubblesApi.initialize(anyConfiguration());
        when:
        CreatubblesApi.initialize(anyConfiguration());
        then:
        thrown(InitializationException)
    }

    def "testCanInitializeCreatubblesApiAfterReset"() {
        given:
        CreatubblesApi.initialize(anyConfiguration());
        CreatubblesApi.reset();
        when:
        CreatubblesApi.initialize(anyConfiguration());
        then:
        notThrown(InitializationException)
    }

    def anyConfiguration() {
        new Configuration.Builder()
                .clientSecret("secret")
                .clientId("id")
                .baseUrl("http://url.com")
                .application(Mock(Application))
                .build()
    }
}