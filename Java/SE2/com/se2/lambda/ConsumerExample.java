package com.se2.lambda;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConsumerExample {

    public static void main(String[] args) {
        Consumer<String> printString = s -> System.out.println(s);
        Consumer<Integer> printInteger = i -> System.out.print(i + ", ");
        printString.accept("Hi There!");

        List<Integer> evenNumbers = Stream.iterate(0, N -> N + 2).limit(11).toList();
        evenNumbers.forEach(printInteger);


        Map<String, String> countriesWithCapital = new HashMap<>();

        // BiConsumer
        BiConsumer<String, String> mapCountriesWithCapital = (country, capital) -> countriesWithCapital.put(country, capital);

        mapCountriesWithCapital.accept("India", "New Delhi");
        mapCountriesWithCapital.accept("USA", "Washington DC");
        mapCountriesWithCapital.accept("Malaysia", "Kuala Lumpur");

        BiConsumer<String, String> printMap = (country, capital) -> System.out.println("The Capital of " + country + " is " + capital);

        countriesWithCapital.forEach(printMap);

    }
}
