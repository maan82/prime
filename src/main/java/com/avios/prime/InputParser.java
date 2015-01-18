package com.avios.prime;

import static com.avios.prime.InvalidInputException.INVALID_INPUT_MESSAGE;

/**
 * Validates input and parse it.
 */
public class InputParser {
    private Integer number;

    /**
     * This method parse input and validate input.
     *
     * @param args command line arguments passed to main
     * @throws InvalidInputException throws if input is invalid or beyond range.
     */
    public InputParser(String[] args) throws InvalidInputException {
        if ( null == args || args.length < 1 ) {
            throwInvalidInputException();
        }
        try {
            this.number = new Integer(args[0]);
            if ( this.number <= 1 || this.number == Integer.MAX_VALUE) {
                throwInvalidInputException();
            }
        } catch (Exception ex) {
            throwInvalidInputException();
        }
    }

    public Integer getNumber() {
        return this.number;
    }

    private void throwInvalidInputException() throws InvalidInputException{
        throw new InvalidInputException(INVALID_INPUT_MESSAGE);
    }

}
