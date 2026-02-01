package com.se2.lambda;

interface Printer{
    void print();
}

interface Evaluate<T>{
    boolean isNegative(T t);
}

public class LambaExample {
    public static void main(String[] args) {

        // This is one way of implementing the interface without using class
        Printer printer1 = new Printer(){
            @Override
            public void print(){
                System.out.println("This is Java 7 way of implementing functional interface!");
            }
        };

        Printer printer2 = () -> System.out.println("This is Java 8 lambda implementation of an functional interface!");

        printer1.print();
        printer2.print();

        Evaluate<Integer> evaluate = i -> i < 0;

        System.out.println(evaluate.isNegative(-10));
        System.out.println(evaluate.isNegative(90));
    }
}
