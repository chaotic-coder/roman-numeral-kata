package com.quarrelsome.romannumerals.impl;

import com.quarrelsome.romannumerals.exceptions.RomanNumeralParserOutOfRangeException;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumeralParserImpl_v1 extends AbstractRomanNumeralParserImpl {
    private static Logger log = Logger.getLogger(RomanNumeralParserImpl_v1.class);

    private static Map<Integer, String> numeralLookup;

    static {
        numeralLookup = new LinkedHashMap<Integer, String>() {{
            put(1000, "M");
            put(900, "CM");
            put(500, "D");
            put(400, "CD");
            put(100, "C");
            put(90, "XC");
            put(50, "L");
            put(40, "XL");
            put(10, "X");
            put(9, "IX");
            put(5, "V");
            put(4, "IV");
            put(1, "I");
        }};
    }

    public String parse(int number) throws RomanNumeralParserOutOfRangeException {

        checkNumberIsWithinRange(number);

        log.debug("parsing: " + number);

        StringBuilder parsedNumber = new StringBuilder();

        Map.Entry<Integer, String> nextNumeral = getNextBiggestDenominator(number);
        log.debug("next numeral: " + nextNumeral.getValue());

        int remainder = number - nextNumeral.getKey();
        parsedNumber.append(nextNumeral.getValue());
        if (remainder != 0) {
            parsedNumber.append(parse(remainder));
        }

        return parsedNumber.toString();
    }

    private Map.Entry<Integer, String> getNextBiggestDenominator(int number) {
        Map.Entry<Integer, String> nextNumeral = null;
        for (Map.Entry<Integer, String> numeral : numeralLookup.entrySet()) {
            if (nextNumeral == null && number / numeral.getKey() > 0) {
                nextNumeral = numeral;
            }
        }
        return nextNumeral;
    }
}
