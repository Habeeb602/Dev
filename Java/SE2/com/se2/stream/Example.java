package com.se2.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example {

    /**
     * In general, Streams are lazy, it once executes when there is a necessity to do so (Only executes when the
     * - terminal method is given)
     * It doesn't go beyond the terminal condition.
     * */

    public static void main(String[] args) {
        createStreams();
    }

    public static void createStreams(){

        // Using Of
        List<String> names = Stream.of("Habeeb", "Sumaiya", "Najimu")
                .peek((name) -> System.out.println("Peek before filter: " + name))
                .filter(name -> name.startsWith("S"))
                .peek((name) -> System.out.println("Peek after filter: " + name))
                .collect(Collectors.toList()); // This is the terminal method, which kicks off the stream.

        System.out.println("Filtered names: " + names);


        // using generate
        Stream<Integer> randInt = Stream.generate(() -> {
            return (int) (Math.random() * 10);

        }).limit(10);

        randInt.forEach((integer) -> System.out.print(integer + ", "));


        System.out.println();
        // using iterate
        Stream<Integer> evenNums = Stream.iterate(0, num -> num + 2).limit(20);
        evenNums.forEach((integer) -> System.out.print(integer + ", "));
    }
}
