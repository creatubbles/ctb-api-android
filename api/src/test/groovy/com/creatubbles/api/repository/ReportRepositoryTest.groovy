package com.creatubbles.api.repository

import com.creatubbles.api.model.Report
import com.creatubbles.api.service.ReportService
import com.fasterxml.jackson.databind.ObjectMapper
import retrofit2.Call
import spock.lang.Specification

/**
 * @author Pawel Szymanski
 */
class ReportRepositoryTest extends Specification {

    def service = Mock(ReportService)
    def repository = new ReportRepositoryImpl(service, Mock(ObjectMapper))

    def "should post report for user when reporting user"() {
        when:
        repository.reportUser(anyId(), anyReport(), anyCallback())
        then:
        service.postForUser(_, _) >> anyCall()
    }

    def "should post report for creation when reporting creation"() {
        when:
        repository.reportCreation(anyId(), anyReport(), anyCallback())
        then:
        service.postForCreation(_, _) >> anyCall()
    }

    def "should post report for gallery when reporting gallery"() {
        when:
        repository.reportGallery(anyId(), anyReport(), anyCallback())
        then:
        service.postForGallery(_, _) >> anyCall()
    }

    def "should post report for comment when reporting comment"() {
        when:
        repository.reportComment(anyId(), anyReport(), anyCallback())
        then:
        service.postForComment(_, _) >> anyCall()
    }

    private anyCallback() {
        null
    }

    private anyReport() {
        Mock(Report)
    }

    private anyId() {
        ""
    }

    private anyCall() {
        Mock(Call)
    }
}
