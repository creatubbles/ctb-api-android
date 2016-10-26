package com.creatubbles.api.model.bubble;

import com.creatubbles.api.exception.InvalidParametersException;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;

/**
 * @author Pawel Szymanski
 */
public class BubbleBuilderTest {

    private Bubble.Builder builder;

    @Before
    public void setUp() throws Exception {
        builder = new Bubble.Builder();
    }

    @Test(expected = InvalidParametersException.class)
    public void shouldThrowOnXPosGreaterThanOne() throws Exception {
        builder.setPosition(moreThanOne(), validPosition());
    }

    @Test(expected = InvalidParametersException.class)
    public void shouldThrowOnXPosSmallerThanZero() throws Exception {
        builder.setPosition(lessThanZero(), validPosition());
    }

    @Test(expected = InvalidParametersException.class)
    public void shouldThrowOnYPosGreaterThanOne() throws Exception {
        builder.setPosition(validPosition(), moreThanOne());
    }

    @Test(expected = InvalidParametersException.class)
    public void shouldThrowOnYPosSmallerThanZero() throws Exception {
        builder.setPosition(validPosition(), lessThanZero());
    }

    @Test
    public void shouldCreateBubbleWhenValidPositions() throws Exception {
        builder.setPosition(validPosition(), validPosition());

        assertNotNull(builder.build());
    }

    private double moreThanOne() {
        return 1.1D;
    }

    private double lessThanZero() {
        return -1.1D;
    }

    private double validPosition() {
        return 0.5D;
    }

}