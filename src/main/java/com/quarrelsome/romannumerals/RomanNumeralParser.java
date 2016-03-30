package com.quarrelsome.romannumerals;


import com.quarrelsome.romannumerals.exceptions.RomanNumeralParserOutOfRangeException;
import org.apache.log4j.Logger;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumeralParser {
    private static Logger log = Logger.getLogger(RomanNumeralParser.class);

    private static Map<Integer, RomanNumeral> romanNumeralLookup;

    static {
        romanNumeralLookup = new LinkedHashMap<Integer, RomanNumeral>() {{
            put(1000, new RomanNumeral(1000, "M"));
            put(900, new RomanNumeral(900, "CM"));
            put(500, new RomanNumeral(500, "D"));
            put(400, new RomanNumeral(400, "CD"));
            put(100, new RomanNumeral(100, "C"));
            put(90, new RomanNumeral(90, "XC"));
            put(50, new RomanNumeral(50, "L"));
            put(40, new RomanNumeral(40, "XL"));;
            put(10, new RomanNumeral(10, "X"));
            put(9, new RomanNumeral(9, "IX"));
            put(5, new RomanNumeral(5, "V"));
            put(4, new RomanNumeral(4, "IV"));
            put(1, new RomanNumeral(1, "I"));
        }};
    }

    public static String fromInteger(int number) throws RomanNumeralParserOutOfRangeException {
        if (!isNumberWithinValidRange(number)) {
            throw new RomanNumeralParserOutOfRangeException();
        }

        return parse(number);
    }

    private static String parse(int number) {
        log.debug("parsing: " + number);

        StringBuilder parsedNumber = new StringBuilder();

        RomanNumeral nextNumeral = getNextBiggestDenominator(number);
        log.debug("next numeral: " + nextNumeral.getNumeral());

        int remainder = number - nextNumeral.getIntegerValue();
        parsedNumber.append(nextNumeral.getNumeral());
        if (remainder != 0) {
            parsedNumber.append(parse(remainder));
        }

        return parsedNumber.toString();
    }

    private static RomanNumeral getNextBiggestDenominator(int number) {
        RomanNumeral nextNumeral = null;
        for (Map.Entry<Integer, RomanNumeral> numeral : romanNumeralLookup.entrySet()) {
            if (nextNumeral == null && number / numeral.getKey() > 0) {
                nextNumeral = numeral.getValue();
            }
        }
        return nextNumeral;
    }

    private static boolean isNumberWithinValidRange(int number) {
        return number > 0 && number <= 3000;
    }

}
