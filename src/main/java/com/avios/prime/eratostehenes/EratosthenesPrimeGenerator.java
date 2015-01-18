package com.avios.prime.eratostehenes;

import static com.avios.prime.eratostehenes.NotEnoughSpace.INVALID_INSUFFICIENT_SPACE_MESSAGE;

/**
 * Implementation of Eratosthenes sieve algorithm to find primes up to limit.
 */
public class EratosthenesPrimeGenerator {

    // Composite numbers are opposite of prime numbers.
    // Instead of using primes array and setting those to true in extra iteration
    // we store composites array. This will save extra iteration
    // to initialise primes array to true
    private boolean[] compositeNumbers;

    private ConsolePrinter consolePrinter;

    private MultiplesUpdater multiplesUpdater;

    public EratosthenesPrimeGenerator(int limit) {
        try {
            this.compositeNumbers = createArray(limit);
        } catch (OutOfMemoryError e) {
            throw new NotEnoughSpace(INVALID_INSUFFICIENT_SPACE_MESSAGE);
        }
        this.compositeNumbers[0] = true;
        this.compositeNumbers[1] = true;
    }

    /**
     * This method prints prime numbers.
     */
    public void generatePrimes() {
        int length = this.compositeNumbers.length;
        int squareRoot = (int) Math.sqrt(length - 1);
        for (int i = 2; i <= squareRoot; i++) {
            //Numbers which are multiple will be composites so mark them as true
            this.compositeNumbers = getMultiplesUpdater().setMultiplesToComposite(this.compositeNumbers, i);
        }
        print();
    }

    protected void print() {
        for ( int i = 0; i < compositeNumbers.length; i++ ) {
            if (isPrime(compositeNumbers[i])) {
                getConsolePrinter().print(i);
            }
        }
    }

    private boolean isPrime(boolean composite) {
        //Numbers which are not composite are primes
        return !composite;
    }

    protected boolean[] createArray(int limit) {
        return new boolean[ limit + 1 ];
    }

    public ConsolePrinter getConsolePrinter() {
        return consolePrinter;
    }

    public void setConsolePrinter(ConsolePrinter consolePrinter) {
        this.consolePrinter = consolePrinter;
    }

    public MultiplesUpdater getMultiplesUpdater() {
        return multiplesUpdater;
    }

    public void setMultiplesUpdater(MultiplesUpdater multiplesUpdater) {
        this.multiplesUpdater = multiplesUpdater;
    }

    public boolean[] getCompositeNumbers() {
        return compositeNumbers;
    }
}
