package com.quarrelsome.romannumerals.application;

import com.quarrelsome.romannumerals.RomanNumeralParser;
import com.quarrelsome.romannumerals.config.RomanNumeralParserConfig;
import com.quarrelsome.romannumerals.exceptions.RomanNumeralParserOutOfRangeException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CommandLineRomanNumeralParser {

    public static void main(String[] args) {
        if (args.length < 1) {
            usage();
            System.exit(1);
        }

//  XML configuration
//        ApplicationContext context =
//                new ClassPathXmlApplicationContext("beans.xml");

//  Class configuration
        ApplicationContext context =
                new AnnotationConfigApplicationContext(RomanNumeralParserConfig.class);

        RomanNumeralParser parser = (RomanNumeralParser)context.getBean("romanNumeralParser");

        Integer number = Integer.parseInt(args[0]);
        try {
            System.out.println(parser.fromInteger(number));
        } catch (RomanNumeralParserOutOfRangeException e) {
            System.out.println("Number out of range. Try again!");
        }
    }

    private static void usage() {
        System.out.println("Usage: CommandLineRomanNumeralParser <number>");
    }
}
