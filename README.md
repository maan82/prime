 README
========

## Requisites
- Java
- Maven

## Basic commands
- `$ mvn clean install`: run tests and build
- `$ java com.avios.prime.PrimePrinter <LIMIT>`: runs programme and print primes up to specified limit

If you get NotEnoughSpaceException then try to increase memory by passing JVM memory args.

## TODO or Further enhancements
- Instead of injecting dependencies in class with main it should be done using frameworks like guice or spring.
- Because of array backed booleans list, at the max it can find primes up to Integer.MAX_VALUE.
An interface can be used to wire in file backed booleans list to find prime for large numbers.
- ConsolePrinter can be defined as interface and file based printer can be wired in.
