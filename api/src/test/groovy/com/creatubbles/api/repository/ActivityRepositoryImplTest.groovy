package com.creatubbles.api.repository

import com.creatubbles.api.response.ResponseCallback
import com.creatubbles.api.service.ActivityService
import com.fasterxml.jackson.databind.ObjectMapper
import retrofit2.Call
import spock.lang.Specification

/**
 * Created by mariuszostapowicz on 24.10.2016.
 */
class ActivityRepositoryImplTest extends Specification {

    def service = anyService()

    def "shouldCallGetActivitiesOnService"() {
        given:
        def repository = givenRepository()

        when:
        repository.getActivities(anyPage(), anyCallback())

        then:
        1 * service.getActivities(_) >> anyCall()
    }

    def anyPage() {
        1;
    }

    def anyCallback() {
        Mock(ResponseCallback)
    }

    def anyCall() {
        Mock(Call)
    }

    def anyMapper() {
        Mock(ObjectMapper)
    }

    def anyService() {
        Mock(ActivityService)
    }

    def givenRepository() {
        new ActivityRepositoryImpl(anyMapper(), service)
    }
}
