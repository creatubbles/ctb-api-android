package com.creatubbles.api

import com.creatubbles.api.exception.InvalidParametersException
import com.creatubbles.api.model.ObjectType
import com.creatubbles.api.model.Operation
import spock.lang.Specification

/**
 * Created by Janek on 08.11.2016.
 */
class AbilityOperationVerifierTest extends Specification {

    def objectType
    def operation

    def "should throw exception when null object passed"() {
        when:
        AbilityOperationVerifier.verify(objectType, operation)
        then:
        thrown InvalidParametersException
        where:
        objectType << [null, ObjectType.USER, null]
        operation << [null, null, Operation.EDIT]

    }

    def "should throw exception when passed invalid operation for creation"() {
        given:
        objectType = ObjectType.CREATION
        when:
        AbilityOperationVerifier.verify(objectType, operation)
        then:
        thrown InvalidParametersException
        where:
        operation << [Operation.SUBMIT_TO, Operation.SWITCH, Operation.SWITCH_WITHOUT_PASSWORD,
                      Operation.CUSTOMIZE, Operation.SHARE_FULLY, Operation.DECLINE,
                      Operation.APPROVE, Operation.DELETE, Operation.DESTROY]
    }

    def "should verify when passed valid operation for creation"() {
        given:
        objectType = ObjectType.CREATION
        when:
        AbilityOperationVerifier.verify(objectType, operation)
        then:
        noExceptionThrown()
        where:
        operation << [Operation.EDIT, Operation.REPORT, Operation.SEE_REFLECTION_TEXT,
                      Operation.SEE_REFLECTION_VIDEO, Operation.SHARE]
    }

    def "should throw exception when passed invalid operation for gallery"() {
        given:
        objectType = ObjectType.GALLERY
        when:
        AbilityOperationVerifier.verify(objectType, operation)
        then:
        thrown InvalidParametersException
        where:
        operation << [Operation.REPORT, Operation.SEE_REFLECTION_TEXT,
                      Operation.SEE_REFLECTION_VIDEO, Operation.SWITCH,
                      Operation.SWITCH_WITHOUT_PASSWORD, Operation.CUSTOMIZE,
                      Operation.SHARE_FULLY, Operation.DECLINE,
                      Operation.APPROVE, Operation.DELETE, Operation.DESTROY]
    }

    def "should verify when passed valid operation for gallery"() {
        given:
        objectType = ObjectType.GALLERY
        when:
        AbilityOperationVerifier.verify(objectType, operation)
        then:
        noExceptionThrown()
        where:
        operation << [Operation.EDIT, Operation.SHARE, Operation.SUBMIT_TO]
    }

    def "should throw exception when passed invalid operation for user"() {
        given:
        objectType = ObjectType.USER
        when:
        AbilityOperationVerifier.verify(objectType, operation)
        then:
        thrown InvalidParametersException
        where:
        operation << [Operation.REPORT, Operation.SEE_REFLECTION_TEXT,
                      Operation.SEE_REFLECTION_VIDEO, Operation.SUBMIT_TO,
                      Operation.SHARE_FULLY, Operation.DECLINE,
                      Operation.APPROVE, Operation.DELETE, Operation.DESTROY]
    }

    def "should verify when passed valid operation for user"() {
        given:
        objectType = ObjectType.USER
        when:
        AbilityOperationVerifier.verify(objectType, operation)
        then:
        noExceptionThrown()
        where:
        operation << [Operation.EDIT, Operation.SHARE, Operation.SWITCH,
                      Operation.SWITCH_WITHOUT_PASSWORD, Operation.CUSTOMIZE]
    }

    def "should throw exception when passed invalid operation for account"() {
        given:
        objectType = ObjectType.ACCOUNT
        when:
        AbilityOperationVerifier.verify(objectType, operation)
        then:
        thrown InvalidParametersException
        where:
        operation << [Operation.REPORT, Operation.SEE_REFLECTION_TEXT,
                      Operation.SEE_REFLECTION_VIDEO, Operation.SUBMIT_TO,
                      Operation.SWITCH_WITHOUT_PASSWORD, Operation.DECLINE,
                      Operation.APPROVE, Operation.DELETE, Operation.DESTROY]
    }

    def "should verify when passed valid operation for account"() {
        given:
        objectType = ObjectType.ACCOUNT
        when:
        AbilityOperationVerifier.verify(objectType, operation)
        then:
        noExceptionThrown()
        where:
        operation << [Operation.EDIT, Operation.SHARE, Operation.SWITCH,
                      Operation.CUSTOMIZE, Operation.SHARE_FULLY]
    }

    def "should throw exception when passed invalid operation for comment"() {
        given:
        objectType = ObjectType.COMMENT
        when:
        AbilityOperationVerifier.verify(objectType, operation)
        then:
        thrown InvalidParametersException
        where:
        operation << [Operation.SEE_REFLECTION_TEXT, Operation.SEE_REFLECTION_VIDEO,
                      Operation.SHARE, Operation.SUBMIT_TO, Operation.SWITCH,
                      Operation.SWITCH_WITHOUT_PASSWORD, Operation.CUSTOMIZE, Operation.SHARE_FULLY,
                      Operation.DESTROY]
    }

    def "should verify when passed valid operation for comment"() {
        given:
        objectType = ObjectType.COMMENT
        when:
        AbilityOperationVerifier.verify(objectType, operation)
        then:
        noExceptionThrown()
        where:
        operation << [Operation.REPORT, Operation.DECLINE,
                      Operation.APPROVE, Operation.DELETE]
    }

    def "should throw exception when passed invalid operation for bubble"() {
        given:
        objectType = ObjectType.BUBBLE
        when:
        AbilityOperationVerifier.verify(objectType, operation)
        then:
        thrown InvalidParametersException
        where:
        operation << [Operation.EDIT, Operation.REPORT, Operation.SEE_REFLECTION_TEXT,
                      Operation.SEE_REFLECTION_VIDEO, Operation.SHARE, Operation.SUBMIT_TO, Operation.SWITCH, Operation.SWITCH_WITHOUT_PASSWORD,
                      Operation.CUSTOMIZE, Operation.SHARE_FULLY, Operation.DECLINE,
                      Operation.APPROVE, Operation.DELETE]
    }

    def "should verify when passed valid operation for bubble"() {
        given:
        objectType = ObjectType.BUBBLE
        when:
        AbilityOperationVerifier.verify(objectType, Operation.DESTROY)
        then:
        noExceptionThrown()
    }
}