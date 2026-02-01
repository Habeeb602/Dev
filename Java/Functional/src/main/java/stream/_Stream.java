package stream;


import imperative.Main;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static stream._Stream.Gender.FEMALE;
import static stream._Stream.Gender.MALE;

public class _Stream {
    public static void main(String[] args) {

        List<Person> people = Arrays.asList(new Person("Habeeb", MALE),
                new Person("Sumaiya", FEMALE),
                new Person("Jahir", MALE),
                new Person("Najimu", FEMALE),
                new Person("Nasirah", FEMALE));


        people.stream().map(person -> person.gender).collect(Collectors.toSet()).forEach(System.out::println);

        people.stream().distinct().forEach(System.out::println);


        System.out.println("The list contains only female: " + people.stream().allMatch(person -> FEMALE.equals(person.gender)));


        System.out.println("The List contains at least one female: " + people.stream().anyMatch(person -> person.gender.equals(FEMALE)) );

    }

    static class Person{
        String name;
        Gender gender;

        Person(){}

        Person(String name, Gender gender){
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE
    }

}
