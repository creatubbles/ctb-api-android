package com.creatubbles.api.repository

import com.creatubbles.api.service.PartnerApplicationService
import com.fasterxml.jackson.databind.ObjectMapper
import retrofit2.Call
import spock.lang.Specification

/**
 * @author Pawel Szymanski
 */
class PartnerApplicationRepositoryTest extends Specification {
    def service = Mock(PartnerApplicationService)
    def repository = new PartnerApplicationRepositoryImpl(service, Mock(ObjectMapper))

    def "should call get list when searching"() {
        when:
        repository.search(anyPage(), anyQuery(), anyCallback())
        then:
        service.getList(_, _) >> anyCall()
    }

    def "should call get by id when getting by id"() {
        when:
        repository.getById(anyId(), anyCallback())
        then:
        service.getById(_) >> anyCall()
    }

    def anyPage() {
        null
    }

    def anyQuery() {
        "q"
    }

    def anyCallback() {
        null
    }

    def anyCall() {
        Mock(Call)
    }

    def anyId() {
        ""
    }
}
