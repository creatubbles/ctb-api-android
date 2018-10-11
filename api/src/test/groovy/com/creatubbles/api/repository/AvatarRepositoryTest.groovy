package com.creatubbles.api.repository

import com.creatubbles.api.model.user.avatar.Avatar
import com.creatubbles.api.service.AvatarService
import com.creatubbles.api.service.UserService
import com.fasterxml.jackson.databind.ObjectMapper
import retrofit2.Call
import spock.lang.Specification

/**
 * Created by Janek on 03.11.2016.
 */
class AvatarRepositoryTest extends Specification {

    def service = anyService()
    def repository = anyRepository()

    def "should call put method on user service when updating avatar"() {
        when:
        repository.updateAvatar(anyString(), anyAvatar(), anyCallback())
        then:
        1 * service.updateAvatar(_, _) >> anyCall()
    }

    def "should call get suggestions method on user service when obtaining avatar suggestions"() {
        when:
        repository.getSuggestedAvatars(anyCallback())
        then:
        1 * service.getSuggestedAvatars() >> anyCall()
    }


    def anyCall() {
        Mock(Call)
    }

    def anyService() {
        Mock(UserService)
    }

    def anyCallback() {
        null
    }

    def anyMapper() {
        Mock(ObjectMapper)
    }

    def anyString() {
        "sample string"
    }

    def anyAvatar() {
        Mock(Avatar)
    }

    def anyRepository() {
        new AvatarRepositoryImpl(anyMapper(), service, Mock(AvatarService))
    }

}