package com.creatubbles.api.repository

import com.creatubbles.api.model.PasswordChange
import com.creatubbles.api.model.school.School
import com.creatubbles.api.model.user.AccountDetails
import com.creatubbles.api.model.user.MultipleCreators
import com.creatubbles.api.model.user.NewUser
import com.creatubbles.api.service.UserService
import com.creatubbles.api.service.UserSortMode
import com.fasterxml.jackson.databind.ObjectMapper
import retrofit2.Call
import spock.lang.Specification


/**
 * @author Pawel Szymanski
 */
class UserRepositoryTest extends Specification {

    def service = Mock(UserService)
    def repository = new UserRepositoryImpl(Mock(ObjectMapper), service)

    def "should call get users when searching for users"() {
        when:
        repository.searchUsers(anyPage(), anyQuery(), anyCallback())
        then:
        service.getUsers(_, _) >> anyCall()
    }

    def "should call get user by id when obtaining user by id"() {
        when:
        repository.getUser(anyId(), anyCallback())
        then:
        service.getUserById(_) >> anyCall()
    }

    def "should call get user by id with specified id when obtaining current user"() {
        when:
        repository.getUser(anyCallback())
        then:
        service.getUserById(currentUserId()) >> anyCall()
    }

    def "should call get user by id with some id when obtaining some user"() {
        when:
        repository.getUser(anyId(), anyCallback())
        then:
        service.getUserById(_) >> anyCall()
    }

    def "should call get creators with specific user id when obtaining current user's creators"() {
        when:
        repository.getCreators(anyPage(), anyQuery(), anySortMode(), anyCallback())
        then:
        service.getCreators(currentUserId(), _, _, _) >> anyCall()
    }

    def "should call get creators with an id when obtaining any user's creators"() {
        when:
        repository.getCreators(anyId(), anyQuery(), anyPage(), anySortMode(), anyCallback())
        then:
        service.getCreators(_, _, _, _) >> anyCall()
    }

    def "should call get managers with specific user id when obtaining current user's managers"() {
        when:
        repository.getManagers(anyPage(), anyQuery(), anySortMode(), anyCallback())
        then:
        service.getManagers(currentUserId(), _, _, _) >> anyCall()
    }

    def "should call get managers with an id when obtaining any user's managers"() {
        when:
        repository.getManagers(anyId(), anyQuery(), anyPage(), anySortMode(), anyCallback())
        then:
        service.getManagers(_, _, _, _) >> anyCall()
    }

    def "should call get followed users with specific id when obtaining current user's followed users"() {
        when:
        repository.getFollowedUsers(anyPage(), anyQuery(), anySortMode(), anyCallback())
        then:
        service.getFollowedUsers(currentUserId(), _, _, _) >> anyCall()
    }

    def "should call get followed users with an id when obtaining any user's followed users"() {
        when:
        repository.getFollowedUsers(anyPage(), anyQuery(), anySortMode(), anyCallback())
        then:
        service.getFollowedUsers(currentUserId(), _, _, _) >> anyCall()
    }

    def "should call get connections users with specific id when obtaining current user's connections"() {
        when:
        repository.getConnections(anyPage(), anyQuery(), anySortMode(), anyCallback())
        then:
        service.getConnections(currentUserId(), _, _, _) >> anyCall()
    }

    def "should call get connections users with an id when obtaining any user's connections"() {
        when:
        repository.getConnections(anyPage(), anyQuery(), anySortMode(), anyCallback())
        then:
        service.getConnections(currentUserId(), _, _, _) >> anyCall()
    }

    def "should call create user when creating user"() {
        when:
        repository.createUser(Mock(NewUser), anyCallback())
        then:
        service.createUser(_) >> anyCall()
    }

    def "should call get users available for switching when obtaining"() {
        when:
        repository.getUsersAvailableForSwitching(anyPage(), anyCallback())
        then:
        service.getSwitchUsers(_, _) >> anyCall()
    }

    def "should call create multiple creators when creating multiple creators"() {
        when:
        repository.createMultipleCreators(Mock(MultipleCreators), anyCallback())
        then:
        service.createMultipleCreators(_) >> anyCall()
    }

    def "should call get creators from group when obtaining creators from group"() {
        when:
        repository.getCreatorsFromGroup(anyId(), anyPage(), anyCallback())
        then:
        service.getCreatorsFromGroup(_, _) >> anyCall()
    }

    def "should call get details with specific id when obtaining current user's account details"() {
        when:
        repository.getAccountDetails(anyCallback())
        then:
        service.getAccount(currentUserId()) >> anyCall()
    }

    def "should call get details with an id when obtaining any user's account details"() {
        when:
        repository.getAccountDetails(anyId(), anyCallback())
        then:
        service.getAccount(_) >> anyCall()
    }

    def "should call put account data when updating account data"() {
        when:
        repository.updateAccountDetails(anyId(), Mock(AccountDetails), anyCallback())
        then:
        service.putAccountData(_, _) >> anyCall()
    }

    def "should call put school when linking school with account"() {
        when:
        repository.linkSchoolWithAccount(anyId(), Mock(School), anyCallback())
        then:
        service.putSchool(_, _) >> anyCall()
    }

    def "should call post password change when changing password"() {
        when:
        repository.changePassword(anyId(), Mock(PasswordChange), anyCallback())
        then:
        service.postPasswordChange(_, _) >> anyCall()
    }

    def "should call get connections for current user when searching fo users"() {
        when:
        repository.searchConnections(anyQuery(), anyPage(), anySortMode(), anyCallback())
        then:
        service.getConnections(currentUserId(), _, _, _) >> anyCall()
    }

    private UserSortMode anySortMode() {
        null
    }

    private anyPage() {
        null
    }


    private String currentUserId() {
        UserRepository.CURRENT_USER
    }

    private Call anyCall() {
        Mock(Call)
    }

    private anyCallback() {
        null
    }

    private String anyId() {
        ""
    }

    private String anyQuery() {
        ""
    }
}