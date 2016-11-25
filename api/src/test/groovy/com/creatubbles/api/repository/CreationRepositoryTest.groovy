package com.creatubbles.api.repository

import com.creatubbles.api.ContentType
import com.creatubbles.api.model.creation.Creation
import com.creatubbles.api.model.image_manipulation.ImageManipulation
import com.creatubbles.api.model.upload.Upload
import com.creatubbles.api.service.CreationService
import com.fasterxml.jackson.databind.ObjectMapper
import retrofit2.Call
import spock.lang.Specification


/**
 * @author Pawel Szymanski
 */
class CreationRepositoryTest extends Specification {

    def service = Mock(CreationService)
    def repository = new CreationRepositoryImpl(Mock(ObjectMapper), service)

    def "should call get recent when obtaining recent creations"() {
        when:
        repository.getRecent(anyPage(), anyBoolean(), anyCallback())
        then:
        service.getRecent(_, _) >> anyCall()
    }

    def "should call get form gallery when obtaining creation based on gallery id"() {
        when:
        repository.getFromGallery(anyPage(), anyId(), anyBoolean(), anyCallback())
        then:
        service.getFromGallery(_, _, _) >> anyCall()
    }

    def "should call get by user when obtaining user's creations"() {
        when:
        repository.getByUser(anyPage(), anyId(), anyBoolean(), anyCallback())
        then:
        service.getByUser(_, _, _) >> anyCall()
    }

    def "should call search by name when obtaining creation by name"() {
        when:
        repository.getByName(anyPage(), anyId(), anyBoolean(), anyCallback())
        then:
        service.searchByName(_, _, _) >> anyCall()
    }

    def "should call get creation when obtaining creation by id"() {
        when:
        repository.getById(anyId(), anyCallback())
        then:
        service.getCreation(_) >> anyCall()
    }

    def "should call get recommended by creation when obtaining recommended creations by creation"() {
        when:
        repository.getRecommendedByCreation(anyPage(), anyId(), anyBoolean(), anyCallback())
        then:
        service.getRecommendedByCreation(_, _, _) >> anyCall()
    }

    def "should call get recommended by user when obtaining recommended creations by user"() {
        when:
        repository.getRecommendedByUser(anyPage(), anyId(), anyBoolean(), anyCallback())
        then:
        service.getRecommendedByUser(_, _, _) >> anyCall()
    }

    def "should call get by partner app when obtaining creations by partner app"() {
        when:
        repository.getByPartnerApplication(anyPage(), anyId(), anyCallback())
        then:
        service.getByPartnerApplication(_, _) >> anyCall()
    }

    def "should call update when updaing creation"() {
        when:
        repository.update(anyId(), anyCreation(), anyCallback())
        then:
        service.updateCreation(_, _) >> anyCall()
    }

    def "should call create when creating creation"() {
        when:
        repository.create(anyCreation(), anyCallback())
        then:
        service.createCreation(_) >> anyCall()
    }

    def "should call remove when removing creation"() {
        when:
        repository.remove(anyId(), anyCallback())
        then:
        service.removeCreation(_) >> anyCall()
    }

    def "should call create upload when starting upload"() {
        when:
        repository.startUpload(anyId(), ContentType.JPEG, anyCallback())
        then:
        service.createUpload(_, _) >> anyCall()
    }

    def "should call update upload when finishing upload"() {
        when:
        repository.finishUpload(Mock(Upload), "", anyCallback())
        then:
        service.updateCreationUpload(_, _) >> anyCall()
    }

    def "should call put image manipulation when updating image"() {
        when:
        repository.updateImage(anyId(), Mock(ImageManipulation), anyCallback())
        then:
        service.putImageManipulation(_, _) >> anyCall()
    }

    def "should call get toyboo details when obtaining toyboo creation details"() {
        when:
        repository.getToybooDetails(anyId(), anyCallback())
        then:
        service.getToybooDetails(_) >> anyCall()
    }

    private anyCreation() {
        Mock(Creation)
    }

    private String anyId() {
        ""
    }

    private Call anyCall() {
        Mock(Call)
    }

    private anyCallback() {
        null
    }

    private boolean anyBoolean() {
        false
    }

    private anyPage() {
        null
    }

}