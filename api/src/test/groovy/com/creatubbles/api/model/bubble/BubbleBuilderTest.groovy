package com.creatubbles.api.model.bubble

import com.creatubbles.api.exception.InvalidParametersException
import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author Pawel Szymanski
 */
class BubbleBuilderTest extends Specification {

    def builder = new Bubble.Builder()

    @Unroll
    def "should throw when #message"() {
        when:
        builder.setPosition(x, y);
        then:
        thrown(InvalidParametersException)
        where:
        x               | y               | message
        moreThanOne()   | validPosition() | "x position greater than one"
        lessThanZero()  | validPosition() | "x position smaller than zero"
        validPosition() | moreThanOne()   | "y position greater than one"
        validPosition() | lessThanZero()  | "y position smaller than zero"
    }

    def "should create bubble with valid positions"() {
        when:
        def bubble = builder.setPosition(validPosition(), validPosition());
        then:
        notThrown(InvalidParametersException)
        bubble != null
    }

    private def moreThanOne() {
        return 1.1D;
    }

    private def lessThanZero() {
        return -1.1D;
    }

    private def validPosition() {
        return 0.5D;
    }

}