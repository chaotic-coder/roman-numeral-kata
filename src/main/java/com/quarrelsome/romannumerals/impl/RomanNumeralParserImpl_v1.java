package com.quarrelsome.romannumerals.impl;

import java.util.TreeSet;

/**
 * Parses arabic numbers to roman numerals
 *
 * Hard-codes subtractor numerals (rather than calculating them)
 */
public class RomanNumeralParserImpl_v1 extends AbstractRomanNumeralParserImpl {

    private static TreeSet<RomanNumeral> romanNumerals;

    static {
        romanNumerals = new TreeSet<RomanNumeral>() {{
            add(new RomanNumeral(1000, "M"));
            add(new RomanNumeral(900, "CM"));
            add(new RomanNumeral(500, "D"));
            add(new RomanNumeral(400, "CD"));
            add(new RomanNumeral(100, "C"));
            add(new RomanNumeral(90, "XC"));
            add(new RomanNumeral(50, "L"));
            add(new RomanNumeral(40, "XL"));
            add(new RomanNumeral(10, "X"));
            add(new RomanNumeral(9, "IX"));
            add(new RomanNumeral(5, "V"));
            add(new RomanNumeral(4, "IV"));
            add(new RomanNumeral(1, "I"));
        }};
    }

    public RomanNumeralParserImpl_v1() {
        super(romanNumerals);
    }
}
