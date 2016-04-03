package com.quarrelsome.romannumerals;

import com.quarrelsome.romannumerals.impl.RomanNumeral;
import com.quarrelsome.romannumerals.impl.RomanNumeralSubtractorCalculator;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

public class RomanNumeralSubtractorCalculatorTest {

    private static List<RomanNumeral> romanNumerals;

    static {
        romanNumerals = new ArrayList<RomanNumeral>() {{
            add(new RomanNumeral(1000, "M"));
            add(new RomanNumeral(500, "D"));
            add(new RomanNumeral(100, "C"));
            add(new RomanNumeral(50, "L"));
            add(new RomanNumeral(10, "X"));
            add(new RomanNumeral(5, "V"));
            add(new RomanNumeral(1, "I"));
        }};
    }

    private RomanNumeralSubtractorCalculator romanNumeralSubtratorCalculator;

    @Before
    public void setUp() {
        romanNumeralSubtratorCalculator = new RomanNumeralSubtractorCalculator(romanNumerals);
    }

    @Test
    public void calculatesSubtratorFor_4() {
        assertEquals(new ImmutablePair<>(4,"IV"), romanNumeralSubtratorCalculator.getSubtractor(4));
    }

    @Test
    public void calculatesSubtratorFor_5() {
        assertNull(romanNumeralSubtratorCalculator.getSubtractor(5));
    }

    @Test
    public void calculatesSubtratorFor_1000() {
        assertNull(romanNumeralSubtratorCalculator.getSubtractor(1000));
    }

    @Test
    public void calculatesSubtratorFor_900() {
        assertEquals(new ImmutablePair<>(900,"CM"), romanNumeralSubtratorCalculator.getSubtractor(900));
    }
}
