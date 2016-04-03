package com.quarrelsome.romannumerals.impl;

import com.quarrelsome.romannumerals.exceptions.RomanNumeralParserOutOfRangeException;
import org.apache.log4j.Logger;

import java.util.TreeSet;

public abstract class AbstractRomanNumeralParserImpl implements RomanNumeralParserImpl {

    private static final Logger log = Logger.getLogger(AbstractRomanNumeralParserImpl.class);

    private TreeSet<RomanNumeral> romanNumerals;

    protected AbstractRomanNumeralParserImpl(TreeSet<RomanNumeral> romanNumerals) {
        this.romanNumerals = romanNumerals;
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

    protected RomanNumeral getBiggestDenominator(int number) {
        return romanNumerals.descendingSet().stream().
            filter(x -> number/x.getArabic() > 0).
            findFirst().
            get();
    }

    protected void checkNumberIsWithinRange(int number) throws RomanNumeralParserOutOfRangeException {
        if (number <= 0 || number > 3000) {
            throw new RomanNumeralParserOutOfRangeException();
        }
    }
}
