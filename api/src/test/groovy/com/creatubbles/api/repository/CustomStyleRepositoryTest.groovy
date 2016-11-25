package com.creatubbles.api.repository

import com.creatubbles.api.model.user.custom_style.CustomStyle
import com.creatubbles.api.service.CustomStyleService
import com.fasterxml.jackson.databind.ObjectMapper
import retrofit2.Call
import spock.lang.Specification


/**
 * @author Pawel Szymanski
 */
class CustomStyleRepositoryTest extends Specification {
    def service = Mock(CustomStyleService)
    def repository = new CustomStyleRepositoryImpl(Mock(ObjectMapper), service)

    def "should call get custom style when obtaining custom style by user id"() {
        when:
        repository.getCustomStyle(anyId(), anyCallback());
        then:
        service.getCustomStyle(_) >> anyCall()
    }

    def "should call update custom style when updating custom style"() {
        when:
        repository.updateCustomStyle(anyId(), anyCustomStyle(), anyCallback());
        then:
        service.updateCustomStyle(_, _) >> anyCall()
    }

    private CustomStyle anyCustomStyle() {
        Mock(CustomStyle)
    }

    private Call anyCall() {
        Mock(Call)
    }

    private void anyCallback() {
        null
    }

    private String anyId() {
        ""
    }
}