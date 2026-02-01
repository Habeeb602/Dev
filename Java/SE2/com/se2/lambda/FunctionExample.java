package com.se2.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionExample {

    public static void main(String[] args) {

        Function<String, Integer> getStringLength = str -> str.length();

        System.out.println(getStringLength.apply("Habeeb Rahman J"));

        BiFunction<String, String, String> stringConcat = (a, b) -> a.concat(b);

        System.out.println(stringConcat.apply("Habeeb ", "Rahman"));
    }
}
