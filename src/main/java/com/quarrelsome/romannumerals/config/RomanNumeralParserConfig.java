package com.quarrelsome.romannumerals.config;

import com.quarrelsome.romannumerals.RomanNumeralParser;
import com.quarrelsome.romannumerals.impl.RomanNumeralParserImpl;
import com.quarrelsome.romannumerals.impl.RomanNumeralParserImpl_v1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RomanNumeralParserConfig {

    @Bean(name = "romanNumeralParserImpl")
    public RomanNumeralParserImpl getRomanNumeralParserImpl() {
        return new RomanNumeralParserImpl_v1();
    }

    @Bean(name = "romanNumeralParser")
    public RomanNumeralParser getRomanNumeralParser() {
        return new RomanNumeralParser();
    }
}
