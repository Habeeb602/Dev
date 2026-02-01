package com.se2.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class Others {

    public static void main(String[] args) {

        /**
        1. The local variables used inside a lambda method should be final or effectively final
        "effectively final" means, it's a normal variable with normal declaration
        but once used in lambda method, it cannot be changed after the lambda (not even outside of lambda)
        It will make them internally final.
        Example:
         */

        int x = 11;

        Predicate<Integer> isEven = (num) -> {
            // x++; is not allowed
            num = num + x;
            return num % 2 == 0;
        };

        // x++; is also not allowed


        /**
         * 2. Using method references in lambda
         * It has four types Bounded, Unbounded, Static & Constructor
         * */
        /**
         * 2.1 Bounded Method Reference
         * A bounded method reference is one where the method reference is associated with a specific instance of a class.
         * It means that the method reference is invoked on a particular object,
         * and it can access instance variables and methods of that object.
         * eg: ClassName::instanceMethodName
         * */

        List<String> names = Arrays.asList("Habeeb", "Sumaiya", "Najimu");
        String temp = "Habeeb";
        // Normal Lambda expression
        Supplier<String> lowerLambda = () -> temp.toLowerCase();
        Consumer<String> printNameLambda = name -> System.out.println(name);

        // Using method reference
        Supplier<String> lowerMethRef = temp::toLowerCase;
        Consumer<String> printNameMethRef = System.out::println;

        System.out.println(lowerLambda.get());
        System.out.println(lowerMethRef.get());

        names.forEach(printNameLambda);
        names.forEach(printNameMethRef);

        /**
         * 2.2 Unbounded Method Reference
         * An unbounded method reference is one where the method reference is not associated -
         * with a specific instance of a class.
         * Instead, it can be invoked on any object of the appropriate class or interface.
         * eg: ClassName::staticMethodName
         * */

        BiFunction<Integer, Integer, Double> powLambda = (a, b) -> {
            double k = 1;
            while(b > 0){
                k *= a;
                b--;
            }
            return k;
        };
        BiFunction<Integer, Integer, Double> powMethRef = Math::pow;

        System.out.println(powLambda.apply(10, 3));
        System.out.println(powLambda.apply(9, 3));
        System.out.println(powMethRef.apply(10, 3));
        System.out.println(powMethRef.apply(9, 3));



    }


    private static void constructorMethodReferences(){


        Supplier<StringBuilder> createSbLambda = () -> new StringBuilder();
        Supplier<StringBuilder> createSbMethRef = StringBuilder::new;



    }
}
