package com.creatubbles.api.response

import com.fasterxml.jackson.databind.ObjectMapper
import okhttp3.MediaType
import okhttp3.ResponseBody
import org.mockito.stubbing.Answer
import retrofit2.Response
import spock.lang.Specification

import static org.mockito.Mockito.mock

/**
 * @author Pawel Szymanski
 */
class BaseResponseMapperTest extends Specification {

    def callback = Mock(ResponseCallback)
    def objectMapper = Mock(ObjectMapper)
    def mapper = new BaseResponseMapper(objectMapper, callback)

    def "should call on success when response is successful"() {
        given:
        def successfulResponse = anySuccessfulResponse();
        when:
        mapper.onResponse(anyCall(), successfulResponse)
        then:
        1 * callback.onSuccess(_)
    }

    def "shouldCallOnServerErrorWhenResponseIsNotSuccessful"() {
        given:
        def unsuccessfulResponse = anyUnsuccessfulResponse();
        when:
        mapper.onResponse(anyCall(), unsuccessfulResponse)
        then:
        1 * callback.onServerError(_)
    }

    def "shouldCallOnErrorWhenOnFailureIsCalled"() {
        when:
        mapper.onFailure(anyCall(), anyThrowable())
        then:
        1 * callback.onError(_)
    }

    def "shouldCallOnErrorWhenErrorParsingFailed"() {
        given:
        objectMapper._ >> { throw new IOException() }
        when:
        mapper.onResponse(anyCall(), anyUnsuccessfulResponse())
        then:
        1 * callback.onError(_)
    }


    private ObjectMapper givenMapperWithAnswer(Answer answer) {
        return mock(ObjectMapper.class, answer);
    }

    private Throwable anyThrowable() {
        return Mock(Throwable);
    }

    private Response<Object> anySuccessfulResponse() {
        return Response.success(null);
    }

    private Response<Object> anyUnsuccessfulResponse() {
        return Response.error(400, ResponseBody.create(MediaType.parse(""), new byte[0]));
    }

    private anyCall() {
        return null;
    }
}