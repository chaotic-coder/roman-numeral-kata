package com.quarrelsome.romannumerals.impl;

import com.quarrelsome.romannumerals.exceptions.RomanNumeralParserOutOfRangeException;
import org.apache.log4j.Logger;

import java.util.*;

public class RomanNumeralParserImpl_v2 extends AbstractRomanNumeralParserImpl {
    private static Logger log = Logger.getLogger(RomanNumeralParserImpl_v2.class);

    private static Set<RomanNumeral> romanNumerals;

    static {
        Comparator<RomanNumeral> romanNumeralReverserComparator =
                (RomanNumeral lhs, RomanNumeral rhs)->(rhs.getArabic() - lhs.getArabic());

        romanNumerals = new TreeSet<RomanNumeral>(romanNumeralReverserComparator) {{
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


    public String parse(int number) throws RomanNumeralParserOutOfRangeException {

        checkNumberIsWithinRange(number);

        log.debug("parsing: " + number);

        StringBuilder parsedNumber = new StringBuilder();

        RomanNumeral nextNumeral = getNextBiggestDenominator(number);
        log.debug("next numeral: " + nextNumeral.getRoman());

        int remainder = number - nextNumeral.getArabic();
        parsedNumber.append(nextNumeral.getRoman());
        if (remainder != 0) {
            parsedNumber.append(parse(remainder));
        }

        return parsedNumber.toString();
    }

    private RomanNumeral getNextBiggestDenominator(int number) {
        RomanNumeral nextNumeral = null;
        for (RomanNumeral romanNumeral : romanNumerals) {
            if (nextNumeral == null && number / romanNumeral.getArabic() > 0) {
                nextNumeral = romanNumeral;
            }
        }
        return nextNumeral;
    }
}
