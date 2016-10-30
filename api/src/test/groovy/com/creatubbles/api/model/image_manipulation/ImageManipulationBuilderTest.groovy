package com.creatubbles.api.model.image_manipulation

import com.creatubbles.api.exception.InvalidParametersException
import spock.lang.Specification


/**
 * @author Pawel Szymanski
 */
class ImageManipulationBuilderTest extends Specification {

    def builder = new ImageManipulation.Builder();

    def "should not allow to create object without any params set"() {
        when:
        builder.build()
        then:
        thrown(InvalidParametersException)
    }

    def "should create object with cropping"() {
        given:
        builder.setCropping(anyCropping())
        when:
        def object = builder.build()
        then:
        notThrown(InvalidParametersException)
        object != null

    }

    def "should create object with rotation"() {
        given:
        builder.setRotation(anyRotation())
        when:
        def object = builder.build()
        then:
        notThrown(InvalidParametersException)
        object != null

    }

    def anyRotation() {
        Rotation.ROTATION_0
    }

    def anyCropping() {
        Mock(Cropping)
    }


}

