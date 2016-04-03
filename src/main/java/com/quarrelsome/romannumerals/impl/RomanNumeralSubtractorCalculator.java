package com.quarrelsome.romannumerals.impl;


import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class RomanNumeralSubtractorCalculator {

    private static final Logger log = Logger.getLogger(RomanNumeralSubtractorCalculator.class);

    private final List<Pair<Integer, String>> subtractors;

    public RomanNumeralSubtractorCalculator(Collection<RomanNumeral> romanNumerals) {
        List<RomanNumeral> sortedNumerals = romanNumerals.stream().sorted().collect(Collectors.toList());
        subtractors = calculateSubtractors(sortedNumerals, 0);

        log.debug("Subtractors: " + subtractors );
    }

    public List<Pair<Integer, String>> getSubtractors() {
        return subtractors;
    }

    private List<Pair<Integer, String>> calculateSubtractors(List<RomanNumeral> sortedRomanNumerals, int startPos) {
        List<Pair<Integer, String>> subtractors = new ArrayList<>();

        if (startPos < sortedRomanNumerals.size() - 1) {
            RomanNumeral subtractor = sortedRomanNumerals.get(startPos);
            RomanNumeral firstSubtractee = sortedRomanNumerals.get(startPos + 1);
            RomanNumeral secondSubtractee = sortedRomanNumerals.get(startPos + 2);

            subtractors.add(new ImmutablePair<>(firstSubtractee.getArabic()-subtractor.getArabic(),
                subtractor.getRoman()+firstSubtractee.getRoman()));
            subtractors.add(new ImmutablePair<>(secondSubtractee.getArabic()-subtractor.getArabic(),
                subtractor.getRoman()+secondSubtractee.getRoman()));

            subtractors.addAll(calculateSubtractors(sortedRomanNumerals, startPos + 2));
        }
        return subtractors;
    }
}
