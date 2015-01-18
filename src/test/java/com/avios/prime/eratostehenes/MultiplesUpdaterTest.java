package com.avios.prime.eratostehenes;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MultiplesUpdaterTest {

    @Test
    public void testSetMultiplesToCompositeShouldStartFromTwo() {
        boolean[] input = new boolean[4];

        boolean[] booleans = new MultiplesUpdater().setMultiplesToComposite(input, 1);

        assertThat(booleans[0], is(false));
        assertThat(booleans[1], is(false));
        assertThat(booleans[2], is(true));
        assertThat(booleans[3], is(true));

    }

    @Test
    public void testSetMultiplesToCompositeShouldUpdateOnlyMultiples() {
        boolean[] input = new boolean[9];

        boolean[] booleans = new MultiplesUpdater().setMultiplesToComposite(input, 2);

        assertThat(booleans[0], is(false));
        assertThat(booleans[1], is(false));
        assertThat(booleans[2], is(false));
        assertThat(booleans[3], is(false));
        assertThat(booleans[4], is(true));
        assertThat(booleans[5], is(false));
        assertThat(booleans[6], is(true));
        assertThat(booleans[7], is(false));
        assertThat(booleans[8], is(true));
    }

    @Test
    public void testSetMultiplesToCompositeShouldUpdateOnlyMultiplesForBigNumber() {
        boolean[] input = new boolean[21];

        boolean[] booleans = new MultiplesUpdater().setMultiplesToComposite(input, 10);

        assertThat(booleans[20], is(true));
    }

}