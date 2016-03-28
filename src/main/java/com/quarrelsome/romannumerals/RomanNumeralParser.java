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
            put(1000, new RomanNumeral(1000, "M", true));
            put(500, new RomanNumeral(500, "D", true));
            put(100, new RomanNumeral(100, "C", true));
            put(50, new RomanNumeral(50, "L", true));
            put(10, new RomanNumeral(10, "X", true));
            put(5, new RomanNumeral(5, "V", true));
            put(1, new RomanNumeral(1, "I", false));
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

        String numeralUsingSubtractor = tryParseUsingSubtractorNumeral(number);
        if (numeralUsingSubtractor != null) {
            parsedNumber.append(numeralUsingSubtractor);
        } else {
            RomanNumeral nextNumeral = getNextBiggestDenominator(number);
            log.debug("next numeral: " + nextNumeral.getNumeral());

            int remainder = number - nextNumeral.getIntegerValue();
            parsedNumber.append(nextNumeral.getNumeral());
            if (remainder != 0) {
                parsedNumber.append(parse(remainder));
            }

        }

        return parsedNumber.toString();
    }

    private static String tryParseUsingSubtractorNumeral(int number) {
        String parsedNumber = null;

        RomanNumeral numeral = romanNumeralLookup.get(number+1);
        if (numeral != null && numeral.isSubtractor()) {
            parsedNumber = new String("I" + numeral.getNumeral());
        }
        return parsedNumber;
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
