package com.se2.stream;

import java.util.Optional;
import java.util.stream.IntStream;

public class OptionalExample {

    public static void main(String[] args) {

        optional();
        System.out.println("getOptional(null) = " + getOptional(null));
        System.out.println("getOptional(\"Hello\") = " + getOptional("Hello"));

    }

    private static void optional(){

        Optional<Double> optional = getAvg(10,20,30,10);

        System.out.println("optional.orElseThrow() : average = " + optional.orElseThrow());
    }

    private static Optional<Double> getAvg(int... nums){
        if(nums.length == 0){
            return Optional.empty();
        }

        double sum = 0;
        for(int n: nums){
            sum += n;
        }

        return Optional.of(sum/nums.length);
    }

    private static Optional<String> getOptional(String s){

//        Optional<String> res = s == null ? Optional.empty() : Optional.of(s);
        // Works same as the above ternary condition
        Optional<String> res = Optional.ofNullable(s);

        return res;
    }
}
