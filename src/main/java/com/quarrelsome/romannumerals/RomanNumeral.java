package com.quarrelsome.romannumerals;


public class RomanNumeral {
    private int integerValue;
    private String numeral;
    private boolean isSubtractor;

    public RomanNumeral(int integerValue, String numeral, boolean isSubtractor) {
        this.integerValue = integerValue;
        this.numeral = numeral;
        this.isSubtractor = isSubtractor;
    }

    public int getIntegerValue() {
        return integerValue;
    }

    public String getNumeral() {
        return numeral;
    }

    public boolean isSubtractor() {
        return isSubtractor;
    }
}
