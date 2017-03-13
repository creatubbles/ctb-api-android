package com.creatubbles.api.repository

import com.creatubbles.api.model.gallery.Gallery
import com.creatubbles.api.service.GalleryService
import com.fasterxml.jackson.databind.ObjectMapper
import retrofit2.Call
import spock.lang.Specification

import static org.mockito.Matchers.anyString

/**
 * @author Pawel Szymanski
 */
class GalleryRepositoryTest extends Specification {

    def service = Mock(GalleryService)
    def repository = new GalleryRepositoryImpl(Mock(ObjectMapper), service)

    def "should call get public when obtaining public galleries"() {
        when:
        repository.getPublic(anyPage(), anySortMode(), anyCallback());
        then:
        service.getPublic(_, _, _) >> anyCall()
    }

    def "should call get public when searching in public galleries"() {
        when:
        repository.searchPublic(anyQuery(), anyPage(), anySortMode(), anyCallback());
        then:
        service.getPublic(_, _, _) >> anyCall()
    }

    def "should cal get favorite when obtaining favorite galleries"() {
        when:
        repository.getFavorite(anyPage(), anyCallback());
        then:
        service.getFavorite(_) >> anyCall()
    }

    def "should call get featured when obtaining featured galleries"() {
        when:
        repository.getFeatured(anyPage(), anyCallback());
        then:
        service.getFeatured(_) >> anyCall()
    }

    def "should call get by user with specific id when obtaining current user's galleries"() {
        when:
        repository.getMine(anyPage(), anyQuery(), null, anyCallback());
        then:
        service.getByUser(currentUserId(), _, _, _) >> anyCall()
    }

    def "should call get by user when obtaining any user galleries"() {
        when:
        repository.getByUser(anyPage(), anyQuery(), anyId(), anyCallback());
        then:
        service.getByUser(_, _, _, _) >> anyCall()
    }

    def "should call get by id when obtaining gallery by id"() {
        when:
        repository.getById(anyPage(), anyString(), anyCallback());
        then:
        service.getById(_) >> anyCall()
    }

    def "should call get by creation when obtaining galleries by creation"() {
        when:
        repository.getByCreation(anyPage(), anyId(), anyCallback());
        then:
        service.getByCreation(_, _) >> anyCall()
    }

    def "shoulc call create when creating gallery"() {
        when:
        repository.create(anyGallery(), anyCallback());
        then:
        service.create(_) >> anyCall()
    }

    def "should call update when updating gallery"() {
        when:
        repository.update(anyId(), anyGallery(), anyCallback());
        then:
        service.update(_, _) >> anyCall()
    }

    def "should call post submission when submitting creation to gallery"() {
        when:
        repository.submitCreation(anyId(), anyId(), anyCallback());
        then:
        service.postSubmission(_) >> anyCall()
    }

    private anySortMode() {
        null
    }

    private String currentUserId() {
        UserRepository.CURRENT_USER
    }

    private Gallery anyGallery() {
        Mock(Gallery);
    }

    private String anyId() {
        "";
    }

    private Integer anyPage() {
        0;
    }

    private anyCallback() {
        null;
    }

    private anyCall() {
        Mock(Call)
    }

    private String anyQuery() {
        ""
    }
}