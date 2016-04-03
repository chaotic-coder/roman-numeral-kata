package com.quarrelsome.romannumerals.impl;

import com.quarrelsome.romannumerals.exceptions.RomanNumeralParserOutOfRangeException;
import org.apache.log4j.Logger;

import java.util.TreeSet;

public class RomanNumeralParserImpl_v2 extends AbstractRomanNumeralParserImpl {
    private static Logger log = Logger.getLogger(RomanNumeralParserImpl_v1.class);

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
        subtractorCalculator = new RomanNumeralSubtractorCalculator(romanNumerals);

        subtractorCalculator.getSubtractors().stream().
            forEach(x->romanNumerals.add(new RomanNumeral(x.getLeft(), x.getRight())));

        log.debug("Roman numerals with subtractors:" + romanNumerals);

    }

    public String parse(int number) throws RomanNumeralParserOutOfRangeException {
        checkNumberIsWithinRange(number);
        log.debug("parsing: " + number);

        StringBuilder parsedNumber = new StringBuilder();

        RomanNumeral nextNumeral = getBiggestDenominator(number);
        log.debug("next numeral: " + nextNumeral);
        parsedNumber.append(nextNumeral.getRoman());
        int remainder = number - nextNumeral.getArabic();
        if (remainder != 0) {
            parsedNumber.append(parse(remainder));
        }

        return parsedNumber.toString();
    }

    private RomanNumeral getBiggestDenominator(int number) {
        return romanNumerals.descendingSet().stream().
            filter(x -> number/x.getArabic() > 0).
            findFirst().
            get();
    }
}
