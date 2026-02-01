package functionalInterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {
        System.out.println("Normal function");
        System.out.println(validatePhoneNumber("+916381027209"));
        System.out.println(validatePhoneNumber("6381027209"));


        System.out.println("Using Predicate");
        System.out.println(validatePhoneNumPredicate.test("+919600792107"));
        System.out.println(validatePhoneNumPredicate.test("+9119600792107"));

        //Chaining Predicates

        System.out.println("Using chained Predicate");
        System.out.println(validatePhoneNumPredicate.and(contains0).test("+919600792107"));
        System.out.println(validatePhoneNumPredicate.or(contains0).test("+919611792127"));

        //BiPredicate
        System.out.println("BiPredicate");
        System.out.println("Is eligible for vote: " + eligibleForVote.test("Tamil Nadu", 17));
    }

    static Predicate<String> validatePhoneNumPredicate = phone -> phone.startsWith("+91") && phone.length() == 13;

    static Predicate<String> contains0 = phone -> phone.contains("0");

    static BiPredicate<String, Integer>  eligibleForVote = (state, age) -> state.equals("Tamil Nadu") && age >= 18;

    static boolean validatePhoneNumber(String phone){
        return phone.startsWith("+91") && phone.length() == 13;
    }

}
