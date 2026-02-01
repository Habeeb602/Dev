package com.se2.stream;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOps {

    // Terminal Operation kickstart the streaming process

    /**
     * These are terminal operations
     * 1. count() - rType long
     * 2. min() & max() - rType Optional<T>
     * 3. findAny() & findFirst() - rType Optional<T>
     * 4. anyMatch(), allMatch() & noneMatch() - rType boolean
     * 5. forEach() - rType void
     * 6. reduce()
     * 7. collect()
     */
    public static void main(String[] args) {

//         countMinMax();
//         findAnyFindFirst();
//        anyAllNoneMatch();
//        reduce();
//        collect();
//        collectMap();
//        collectMapGroupingBy();
        collectPartitioningBy();
    }

    private static void countMinMax(){

        List<String> animals = Stream.of("Deer", "Dog", "Pig", "Owl", "Monkey").toList();

        System.out.println(animals.stream().count());

        Optional<String> str = animals.stream().min(Comparator.comparingInt(String::length));


        str.ifPresent(System.out::println);

        Optional<Integer> i = Stream.of(1,2,3,4,5,10,89,1,3,5,7,8)
                                .max(Comparator.naturalOrder());

        i.ifPresent(System.out::println);
    }

    private static void findAnyFindFirst(){

        Optional<String> name1 = Stream.of("Habeeb", "Rahman").findAny();
        name1.ifPresent(System.out::println);
        Optional<String> name2 = Stream.of("Habeeb", "Rahman").findFirst();
        name2.ifPresent(System.out::println);
    }

    private static void anyAllNoneMatch(){
        List<String> names = Arrays.asList("Adam", "Brandon", "Cook");
        Predicate<String> pred = str -> str.startsWith("B");

        System.out.println(names.stream().anyMatch(pred));
        System.out.println(names.stream().allMatch(pred));
        System.out.println(names.stream().noneMatch(pred));

    }

    private static void reduce(){
        List<String> nameChars = List.of("H", "a", "b", "e", "e", "b");

        // Variant - 1
        // reduce("Start_Value", (accumulator, current) -> someOperation) : returns T;
        String st1 = nameChars.stream().reduce("", (acc, curr) -> acc + curr);
        System.out.println(st1);


        // Variant - 2
        // reduce((accumulator, current) -> someOperation) : returns Optional<T>;
        Optional<String> st2 = nameChars.stream().reduce((acc, curr) -> acc + curr);
        st2.ifPresent(System.out::println);


        List<String> vehicles = Arrays.asList("Car", "Bus", "Truck", "Bike", "MotorCycle");

        System.out.println(vehicles.stream().reduce(0, (acc, str) -> acc + str.length(), (n1, n2) -> n1 + n2));

    }


    private static void collect(){


        StringBuilder sb = Stream.of("Ha", "be", "e", "b")
                                    .collect(() -> new StringBuilder(), // Accumulator's initial value
                                            (tsb, st) -> tsb.append(st), // Accumulator
                                            (tsb1, tsb2) -> tsb1.append(tsb2)); // Combiner

        System.out.println(sb);

        StringBuilder sbMR = Stream.of("Ha", "be", "e", "b")
                .collect(StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append);


        System.out.println(sbMR);

    }

    private static void collectMap(){

        List<String> animals = Stream.of("Deer", "Dog", "Pig", "Owl", "Monkey").toList();

        System.out.println(animals.stream().collect(Collectors.joining(", ")));
        System.out.println(animals.stream().collect(Collectors.averagingInt(animal -> animal.length())));


        // Map animal<->animal.length()
        Map<String, Integer> animalsMap = animals.stream().collect(Collectors.toMap(
                animal -> animal, // Key
                animal -> animal.length())); // Value
        System.out.println(animalsMap);


        // Map animal.length() <-> animals - List
        Map<Integer, List<String>> lengthMap = animals.stream().collect(Collectors.toMap(
                animal -> animal.length(), // Key
                animal -> Arrays.asList(animal), // Value
                (animalList, animal) -> Stream.concat(animalList.stream(), animal.stream()).collect(Collectors.toList()) // Resolution when a Key already exists
        ));

        System.out.println(lengthMap);

        // Map animal.length() <-> animals - String
        Map<Integer, String> lengthMapString = animals.stream().collect(Collectors.toMap(
                animal -> animal.length(), // Key
                animal -> animal, // Value
                (animal1, animal2) -> String.join(", ", animal1, animal2)
        ));

        System.out.println(lengthMapString);

        // Map animal <-> frequency(animal)
        animals = Stream.of("Deer", "Dog", "Pig", "Owl", "Monkey", "Owl", "Owl", "Dog", "Deer").toList();
        Map<String, Integer> frequency = animals.stream().collect(Collectors.toMap(
                animal -> animal,
                animal -> 1,
                Integer::sum
        ));

        System.out.println(frequency);
    }

    private static void collectMapGroupingBy(){

        List<String> animals = Stream.of("Deer", "Dog", "Pig", "Owl", "Monkey").toList();

        Map<Integer, List<String>> groupByLength = animals.stream().collect(Collectors.groupingBy(
                animal -> animal.length()
        ));

        System.out.println(groupByLength);
    }

    private static void collectPartitioningBy(){
        List<String> animals = Stream.of("Deer", "Dog", "Dog", "Pig", "Owl", "Monkey").toList();

        Map<Boolean, List<String>> partition = animals.stream().collect(
                Collectors.partitioningBy(animal -> animal.startsWith("D"))
        );
        System.out.println(partition);

        Map<Boolean, Set<String>> partitionByLength = animals.stream().collect(
                Collectors.partitioningBy(animal -> animal.length() > 3, Collectors.toSet())
        );
        System.out.println(partitionByLength);
    }


}
