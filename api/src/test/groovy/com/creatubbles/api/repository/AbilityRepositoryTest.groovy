package com.creatubbles.api.repository

import com.creatubbles.api.model.ObjectType
import com.creatubbles.api.model.Operation
import com.creatubbles.api.service.AbilityService
import com.fasterxml.jackson.databind.ObjectMapper
import retrofit2.Call
import spock.lang.Specification

/**
 * Created by Janek on 04.11.2016.
 */
class AbilityRepositoryTest extends Specification {

    def service = Mock(AbilityService)
    def repository = new AbilityRepositoryImpl(Mock(ObjectMapper), service)
    def objectType
    def operation

    def "should call get ability on service for given object"() {
        when:
        repository.getSpecitfic(ObjectType.USER, anyId(), Operation.EDIT, anyCallback())
        then:
        service.getSpecific(_) >> anyCall()
        where:
        objectType << [ObjectType.USER, ObjectType.BUBBLE, ObjectType.COMMENT,
                       ObjectType.ACCOUNT, ObjectType.CREATION, ObjectType.GALLERY]
        operation << [Operation.EDIT, Operation.DESTROY, Operation.REPORT,
                      Operation.SHARE, Operation.SEE_REFLECTION_TEXT, Operation.EDIT]

    }


    private anyCallback() {
        null
    }

    private anyId() {
        ""
    }

    private anyCall() {
        Mock(Call)
    }

}