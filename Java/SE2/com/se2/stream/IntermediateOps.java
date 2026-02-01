package com.se2.stream;

import java.util.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class IntermediateOps {

    public static void main(String[] args) {
//        filterDistinctLimit();
//        mapFlatmapSorted();
        primitiveStreams();
        primitiveStreamOps();
        primitiveStreamStats(IntStream.of(10,25,30,50));
    }

    private static void filterDistinctLimit(){
        List<String> animals = Stream.of("Deer", "Dog", "Pig", "Owl", "Monkey").toList();

        animals
                .stream()
                .filter(animal -> animal.length() > 3)
                .forEach(System.out::println);

        System.out.println();

        // Distinct
        Stream.of("Mango", "Mango", "Apple", "Banana")
                .peek(fruit -> System.out.println("1. " + fruit))
                .distinct()
                .forEach(fruit -> System.out.println("2. " + fruit));

        System.out.println();

        // Limit the number of results
        // Short circuits once the number of results attained
        Stream.of(10,20,30,40,50,60,70,80,90,100)
                .peek(num -> System.out.println("Before Filter: " + num))
                .filter(num -> num > 35)
                .peek(num -> System.out.println("Filtered: " + num))
                .limit(2)
                .forEach(num -> System.out.println("Limited: " + num));

    }

    private static void mapFlatmapSorted(){

        // Map create one-to-one bond between the element and process(element)
        // process refers to some manipulation on the current element, returns the manipulation
        Stream.of("This", "is", "a", "stream")
                .map(val -> val.length())
                .forEach(len -> System.out.print(len + " "));
        System.out.println();

        // FlatMap makes multiple streams (stream elements) into single stream
        List<List<String>> nestedList = Arrays.asList(Arrays.asList("Hi", "There!"), Arrays.asList("How", "are", "you?"));
        nestedList.stream()
                .flatMap(list -> list.stream())
                .forEach(word -> System.out.print(word + " "));



        Stream.of("Mango", "Kiwi", "Apple", "Banana", "Guava")
                .sorted()
                .forEach(fruit -> System.out.println(fruit));

        // Sorted with limit
        Stream.of("Mango", "Kiwi", "Apple", "Banana", "Guava")
                .peek(fruit -> System.out.println("Before Filter: " + fruit))
                .filter(fruit -> fruit.length() == 5)
                .peek(fruit -> System.out.println("After Filter: " + fruit))
                .sorted()
                .peek(fruit -> System.out.println("After Sorted: " + fruit))
                .limit(2)
                .forEach(fruit -> System.out.println("Sorted with limit 2: " + fruit));

    }

    private static void primitiveStreams(){
        int[] i = {10, 20, 30};
        long[] l = {100L, 200L, 300L};
        double[] d = {2.34, 4.12, 7.77};

        // Creating primitive streams
        IntStream intStream = Arrays.stream(i);
        DoubleStream doubleStream = Arrays.stream(d);
        LongStream longStream = Arrays.stream(l);

        // We can create this way also
        IntStream intStream1 = IntStream.of(10,20,30);

        intStream.forEach((integer) -> System.out.print(integer + " "));
        System.out.println();
        doubleStream.forEach((doub) -> System.out.print(doub + " "));
        System.out.println();
    }

    private static void primitiveStreamOps(){
        OptionalInt optionalInt = IntStream.of(10,20,30).max();
        System.out.println("optionalInt max() = " + optionalInt.getAsInt());

        OptionalDouble optionalDouble = DoubleStream.of(2.34, 4.12, 7.77).min();
        System.out.println("optionalDouble min() = " + optionalDouble.getAsDouble());

        OptionalDouble optionalDouble1 = LongStream.of(30L, 40L, 90L).average();
        System.out.println("optionalDouble avg() = " + (optionalDouble1.isPresent() ? optionalDouble1.getAsDouble() : "NULL"));

        int streamSum = IntStream.of(10,20,30).sum();
        System.out.println("stream Sum = " + streamSum);
    }

    private static void primitiveStreamStats(IntStream intStream){
        IntSummaryStatistics stats = intStream.summaryStatistics();
        System.out.println("stats = " + stats);
    }

}
