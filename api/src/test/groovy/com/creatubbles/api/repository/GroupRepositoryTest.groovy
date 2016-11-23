package com.creatubbles.api.repository

import com.creatubbles.api.model.group.Group
import com.creatubbles.api.service.GroupService
import com.fasterxml.jackson.databind.ObjectMapper
import retrofit2.Call
import spock.lang.Specification

/**
 * @author Pawel Szymanski
 */
class GroupRepositoryTest extends Specification {
    def service = Mock(GroupService)
    def repository = new GroupRepositoryImpl(service, Mock(ObjectMapper))


    def "should call get groups when obtaining all groups"() {
        when:
        repository.getAll(anyCallback());
        then:
        service.getGroups() >> anyCall()
    }

    def "should call get group when obtaining group by id"() {
        when:
        repository.getById(anyId(), anyCallback());
        then:
        service.getGroup(_) >> anyCall()
    }

    def "should call post when creating group"() {
        when:
        repository.create(anyGroup(), anyCallback());
        then:
        service.postGroup(_) >> anyCall()
    }

    def "should call put when updating group"() {
        when:
        repository.update(anyId(), anyGroup(), anyCallback());
        then:
        service.putGroup(_, _) >> anyCall()
    }

    def "should call delete when deleting group"() {
        when:
        repository.delete(anyId(), anyCallback());
        then:
        service.deleteGroup(_) >> anyCall()
    }

    private String anyId() {
        return "";
    }

    private anyCallback() {
        return null;
    }

    private Group anyGroup() {
        return Mock(Group);
    }

    private anyCall() {
        Mock(Call)
    }
}