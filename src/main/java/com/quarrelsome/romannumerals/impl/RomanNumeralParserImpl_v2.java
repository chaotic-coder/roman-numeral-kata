package com.quarrelsome.romannumerals.impl;

import org.apache.log4j.Logger;

import java.util.TreeSet;

/**
 * Parses arabic numbers to roman numerals
 *
 * Calculates subtractor numerals in real-time (as opposed to hard-coding them)
 */
public class RomanNumeralParserImpl_v2 extends AbstractRomanNumeralParserImpl {
    private static Logger log = Logger.getLogger(RomanNumeralParserImpl_v2.class);

    private static TreeSet<RomanNumeral> romanNumerals;

    static {
        romanNumerals = new TreeSet<RomanNumeral>() {{
            add(new RomanNumeral(1000, "M"));
            add(new RomanNumeral(500, "D"));
            add(new RomanNumeral(100, "C"));
            add(new RomanNumeral(50, "L"));
            add(new RomanNumeral(10, "X"));
            add(new RomanNumeral(5, "V"));
            add(new RomanNumeral(1, "I"));
        }};
    }

    private RomanNumeralSubtractorCalculator subtractorCalculator;

    public RomanNumeralParserImpl_v2() {
        super(romanNumerals);

        subtractorCalculator = new RomanNumeralSubtractorCalculator(romanNumerals);

        subtractorCalculator.getSubtractors().stream().
            forEach(x->romanNumerals.add(new RomanNumeral(x.getLeft(), x.getRight())));

        log.debug("Roman numerals with subtractors:" + romanNumerals);
    }
}
