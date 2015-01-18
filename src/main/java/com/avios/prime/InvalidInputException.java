package com.avios.prime;

/**
 * Exception to be thrown if input is invalid.
 */
public class InvalidInputException extends Exception {
    public static final String INVALID_INPUT_MESSAGE = "Input number should be between 2 to "+ (Integer.MAX_VALUE - 1)+ "";

    public InvalidInputException(String message) {
        super(message);
    }
}
