package com.avios.prime;

import com.avios.prime.eratostehenes.EratosthenesPrimeGenerator;
import com.avios.prime.eratostehenes.MultiplesUpdater;
import com.avios.prime.eratostehenes.ConsolePrinter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class PrimePrinter {

    public static void main( String[] args ) throws InvalidInputException, InterruptedException {
        while (true) {
            new PrimePrinter().test();
            Thread.sleep(500);
        }
    }

    private void print(String[] args) throws InvalidInputException {
        EratosthenesPrimeGenerator eratosthenesPrimeGenerator =
            new EratosthenesPrimeGenerator(new InputParser(args).getNumber());
        eratosthenesPrimeGenerator.setConsolePrinter(new ConsolePrinter());
        eratosthenesPrimeGenerator.setMultiplesUpdater(new MultiplesUpdater());
        eratosthenesPrimeGenerator.generatePrimes();
    }

    private void test() {
        List<String> list = new java.util.concurrent.CopyOnWriteArrayList<String>();
        for (int i = 0; i < 10000; i++ ) {
            list.add(""+i);
        }
        System.out.println(list);
    }


}
