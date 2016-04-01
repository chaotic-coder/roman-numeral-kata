package com.quarrelsome.romannumerals.impl;

import com.quarrelsome.romannumerals.exceptions.RomanNumeralParserOutOfRangeException;

public interface RomanNumeralParserImpl {

    public String parse(int number) throws RomanNumeralParserOutOfRangeException;
}
