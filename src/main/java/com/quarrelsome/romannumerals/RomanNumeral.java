package com.quarrelsome.romannumerals;


public class RomanNumeral {
    private int integerValue;
    private String numeral;

    public RomanNumeral(int integerValue, String numeral) {
        this.integerValue = integerValue;
        this.numeral = numeral;
    }

    public int getIntegerValue() {
        return integerValue;
    }

    public String getNumeral() { return numeral; }
}
