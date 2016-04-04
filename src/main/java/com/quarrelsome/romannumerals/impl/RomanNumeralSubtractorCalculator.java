package com.quarrelsome.romannumerals.impl;


import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class RomanNumeralSubtractorCalculator {

    private static final Logger log = Logger.getLogger(RomanNumeralSubtractorCalculator.class);

    private final List<RomanNumeral> subtractors;

    public RomanNumeralSubtractorCalculator(Collection<RomanNumeral> romanNumerals) {
        List<RomanNumeral> sortedNumerals = romanNumerals.stream().sorted().collect(Collectors.toList());
        subtractors = calculateSubtractors(sortedNumerals, 0);

        log.debug("Subtractors: " + subtractors );
    }

    public List<RomanNumeral> getSubtractors() {
        return subtractors;
    }

    private List<RomanNumeral> calculateSubtractors(List<RomanNumeral> sortedRomanNumerals, int startPos) {
        List<RomanNumeral> subtractors = new ArrayList<>();

        if (startPos < sortedRomanNumerals.size() - 1) {
            RomanNumeral subtractor = sortedRomanNumerals.get(startPos);
            RomanNumeral firstSubtractee = sortedRomanNumerals.get(startPos + 1);
            RomanNumeral secondSubtractee = sortedRomanNumerals.get(startPos + 2);

            subtractors.add(new RomanNumeral(firstSubtractee.getArabic()-subtractor.getArabic(),
                subtractor.getRoman()+firstSubtractee.getRoman()));
            subtractors.add(new RomanNumeral(secondSubtractee.getArabic()-subtractor.getArabic(),
                subtractor.getRoman()+secondSubtractee.getRoman()));

            subtractors.addAll(calculateSubtractors(sortedRomanNumerals, startPos + 2));
        }
        return subtractors;
    }
}
