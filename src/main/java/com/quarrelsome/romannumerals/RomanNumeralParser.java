package com.quarrelsome.romannumerals;


import com.quarrelsome.romannumerals.exceptions.RomanNumeralParserOutOfRangeException;
import com.quarrelsome.romannumerals.impl.RomanNumeralParserImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class RomanNumeralParser {

    static int calls=0;

    public RomanNumeralParser() {
        System.out.println("CTR !!!!!!");
    }

    @Autowired
    private  RomanNumeralParserImpl romanNumeralParserImpl;

    public String fromInteger(int number) throws RomanNumeralParserOutOfRangeException {
        calls++;
        System.out.println("RMP calls: " + calls);
        return romanNumeralParserImpl.parse(number);
    }

}
