package imperative;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static imperative.Main.Gender.*;

public class Main{
    public static void main(String[] args) {

        List<Person> persons = Arrays.asList(new Person("Habeeb", MALE),
                new Person("Sumaiya", FEMALE),
                new Person("Jahir", MALE),
                new Person("Najimu", FEMALE),
                new Person("Nasirah", FEMALE));


        // Imperative approach
        List<Person> females = new ArrayList<>();

        for(Person person: persons){
            if(FEMALE.equals(person.gender)){
                females.add(person);
            }
        }

        System.out.println("Imperative approach");
        for(Person female: females){
            System.out.println(female);
        }

        // Declarative approach
        System.out.println("Declarative approach");
        List<Person> females2 = persons.stream()
                .filter(person -> FEMALE.equals(person.gender))
                .collect(Collectors.toList());

        females2.forEach(System.out::println);


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