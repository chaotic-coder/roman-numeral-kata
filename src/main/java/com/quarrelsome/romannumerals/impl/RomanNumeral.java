package com.quarrelsome.romannumerals.impl;

public class RomanNumeral {
    private int arabic;
    private String roman;

    public RomanNumeral(int arabic, String roman) {
        this.arabic = arabic;
        this.roman = roman;
    }

    public int getArabic() {
        return arabic;
    }

    public String getRoman() {
        return roman;
    }
}
