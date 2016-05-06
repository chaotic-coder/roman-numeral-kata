package com.quarrelsome.romannumerals;


import com.quarrelsome.romannumerals.config.RomanNumeralParserConfig;
import com.quarrelsome.romannumerals.exceptions.RomanNumeralParserOutOfRangeException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RomanNumeralParserConfig.class,
        loader = AnnotationConfigContextLoader.class)
public class RomanNumeralParserTest {

    @Autowired
    private RomanNumeralParser parser;

    @Test(expected = RomanNumeralParserOutOfRangeException.class)
    public void rejectsZero() throws RomanNumeralParserOutOfRangeException {
        parser.fromInteger(0);
    }

    @Test(expected = RomanNumeralParserOutOfRangeException.class)
    public void rejectsGreaterThan3000() throws RomanNumeralParserOutOfRangeException {
        parser.fromInteger(3001);
    }

    @Test
    public void parsesNumbersForSingleNumeral() throws RomanNumeralParserOutOfRangeException {
        assertEquals("I", parser.fromInteger(1));
        assertEquals("V", parser.fromInteger(5));
        assertEquals("X", parser.fromInteger(10));
        assertEquals("L", parser.fromInteger(50));
        assertEquals("C", parser.fromInteger(100));
        assertEquals("D", parser.fromInteger(500));
        assertEquals("M", parser.fromInteger(1000));
    }

    @Test
    public void parsesNumbersForRepeatingNumerals() throws RomanNumeralParserOutOfRangeException {
        assertEquals("II", parser.fromInteger(2));
        assertEquals("III", parser.fromInteger(3));
        assertEquals("XX", parser.fromInteger(20));
        assertEquals("MMM", parser.fromInteger(3000));
    }

    @Test
    public void parsesNumbersForCompositeNumerals() throws RomanNumeralParserOutOfRangeException {
        assertEquals("VIII", parser.fromInteger(8));
        assertEquals("DL", parser.fromInteger(550));
        assertEquals("DLII", parser.fromInteger(552));
        assertEquals("CCLVI", parser.fromInteger(256));
        assertEquals("MCV", parser.fromInteger(1105));
    }

    @Test
    public void parsedNumberRequiringSubtractorNumerals() throws RomanNumeralParserOutOfRangeException {
        assertEquals("IV", parser.fromInteger(4));
        assertEquals("IX", parser.fromInteger(9));
        assertEquals("XL", parser.fromInteger(40));
        assertEquals("MIV", parser.fromInteger(1004));
        assertEquals("XXXIV", parser.fromInteger(34));
        assertEquals("CXXIV", parser.fromInteger(124));
        assertEquals("CCXC", parser.fromInteger(290));
        assertEquals("MCMLXIX", parser.fromInteger(1969));
    }
}

