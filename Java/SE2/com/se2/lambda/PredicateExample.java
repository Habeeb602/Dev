package com.se2.lambda;


import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class PredicateExample {
    public static void main(String[] args) {
        Predicate<Integer> isNegative = i -> i < 0;
        Predicate<String> isValidEmail = email -> {
//            Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
//            return pattern.matcher(email).matches();
            return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
        };
        System.out.println(isNegative.test(10));
        System.out.println(isValidEmail.test("habeeb@gmail.com"));


        // Integer example
        Integer age = 23;
        System.out.println("Can a person with " + age + " years of age vote in India? " + check(age, yearsOld -> yearsOld >= 18));

        String word = "Habeeb";
        System.out.println("Is " + word + " has vowels in it? " + check(word, str -> str.matches("a|e|i|o|u|A|E|I|O|U")));

        BiPredicate<String, Integer> checkLength = (name, len) -> name.length() == len;

        System.out.println("Does my name has the length of 6? " + checkLength.test(word, 6));
    }

    public static <T> boolean check(T t, Predicate<T> predicate){
        return predicate.test(t);
    }
}
