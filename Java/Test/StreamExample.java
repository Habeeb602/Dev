import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {

        /*
        List<String> list = new ArrayList<>(){{
            add("Habeeb");
            add("is");
            add("learning");
            add("Java");
            add("Streams");
        }};

         */

        List<String> list = new ArrayList<>(Arrays.asList("Habeeb", "is", "learning", "Java", "Streams"));


        System.out.println(list.stream().map(String::length).sorted(Comparator.reverseOrder()).map(s -> String.valueOf(s)).collect(Collectors.joining(", ")));


        // list.stream().collect(Collectors.groupingBy(Function::identity));

        // 1. Print the largest string from the list.

        String largest = list.stream().max(Comparator.comparingInt(String::length)).get();
        System.out.println("largest = " + largest);

        // 2. Remove duplicates from the string

        String input = "aabbccddeeghjkkk";
        String duplicatesRemoved = Arrays.stream(input.split("")).distinct().collect(Collectors.joining());
        System.out.println("duplicatesRemoved = " + duplicatesRemoved);


        /** Another way of removing duplicates

         System.out.println(list.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.joining(" ")));

         */
        // 3. Print the second-largest string from the list

        String secondLargest = list.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .skip(1)
                .findFirst().get();

        System.out.println("secondLargest = " + secondLargest);


        // 4. Print the second-largest length of a string from a given list

        int secondLargestLength = list.stream().map(String::length).sorted().skip(list.size() - 2).findFirst().get();

        System.out.println("secondLargestLength = " + secondLargestLength);

        // 5. Given a sentence, find the occurrence of each word

        String sent = "I I I am am a a a Java Developer";


        Map<String, Long> stringCount = Arrays
                .stream(sent.split(" "))
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
        System.out.println("stringCount = " + stringCount);


        // 6. Print the words which has exactly two vowels in it

        Pattern pat = Pattern.compile("^[aeiou]{2}$", Pattern.CASE_INSENSITIVE);
        String stringWithTwoVowels = Arrays.stream(sent.split(" "))
                .filter(s -> pat.matcher(s).find())
                .collect(Collectors.joining(", "));
        System.out.println("stringWithTwoVowels = " + stringWithTwoVowels);
    }

}
