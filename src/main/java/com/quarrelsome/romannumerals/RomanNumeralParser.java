package com.quarrelsome.romannumerals;


import com.quarrelsome.romannumerals.exceptions.RomanNumeralParserOutOfRangeException;
import com.quarrelsome.romannumerals.impl.RomanNumeralParserImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class RomanNumeralParser {

    @Autowired
    private RomanNumeralParserImpl romanNumeralParserImpl;

    public String fromInteger(int number) throws RomanNumeralParserOutOfRangeException {
        return romanNumeralParserImpl.parse(number);
    }

}
