package com.quarrelsome.romannumerals.impl;

import com.quarrelsome.romannumerals.exceptions.RomanNumeralParserOutOfRangeException;

public abstract class AbstractRomanNumeralParserImpl implements RomanNumeralParserImpl {

    protected void checkNumberIsWithinRange(int number) throws RomanNumeralParserOutOfRangeException {
        if (number <= 0 || number > 3000) {
            throw new RomanNumeralParserOutOfRangeException();
        }
    }
}
