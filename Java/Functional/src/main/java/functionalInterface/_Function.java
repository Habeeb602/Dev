 package functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {

        // Normal function/method
        int increment = incrementByOne(1);
        System.out.println("Normal method: " + increment);
        // function.Function
        int increment2 = incrementByOneFunc.apply(1);
        System.out.println("Using Function: " + increment2 );

        // Chaining functions

        Function<Integer, Integer> combinationOfTwo = incrementByOneFunc.andThen(multiplyBy10);

        System.out.println("Chaining functions: " + combinationOfTwo.apply(1));

        // BiFunction

        System.out.println("BiFunction - adding two numbers: " + addTwoNumbers.apply(5, 6));

        _Sample.print();


    }



    // using Function
    // Function takes two arguments
    // Function always return a value unlike Consumer
    //Function<Input_Type, Output_Type> = operation;
    static Function<Integer, Integer> incrementByOneFunc = num -> num + 1;


    static Function<Integer, Integer> multiplyBy10 = num -> num * 10;

    // BiFunction takes two inputs and produces one output
    static BiFunction<Integer, Integer, Integer> addTwoNumbers = (num1, num2) -> num1 + num2;


   static int incrementByOne(int num){
        return num + 1;
   }

   static class _Sample{
     static void print(){
         System.out.println("I'm the static inner class");
     }
   }

}
