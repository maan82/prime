package com.avios.prime.eratostehenes;

/**
 * For a given list and a number it sets all the multiples to true
 */

public class MultiplesUpdater {

    /**
     * Set all the multiples of number in list to true
     *
     * @param compositeNumbers List of booleans array
     * @param number number whose multiples are to be marked
     * @return
     */
    public boolean[] setMultiplesToComposite(boolean[] compositeNumbers, Integer number) {
        long i = 2;
        long multiple = i * number;
        long length = compositeNumbers.length;
        while (multiple < length ) {
            compositeNumbers[(int)multiple] = true;
            multiple = ++i * number;
        }

        return compositeNumbers;
    }

}
