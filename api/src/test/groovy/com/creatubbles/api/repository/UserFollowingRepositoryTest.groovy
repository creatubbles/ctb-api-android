package com.creatubbles.api.repository

import com.creatubbles.api.service.UserService
import com.fasterxml.jackson.databind.ObjectMapper
import retrofit2.Call
import spock.lang.Specification


/**
 * @author Pawel Szymanski
 */
class UserFollowingRepositoryTest extends Specification {

    def service = Mock(UserService)
    def repository = new UserFollowingRepositoryImpl(service, Mock(ObjectMapper))

    def "should call post following when following user"() {
        when:
        repository.follow(anyId(), anyCallback());
        then:
        service.postFollowing(_) >> anyCall()
    }

    def "should call delete following when unfollowing user"() {
        when:
        repository.unfollow(anyId(), anyCallback());
        then:
        service.deleteFollowing(_) >> anyCall()
    }

    private Call anyCall() {
        Mock(Call)
    }

    private anyCallback() {
        null
    }

    private String anyId() {
        return "ID";
    }

}