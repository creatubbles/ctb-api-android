package com.creatubbles.api.repository

import android.content.Context
import com.creatubbles.api.service.UploadService
import com.fasterxml.jackson.databind.ObjectMapper
import okhttp3.MediaType
import retrofit2.Call
import spock.lang.Specification


/**
 * @author Pawel Szymanski
 */
class UploadRepositoryTest extends Specification {

    def service = Mock(UploadService)
    def repository = new UploadRepositoryImpl(Mock(ObjectMapper), service, Mock(Context))

    def "should call upload when uploading a file"() {
        when:
        repository.uploadFile(anyUrl(), anyMediaType(), anyFile(), anyCallback())
        then:
        service.uploadFile(_, _) >> anyCall()
    }

    private Call anyCall() {
        Mock(Call)
    }

    private anyCallback() {
        null
    }

    private anyFile() {
        Mock(File)
    }

    private MediaType anyMediaType() {
        MediaType.parse("")
    }

    private String anyUrl() {
        ""
    }
}