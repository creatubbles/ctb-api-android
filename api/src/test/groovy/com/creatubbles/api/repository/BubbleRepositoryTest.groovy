package com.creatubbles.api.repository

import com.creatubbles.api.model.bubble.Bubble
import com.creatubbles.api.service.BubbleService
import com.fasterxml.jackson.databind.ObjectMapper
import retrofit2.Call
import spock.lang.Specification

class BubbleRepositoryTest extends Specification {

    def service = Mock(BubbleService)
    def repository = new BubbleRepositoryImpl(service, Mock(ObjectMapper))

    def "should call get for creation on service when obtaining bubbles on creation"() {
        when:
        repository.getForCreation(anyPage(), anyId(), anyCallback())
        then:
        service.getForCreation(_, _) >> anyCall()
    }

    def "should call get for gallery on service when obtaining bubbles on gallery"() {
        when:
        repository.getForGallery(anyPage(), anyId(), anyCallback());
        then:
        service.getForGallery(_, _) >> anyCall()
    }

    def "should call get for user on service when obtaining bubbles on user"() {
        when:
        repository.getForUser(anyPage(), anyId(), anyCallback());
        then:
        service.getForUser(_, _) >> anyCall()
    }

    def "should call post for creation when creating bubble on creation"() {
        when:
        repository.createForCreation(anyId(), anyBubble(), anyCallback());
        then:
        service.postForCreation(_, _) >> anyCall()
    }

    def "should call post for gallery when creating bubble on gallery"() {
        when:
        repository.createForGallery(anyId(), anyBubble(), anyCallback());
        then:
        service.postForGallery(_, _) >> anyCall()
    }

    def "should call post for user when creating bubble on user"() {
        when:
        repository.createForUser(anyId(), anyBubble(), anyCallback());
        then:
        service.postForUser(_, _) >> anyCall()
    }

    def "should call put when updating bubble"() {
        when:
        repository.update(anyId(), anyBubble(), anyCallback());
        then:
        service.putBubble(_, _) >> anyCall()
    }

    def "should call delete when removing bubble"() {
        when:
        repository.delete(anyId(), anyCallback());
        then:
        service.deleteBubble(_) >> anyCall()
    }

    def "should call get for colors when obtaining possible bubble colors"() {
        when:
        repository.getColors(anyCallback());
        then:
        service.getColors() >> anyCall()
    }

    private anyCallback() {
        null
    }

    private anyId() {
        ""
    }

    private anyPage() {
        0
    }

    private anyBubble() {
        Mock(Bubble)
    }

    private anyCall() {
        Mock(Call)
    }

}