package com.avios.prime.eratostehenes;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ConsolePrinterTest {

    @Test
    public void testPrintShouldPrintToConsole() {
        final ByteArrayOutputStream output = new ByteArrayOutputStream();

        System.setOut(new PrintStream(output));

        new ConsolePrinter().print(1);

        assertEquals("1"+System.lineSeparator(), output.toString());
    }
}