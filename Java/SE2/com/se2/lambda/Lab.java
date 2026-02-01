package com.se2.lambda;

import com.se2.lambda.interfaces.Functionable;
import com.se2.lambda.interfaces.Printable;
import com.se2.lambda.interfaces.Retrievable;
import com.se2.lambda.utils.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Lab {

    public static void main(String[] args) {

        Lab lab = new Lab();

        lab.consumer();
        lab.supplier();

        System.out.println("Is 4 even? " + lab.check(4, (num) -> num % 2 == 0));
        System.out.println("Is 7 even? " + lab.check(7, (num) -> num % 2 == 0));

        System.out.println(lab.check("Mr. Joe Bloggs", name -> name.startsWith("Mr")));
        System.out.println(lab.check("Ms. Ann Bloggs", name -> name.startsWith("Mr")));

        Person mike = new Person("Mike", 33);
        Person ann = new Person("Ann", 13);

        System.out.println(lab.check(mike, person -> person.getAge() >= 18));
        System.out.println(lab.check(ann, person -> person.getAge() >= 18));


        /**
         * 5. In main(), invoke the getPeople() – store the result in a variable named listPeople
         * */
        List<Person> listPeople = lab.getPeople();
        
        lab.sortAge(listPeople);
        listPeople.forEach(System.out::println);

        System.out.println();
        
        lab.sortName(listPeople);
        listPeople.forEach(System.out::println);

        System.out.println();

        lab.sortHeight(listPeople);
        listPeople.forEach(System.out::println);


    }



    private void consumer(){
        /**
         * 1.
         * In main() invoke the consumer() method; in consumer() do the following:
         * a) Using a lambda expression, implement the Printable interface (typed for String). The relevant
         * method just prints out the String argument it receives. Invoke the relevant method, passing in
         * "Printable lambda".
         * b) Using both a lambda expression and a method reference, implement 1a using a Consumer.
         * */

        Printable<String> printableLam = (str) -> System.out.println(str);
        Printable<String> printableMR = System.out::println;

        printableLam.print("Hi from Printable Lambda");
        printableMR.print("Hi from Printable using method reference");

    }

    private void supplier(){
        /**
         * In main() invoke the supplier() method; in supplier() do the following:
         * a) Using a lambda expression, implement the Retrievable interface (typed for Integer). The relevant
         * method just returns 77. Invoke the relevant method.
         * b) Using a lambda expression, implement 2a using a Supplier
         * */

        Retrievable<Integer> return77 = () -> 77;
        System.out.println(return77.retrieve());

        Supplier<Integer> supplier = () -> 77;
        System.out.println(supplier.get());

    }

    private <T> boolean check(T t, Predicate<T> predicate){
        /**
         * Declare a generically-typed check() method (not in UML). The first parameter is generic and the
         * second parameter is a Predicate, also generically typed. The check() method returns true/false.
         * Invoke the check() method with the following Predicate lambda expressions:
         *  we want to know if a number is even (true) – invoke check() with 4 and 7 (true and false).
         *  we want to know if a String begins with “Mr.” – invoke check() with “Mr. Joe Bloggs” and
         * “Ms. Ann Bloggs”
         *  we want to know if a person is an adult (age >= 18) – invoke check() with “Mike” who is 33
         * and 1.8 (metres assumed) in height; and “Ann” who is 13 and 1.4 (metres) in height.
         * */
        return predicate.test(t);
    }

    private void function(){
        /**
         * In main() invoke the function() method; in function() do the following:
         * a) Using a lambda expression, implement the Functionable interface - the input type is Integer and the
         * return type is String. The relevant method returns the number passed in appended to the String
         * “Number is: ”. Invoke the relevant method passing in 25.
         * b) Using a lambda expression, implement 4a using a Function
         * */

        Functionable<Integer, String> functionable = number -> "Number is " + number;
        System.out.println(functionable.applyThis(25));

        Function<Integer, String> function = number -> "Number is " + number;
        System.out.println(function.apply(25));

    }


    private List<Person> getPeople() {
        List<Person> result = new ArrayList<>();
        result.add(new Person("Mike", 33, 1.8));
        result.add(new Person("Mary", 25, 1.4));
        result.add(new Person("Alan", 34, 1.7));
        result.add(new Person("Zoe", 30, 1.5));
        return result;
    }

    private void sortAge(List<Person> personList){
        personList.sort(Comparator.comparing(Person::getAge));
    }
    private void sortName(List<Person> listPeople) {
        listPeople.sort(Comparator.comparing(Person::getName));
    }

    private void sortHeight(List<Person> listPeople) {
        listPeople.sort(Comparator.comparing(Person::getHeight));
    }

}
