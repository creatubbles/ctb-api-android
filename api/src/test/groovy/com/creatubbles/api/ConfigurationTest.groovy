package com.creatubbles.api

import android.app.Application
import com.creatubbles.api.exception.InvalidParametersException
import com.creatubbles.api.interceptor.ConsoleLogInterceptor
import okhttp3.logging.HttpLoggingInterceptor
import spock.lang.Specification
import spock.lang.Unroll

import static com.creatubbles.api.Configuration.*

/**
 * @author Pawel Szymanski
 */
class ConfigurationTest extends Specification {

    @Unroll
    def "should fail to create when missing required param: #message"() {
        given:
        def builder = new Configuration.Builder()
                .application(application)
                .baseUrl(baseUrl)
                .clientId(clientId)
                .clientSecret(clientSecret)
                .interceptor(ConsoleLogInterceptor.forLevel(HttpLoggingInterceptor.Level.BODY));
        when:
        builder.build();
        then:
        def e = thrown InvalidParametersException
        e.message == message
        where:
        baseUrl  | clientId    | clientSecret | application      | message
        null     | anyString() | anyString()  | anyApplication() | INVALID_BASE_URL_MESSAGE
        anyUrl() | null        | anyString()  | anyApplication() | INVALID_CLIENT_ID_MESSAGE
        anyUrl() | anyString() | null         | anyApplication() | INVALID_CLIENT_SECRET_MESSAGE
        anyUrl() | anyString() | anyString()  | null             | INVALID_APPLICATION_CONTEXT_MESSAGE

    }

    def "should create configuration when all params are valid"() {
        given:
        def builder = new Configuration.Builder()
                .application(anyApplication())
                .baseUrl(anyUrl())
                .clientId(anyString())
                .clientSecret(anyString())
                .interceptor(ConsoleLogInterceptor.forLevel(HttpLoggingInterceptor.Level.BODY));
        when:
        def configuration = builder.build();
        then:
        notThrown(InvalidParametersException)
        configuration != null
    }

    private anyApplication() {
        Mock(Application)
    }

    private String anyString() {
        "non-empty"
    }

    private String anyUrl() {
        "http://url.com"
    }
}