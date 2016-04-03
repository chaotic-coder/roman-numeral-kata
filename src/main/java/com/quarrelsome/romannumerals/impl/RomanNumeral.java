package com.quarrelsome.romannumerals.impl;

public class RomanNumeral implements Comparable<RomanNumeral> {
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

    @Override
    public int compareTo(RomanNumeral o) {
        return this.arabic - o.arabic;
    }

    @Override
    public String toString() {
        return arabic + " : " + roman;
    }

}
