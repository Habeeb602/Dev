package com.se2.lambda;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class OperatorExample {

    public static void main(String[] args) {


        // UnaryOperator<T> takes type T input and returns type T output
        // It's similar to Function<T, R>, but it returns the same type as input
        UnaryOperator<String> formSentence = name -> "My Name is " + name;
        System.out.println(formSentence.apply("Habeeb"));


        // BinaryOperator takes type T for both it's input (two inputs) & it's output
        // It's similar to BiFunction
        BinaryOperator<String> concatString = (firstName, lastName) -> firstName + " " +lastName;
        System.out.println(concatString.apply("Habeeb", "Rahman"));




    }
}
