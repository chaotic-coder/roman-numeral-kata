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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RomanNumeral that = (RomanNumeral) o;

        if (arabic != that.arabic) return false;
        return roman != null ? roman.equals(that.roman) : that.roman == null;

    }

    @Override
    public int hashCode() {
        int result = arabic;
        result = 31 * result + (roman != null ? roman.hashCode() : 0);
        return result;
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
