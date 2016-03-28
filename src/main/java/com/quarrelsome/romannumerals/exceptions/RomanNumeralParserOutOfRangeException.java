package com.quarrelsome.romannumerals.exceptions;


public class RomanNumeralParserOutOfRangeException extends Exception {
    public  RomanNumeralParserOutOfRangeException() {
        super("Number must be greater than zero and less than 3001");
    }
}
