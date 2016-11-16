package com.creatubbles.api.repository

import com.creatubbles.api.service.ContentService
import com.fasterxml.jackson.databind.ObjectMapper
import retrofit2.Call
import spock.lang.Specification

/**
 * @author Pawel Szymanski
 */
class ContentRepositoryTest extends Specification {
    def service = Mock(ContentService)
    def repository = new ContentRepositoryImpl(Mock(ObjectMapper), service,)

    def "should call get contents when searching"() {
        when:
        repository.search(anyQuery(), anyPage(), anyCallback())
        then:
        service.getContents(_, _) >> anyCall()
    }

    def "should call get recent when obtaining recent"() {
        when:
        repository.getRecent(anyPage(), anyCallback())
        then:
        service.getRecent(_) >> anyCall()
    }

    def "should call get trending when obtaining trending"() {
        when:
        repository.getTrending(anyPage(), anyCallback())
        then:
        service.getTrending(_) >> anyCall()
    }

    def "should call get followed when obtaining followed"() {
        when:
        repository.getFollowed(anyPage(), anyCallback())
        then:
        service.getFollowed(_) >> anyCall()
    }

    def "should call get connected when obtaining connected"() {
        when:
        repository.getConnected(anyPage(), anyCallback())
        then:
        service.getConnected(_) >> anyCall()
    }

    def "should call get by user when obtaining from user"() {
        when:
        repository.getByUser(anyPage(), anyId(), anyCallback())
        then:
        service.getByUser(_, _) >> anyCall()
    }

    def "should call get bubbled by user when obtaining bubbled"() {
        when:
        repository.getBubbledByUser(anyPage(), anyId(), anyCallback())
        then:
        service.getBubbledByUser(_, _) >> anyCall()
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
