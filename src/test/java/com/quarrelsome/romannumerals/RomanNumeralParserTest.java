package com.quarrelsome.romannumerals;


import com.quarrelsome.romannumerals.exceptions.RomanNumeralParserOutOfRangeException;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class RomanNumeralParserTest {

    @Test(expected = RomanNumeralParserOutOfRangeException.class)
    public void rejectsZero() throws RomanNumeralParserOutOfRangeException {
        RomanNumeralParser.fromInteger(0);
    }

    @Test(expected = RomanNumeralParserOutOfRangeException.class)
    public void rejectsGreaterThan3000() throws RomanNumeralParserOutOfRangeException {
        RomanNumeralParser.fromInteger(3001);
    }

    @Test
    public void parsesNumbersForSingleNumeral() throws RomanNumeralParserOutOfRangeException {
        assertEquals("I", RomanNumeralParser.fromInteger(1));
        assertEquals("V", RomanNumeralParser.fromInteger(5));
        assertEquals("X", RomanNumeralParser.fromInteger(10));
        assertEquals("L", RomanNumeralParser.fromInteger(50));
        assertEquals("C", RomanNumeralParser.fromInteger(100));
        assertEquals("D", RomanNumeralParser.fromInteger(500));
        assertEquals("M", RomanNumeralParser.fromInteger(1000));
    }

    @Test
    public void parsesNumbersForMultipleSingleNumerals() throws RomanNumeralParserOutOfRangeException {
        assertEquals("II", RomanNumeralParser.fromInteger(2));
        assertEquals("III", RomanNumeralParser.fromInteger(3));
        assertEquals("XX", RomanNumeralParser.fromInteger(20));
        assertEquals("MMM", RomanNumeralParser.fromInteger(3000));
    }

    @Test
    public void parsesNumbersForCompositeNumerals() throws RomanNumeralParserOutOfRangeException {
        assertEquals("VIII", RomanNumeralParser.fromInteger(8));
        assertEquals("DL", RomanNumeralParser.fromInteger(550));
        assertEquals("DLII", RomanNumeralParser.fromInteger(552));
        assertEquals("CCLVI", RomanNumeralParser.fromInteger(256));
        assertEquals("MCV", RomanNumeralParser.fromInteger(1105));
    }

    @Test
    public void parsedNumberRequiringSubtractorNumerals() throws RomanNumeralParserOutOfRangeException {
        assertEquals("IV", RomanNumeralParser.fromInteger(4));
        assertEquals("IX", RomanNumeralParser.fromInteger(9));
        assertEquals("MIV", RomanNumeralParser.fromInteger(1004));
        assertEquals("XXXIV", RomanNumeralParser.fromInteger(34));
        assertEquals("CXXIV", RomanNumeralParser.fromInteger(124));
        assertEquals("MCMLXIX", RomanNumeralParser.fromInteger(1969));
    }
}

