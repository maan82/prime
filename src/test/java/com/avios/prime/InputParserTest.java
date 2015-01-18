package com.avios.prime;

import org.junit.Test;

import static com.avios.prime.InvalidInputException.INVALID_INPUT_MESSAGE;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class InputParserTest {

    @Test
    public void testCovertShouldThrowInvalidInputExceptionWhenLengthIsLessThanOne() {
        try {
            String[] args = {};
            new InputParser(args);
            fail();
        } catch (InvalidInputException ex) {
            assertThat(ex.getMessage(), is(INVALID_INPUT_MESSAGE));
        }
    }

    @Test
    public void testCovertShouldThrowInvalidInputExceptionForZero() {
        try {
            String[] args = {"0"};
            new InputParser(args);
            fail();
        } catch (InvalidInputException ex) {
            assertThat(ex.getMessage(), is(INVALID_INPUT_MESSAGE));
        }
    }

    @Test
    public void testCovertShouldThrowInvalidInputExceptionForNull() {
        try {
            new InputParser(null);
            fail();
        } catch (InvalidInputException ex) {
            assertThat(ex.getMessage(), is(INVALID_INPUT_MESSAGE));
        }
    }

    @Test
    public void testCovertShouldThrowInvalidInputExceptionForEmptyString() {
        try {
            String[] args = {""};
            new InputParser(args);
            fail();
        } catch (InvalidInputException ex) {
            assertThat(ex.getMessage(), is(INVALID_INPUT_MESSAGE));
        }
    }

    @Test
    public void testCovertShouldThrowInvalidInputExceptionWhenNumberIsOne() {
        try {
            String[] args = {"1"};
            new InputParser(args);
            fail();
        } catch (InvalidInputException ex) {
            assertThat(ex.getMessage(), is(INVALID_INPUT_MESSAGE));
        }
    }

    @Test
    public void testCovertShouldThrowInvalidInputExceptionWhenNumberIsNegative() {
        try {
            String[] args = {"-1"};
            new InputParser(args);
            fail();
        } catch (InvalidInputException ex) {
            assertThat(ex.getMessage(), is(INVALID_INPUT_MESSAGE));
        }
    }

    @Test
    public void testCovertShouldThrowInvalidInputExceptionWhenNumberIsGreaterThanMax() {
        try {
            String[] args = {"1"+Integer.MAX_VALUE};
            new InputParser(args);
            fail();
        } catch (InvalidInputException ex) {
            assertThat(ex.getMessage(), is(INVALID_INPUT_MESSAGE));
        }
    }

    @Test
    public void testCovertShouldThrowInvalidInputExceptionWhenNumberIsEqualToMax() {
        try {
            String[] args = {""+Integer.MAX_VALUE};
            new InputParser(args);
            fail();
        } catch (InvalidInputException ex) {
            assertThat(ex.getMessage(), is(INVALID_INPUT_MESSAGE));
        }
    }

    @Test
    public void testCovertShouldReturnLongWhenValidValue() throws Exception {
        assertThat(new InputParser(new String[]{"10"}).getNumber(), is(new Integer(10)));
    }

    @Test
    public void testCovertShouldReturnLongWhenValidValueEdgeCase() throws Exception {
        Integer expected = new Integer(Integer.MAX_VALUE - 1);
        InputParser actual = new InputParser(new String[]{"" + (Integer.MAX_VALUE - 1)});
        assertThat(actual.getNumber(), is(expected));
    }

}