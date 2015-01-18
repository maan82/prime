package com.avios.prime.eratostehenes;

/**
 * Exception to deal with out of memory error gracefully.
 */
public class NotEnoughSpace extends RuntimeException {
    public static final String INVALID_INSUFFICIENT_SPACE_MESSAGE =
        "There is not enough space to allocate memory for the number you have entered." +
            "Please try a smaller number or try by setting -Xmx<MEMORY_SIZE>m for VM .";

    public NotEnoughSpace(String message) {
        super(message);
    }
}
