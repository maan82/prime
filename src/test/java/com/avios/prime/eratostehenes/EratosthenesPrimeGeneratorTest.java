package com.avios.prime.eratostehenes;

import org.junit.Test;

import static com.avios.prime.eratostehenes.NotEnoughSpace.INVALID_INSUFFICIENT_SPACE_MESSAGE;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

public class EratosthenesPrimeGeneratorTest {

    @Test
    public void testConstructorCreatesBooleanArrayOfLimitPlusOne() {
        EratosthenesPrimeGenerator primeGenerator = new EratosthenesPrimeGenerator(5);
        boolean[] compositeNumbers = primeGenerator.getCompositeNumbers();

        assertThat(compositeNumbers.length, is(6));
    }

    @Test
    public void testConstructorThrowNotEnoughMemoryWhenNotEnoughSpaceToCreateArray() {
        try {
            new EratosthenesPrimeGenerator(5) {
                @Override
                protected boolean[] createArray(int limit) {
                    throw new OutOfMemoryError();
                }
            };
            fail();
        } catch (NotEnoughSpace ex) {
            assertThat(ex.getMessage(), is(INVALID_INSUFFICIENT_SPACE_MESSAGE));
        }
    }

    @Test
    public void testConstructorSetsZeroAndOneToComposite() {
        EratosthenesPrimeGenerator primeGenerator = new EratosthenesPrimeGenerator(2);
        boolean[] compositeNumbers = primeGenerator.getCompositeNumbers();

        assertThat(compositeNumbers[0], is(true));
        assertThat(compositeNumbers[1], is(true));
    }

    @Test
    public void testGeneratePrimesShouldSetMultiplesStartingFromTwoUptoSqrtOfLimit() {
        MultiplesUpdater multiplesUpdater = mock(MultiplesUpdater.class);
        EratosthenesPrimeGenerator primeGenerator = new EratosthenesPrimeGenerator(3);
        primeGenerator.setMultiplesUpdater(multiplesUpdater);
        primeGenerator.setConsolePrinter(mock(ConsolePrinter.class));

        primeGenerator.generatePrimes();

        verifyZeroInteractions(multiplesUpdater);
    }

    @Test
    public void testGeneratePrimesShouldSetMultiplesStartingFromTwoUptoSqrtOfLimitWhenSqrtTwo() {
        MultiplesUpdater multiplesUpdater = mock(MultiplesUpdater.class);
        EratosthenesPrimeGenerator primeGenerator = new EratosthenesPrimeGenerator(4);
        primeGenerator.setMultiplesUpdater(multiplesUpdater);
        primeGenerator.setConsolePrinter(mock(ConsolePrinter.class));
        boolean[] compositeNumbers = primeGenerator.getCompositeNumbers();

        when(multiplesUpdater.setMultiplesToComposite(compositeNumbers, 2)).thenReturn(compositeNumbers);

        primeGenerator.generatePrimes();

        verify(multiplesUpdater, times(1)).setMultiplesToComposite(compositeNumbers, 2);
        verifyNoMoreInteractions(multiplesUpdater);
    }

    @Test
    public void testGeneratePrimesShouldSetMultiplesStartingFromTwoUptoSqrtOfLimitWhenSqrtGreaterThanTwo() {
        MultiplesUpdater multiplesUpdater = mock(MultiplesUpdater.class);
        EratosthenesPrimeGenerator primeGenerator = new EratosthenesPrimeGenerator(9);
        primeGenerator.setMultiplesUpdater(multiplesUpdater);
        primeGenerator.setConsolePrinter(mock(ConsolePrinter.class));
        boolean[] compositeNumbers = primeGenerator.getCompositeNumbers();

        when(multiplesUpdater.setMultiplesToComposite(compositeNumbers, 2)).thenReturn(compositeNumbers);
        when(multiplesUpdater.setMultiplesToComposite(compositeNumbers, 3)).thenReturn(compositeNumbers);

        primeGenerator.generatePrimes();

        verify(multiplesUpdater, never()).setMultiplesToComposite(compositeNumbers, 0);
        verify(multiplesUpdater, never()).setMultiplesToComposite(compositeNumbers, 1);
        verify(multiplesUpdater, times(1)).setMultiplesToComposite(compositeNumbers, 2);
        verify(multiplesUpdater, times(1)).setMultiplesToComposite(compositeNumbers, 3);
        verify(multiplesUpdater, never()).setMultiplesToComposite(compositeNumbers, 4);
    }

    @Test
    public void testGeneratePrimesShouldPrint() {
        MultiplesUpdater multiplesUpdater = mock(MultiplesUpdater.class);
        ConsolePrinter consolePrinter = mock(ConsolePrinter.class);
        EratosthenesPrimeGenerator primeGenerator = new EratosthenesPrimeGenerator(2);

        primeGenerator.setMultiplesUpdater(multiplesUpdater);
        primeGenerator.setConsolePrinter(consolePrinter);

        primeGenerator.generatePrimes();

        verify(consolePrinter).print(2);
        verifyNoMoreInteractions(consolePrinter);
    }

}