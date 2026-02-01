import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamInterviewQuestions {

    public static void main(String[] args) {
//        List<String> list = new ArrayList<>(Arrays.asList("Habeeb", "is", "learning", "Java", "Streams"));

        String s = "Habeeb is learning Java Streams";
        List<String> list = Arrays.asList(s.split(" "));
//        ques1(list);
//        ques2("abcdgsvcbabsnsddha");
//        ques3(list);
//        ques4(s);
//        ques5("I I am am am a a Java Java Java developer developer");
//        ques6(s, 2);
//        ques7(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
//        ques8("Habeeb");
//        ques9(new int[]{5,6,3,4,8,9,1,2,4,0,1});
//        ques10(new int[]{5,6,3,4,8,9,9,2,4,0,1});

        // ques13(new int[]{1,2,5,14,17,18,20,28,35,39,45,50});
		ques13_1("Muppana, Indira *CONTRACTOR*");
		ques13_1("Jahir Hussain, Habeeb Rahman");
    }

    // Question 1: Largest Length word in the list
    private static void ques1(List<String> list){
        System.out.println("Largest Length word in the list = " + list.stream().sorted(Comparator.comparingInt(String::length).reversed()).findFirst().get());

        System.out.println("Largest Length word in the list = " + list.stream().max(Comparator.comparingInt(String::length)).get());

        System.out.println("Smallest Length word in the list = " + list.stream().min(Comparator.comparingInt(String::length)).get());
    }

    // Question 2: Remove duplicate characters from string and return in same order
    private static void ques2(String s){
        System.out.println("Arrays.asList(s.split(\"\")).stream().distinct().collect(Collectors.toList()) = " + Arrays.asList(s.split("")).stream().distinct().collect(Collectors.joining()));
    }

    // Question 3: Find the word that has the second-highest length
    private static void ques3(List<String> list){

        System.out.println("list.stream().sorted(Comparator.comparingInt(String::length).reversed()).skip(1).findFirst().get() = " + list.stream().sorted(Comparator.comparingInt(String::length)).skip(1).findFirst().get());
    }

    // Question 4: Find the length of the highest length word
    private static void ques4(String s) {

        System.out.println("Arrays.asList(s.split(\" \")).stream().map(String::length).sorted(Comparator.reverseOrder()).skip(1).findFirst().get() = " + Arrays.asList(s.split(" ")).stream().map(String::length).sorted(Comparator.reverseOrder()).skip(1).findFirst().get());
    }

    // Question 5: Given a sentence, find the occurrence of each word
    private static void ques5(String s){
//         s.chars().mapToObj(c -> (char)c).collect(Function.identity(), LinkedHashMap::new, Collectors.counting())
        System.out.println("Stream.of(s.split(\" \")).collect(Collectors.groupingBy(String::valueOf, Collectors.counting())) = " + Stream.of(s.split(" ")).collect(Collectors.groupingBy(String::valueOf, Collectors.counting())));
    }

    // Question 6: Given a sentence, find the words with a specified number of vowels
    private static void ques6(String s, int k){

        List<String> list =  Stream.of(s.split(" "))
                .filter(t -> {
                    int count = 0;
                    for(char c: t.toCharArray()){
                        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
                            count++;
                    }

                    return k == count;
                })
                .collect(Collectors.toList());

        System.out.println("list = " + list);
    }

    // Question 7: Divide given integer list into lists of even and odd numbers
    private static void ques7(List<Integer> s){

        System.out.println("s.stream().collect(Collectors.groupingBy(t -> t%2==0, Collectors.toList())) = " + s.stream().collect(Collectors.groupingBy(t -> t % 2 == 0, Collectors.toList())));

        System.out.println("s.stream().collect(Collectors.groupingBy(t -> t%2==0, Collectors.toList())).values() = " + s.stream().collect(Collectors.groupingBy(t -> t % 2 == 0, Collectors.toList())).values());

        System.out.println("s.stream().collect(Collectors.partitioningBy(x -> x%2==0, Collectors.toList())).values() = " + s.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0, Collectors.toList())).values());
//        System.out.println("ans = " + ans);
    }

    // Question 8: Given a word, find the occurrence of each character
    private static void ques8(String s){

        Map<Character, Long> k = s.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c->c, Collectors.counting()));
        System.out.println("k = " + k);
    }

    // Question 9: Given an int[] array, arrange the numbers in Descending/Ascending Order
    private static void ques9(int[] a){

        System.out.println("Arrays.stream(a).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList()) = " + Arrays.stream(a).boxed().sorted().collect(Collectors.toList()));

        System.out.println("Arrays.stream(a).mapToObj(s -> s).sorted(Comparator.reverseOrder()).collect(Collectors.toList()) = " + Arrays.stream(a).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
    }

    // Question 10: Given an array, find the sum of unique elements
    private static void ques10(int[] a){

        System.out.println("Arrays.stream(a).boxed().distinct().mapToInt(t -> t).sum() = " + Arrays.stream(a).distinct().sum());
    }

    // Question 11: Given a string, find the first non-repeated character
    public static void ques11(String s){

        Character t = s.chars().mapToObj(c -> (char)c).filter(c -> s.indexOf(c) == s.lastIndexOf(c)).findFirst().get();
        Character k = s.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting())).entrySet().stream().filter(e -> e.getValue() == 1).findFirst().get().getKey();

        System.out.println(k);
    }


    // 12.  Given a string, find the first repeated character
    public static void ques12(String s){

        char t = s.chars().mapToObj(c -> (char)c).filter(c -> s.indexOf(c) != s.lastIndexOf(c)).findFirst().get();
        t = Arrays.stream(s.split("")).collect(Collectors.groupingBy(c->c, LinkedHashMap::new, Collectors.counting())).entrySet().stream().filter(c -> c.getValue() > 1).map(c -> c.getKey()).findFirst().get().charAt(0);
        System.out.println(t);
    }

    // 13. Given an array of integers, group the numbers by the range
    public static void ques13(int[] a){
        Map<Integer,List<Integer>> map = IntStream.of(a).boxed().collect(Collectors.groupingBy(k -> (k/10)*10, HashMap::new ,Collectors.toList()));

        System.out.println("map = " + map);
    }

	private static void ques13_1(String s){
	
		List<String> t = Arrays.stream(s.replace("*CONTRACTOR*", "").trim().split(",")).map(String::trim).collect(Collectors.toList());
		Collections.reverse(t);
		System.out.println(t.stream().collect(Collectors.joining(" ")));
		
	}
}
