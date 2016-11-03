package com.creatubbles.api.repository

import com.creatubbles.api.service.NotificationService
import com.fasterxml.jackson.databind.ObjectMapper
import retrofit2.Call
import spock.lang.Specification

/**
 * @author Pawel Szymanski
 */
class NotificationRepositoryTest extends Specification {

    def service = Mock(NotificationService)
    def repository = new NotificationRepositoryImpl(service, Mock(ObjectMapper))

    def "should call get notifications"() {
        when:
        repository.getNotifications(anyPage(), anyFilter(), anyCallback())
        then:
        1 * service.getNotifications(_, _) >> anyCall()
    }

    def "should call post read notification when marking as read"() {
        when:
        repository.markRead(anyId(), anyCallback())
        then:
        1 * service.postReadNotification(_) >> anyCall()
    }

    def "should call put last notification viewed when updating read date"() {
        when:
        repository.updateLastViewedDate(anyCallback())
        then:
        1 * service.putLastViewedAt() >> anyCall()
    }

    def anyPage() {
        null
    }

    def anyFilter() {
        null
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
