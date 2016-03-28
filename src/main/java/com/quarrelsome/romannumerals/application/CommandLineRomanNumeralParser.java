package com.quarrelsome.romannumerals.application;

import com.quarrelsome.romannumerals.RomanNumeralParser;
import com.quarrelsome.romannumerals.exceptions.RomanNumeralParserOutOfRangeException;

public class CommandLineRomanNumeralParser {

    public static void main(String[] args) {
        if (args.length < 1) {
            usage();
            System.exit(1);
        }

        Integer number =Integer.parseInt(args[0]);
        try {
            System.out.println(RomanNumeralParser.fromInteger(number));
        } catch (RomanNumeralParserOutOfRangeException e) {
            System.out.println("Number out of range. Try again!");
        }
    }

    private static void usage() {
        System.out.println("Usage: CommandLineRomanNumeralParser <number>");
    }
}
