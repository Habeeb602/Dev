package generics;

import generics.animal.Animal;
import generics.animal.Cat;
import generics.animal.Dog;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Printer<String> stringPrinter = new Printer<>("Hello Everyone!");
        Printer<Integer> integerPrinter = new Printer<>(12);
        Printer<Double> doublePrinter = new Printer<>(0.01);

        stringPrinter.print();
        integerPrinter.print();
        doublePrinter.print();



        AnimalPrinter<Animal> animalPrinter = new AnimalPrinter<>();

        animalPrinter.print(new Cat());
        animalPrinter.print(new Dog());

        AnimalPrinter<Cat> animalPrinter2= new AnimalPrinter<>(new Cat());
        animalPrinter2.print();

        AnimalPrinter<Dog> animalPrinter1 = new AnimalPrinter<>(new Dog());
        animalPrinter1.print();

//        It will give error, if we try to use a type other than [Animal and it's subtypes]
//        AnimalPrinter<String> animalPrinter1 = new AnimalPrinter<>();


        System.out.println("---------------------------------");
        printMethod(12);
        printMethod(new Dog());
        printMethod("Hi There!");
        System.out.println("---------------------------------");



    }

    private static <T> void printMethod(T something){
        System.out.println(something);
    }


    // returning generic type
    private static <T, V> V returnV(T tThing, V vThing){
        return vThing;
    }

    // wildcards while using collections
    private static void printListOfUnknown(List<?> unknownList){
        System.out.println(unknownList);
    }

    // bounded wildcards
    private static void printListOfUnknownAnimals(List<? extends Animal> unknownAnimalList){
        System.out.println(unknownAnimalList);
    }


}
