package com.avios.prime;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.avios.prime.InvalidInputException.INVALID_INPUT_MESSAGE;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class PrimePrinterTest {

    @Test
    public void testMainShouldParseInput() throws Exception {
        try {
            PrimePrinter.main(new String[]{"-1"});
            fail();
        } catch (InvalidInputException ex) {
            assertThat(ex.getMessage(), is(INVALID_INPUT_MESSAGE));
        }
    }

    @Test
    public void testMainSuppliesDependencies() throws Exception {
        final ByteArrayOutputStream output = new ByteArrayOutputStream();

        System.setOut(new PrintStream(output));

        PrimePrinter.main(new String[]{"3"});

        assertThat(output.toString(), is("2"+System.lineSeparator()+"3"+System.lineSeparator()));
    }

}