package com.creatubbles.api.repository

import com.creatubbles.api.model.comment.Comment
import com.creatubbles.api.service.CommentService
import com.fasterxml.jackson.databind.ObjectMapper
import retrofit2.Call
import spock.lang.Specification

class CommentRepositoryTest extends Specification {

    def service = Mock(CommentService)
    def repository = new CommentRepositoryImpl(service, Mock(ObjectMapper))

    def "shouldCallGetForCreationComments"() {
        when:
        repository.getForCreation(anyPage(), anyId(), anyCallback())
        then:
        service.getForCreation(_, _) >> anyCall()
    }

    def "shouldCallGetForGalleryComments"() {
        when:
        repository.getForGallery(anyPage(), anyId(), anyCallback())
        then:
        service.getForGallery(_, _) >> anyCall()
    }

    def "shouldCallGetForUserComments"() {
        when:
        repository.getForUser(anyPage(), anyId(), anyCallback())
        then:
        service.getForUser(_, _) >> anyCall()
    }

    def "shouldCallCreateCommentForCreation"() {
        when:
        repository.createForCreation(anyComment(), anyId(), anyCallback())
        then:
        service.createForCreation(_, _) >> anyCall()
    }

    def "shouldCallCreateCommentForGallery"() {
        when:
        repository.createForGallery(anyComment(), anyId(), anyCallback())
        then:
        service.createForGallery(_, _) >> anyCall()
    }

    def "shouldCallCreateCommentForUser"() {
        when:
        repository.createForUser(anyComment(), anyId(), anyCallback())
        then:
        service.createForUser(_, _) >> anyCall()
    }

    def "shouldCallApproveWhenApproving"() {
        when:
        repository.approve(anyId(), anyCallback())
        then:
        service.approve(_) >> anyCall()
    }

    def "shouldCallDeclineWhenDeclining"() {
        when:
        repository.decline(anyId(), anyCallback())
        then:
        service.decline(_) >> anyCall()
    }

    private def anyComment() {
        Mock(Comment)
    }

    private def anyId() {
        ""
    }

    private def anyPage() {
        null
    }

    private def anyCallback() {
        null
    }

    private def anyCall() {
        Mock(Call)
    }
}