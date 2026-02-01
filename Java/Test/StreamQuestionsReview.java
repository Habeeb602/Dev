import java.util.*;
import java.util.stream.*;
import java.util.function.*;


public class StreamQuestionsReview {
    
    public static void main(String[] args) {
        
		String s = "I am learning java streams !!";
		List<Integer> list = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10);
		int[] arr = {1,2,3,4,5,6};
		// ques1(s);
		//ques2(s);
		//ques3(s);
		//ques4(s);
		//ques5("I am am am learning learning java java java java streams streams streamssssss !!");
		//ques7(list);
		//ques8("Mississippi");
		//ques9(arr);
		//ques10(new int[]{1,1,2,4,5,6,7,8,8,10,23,23,23});
		ques11("HHello World!!");
		// System.out.println("Hello!!");
    }
	
	
	private static void ques1(String s){
		
		String res = Arrays.stream(s.split(" ")).max(Comparator.comparingInt(String::length)).get();
		
		System.out.println(res);		
	}
	
	private static void ques2(String s){
		
		//List<Character> res = s.chars().distinct().mapToObj(t -> (char)t).collect(Collectors.toList());
		String res = Arrays.stream(s.split("")).distinct().collect(Collectors.joining());
		System.out.println(res);		
	}
	
	private static void ques3(String s){
	
		String res = Arrays.stream(s.split(" ")).sorted(Comparator.comparingInt(String::length).reversed()).skip(1).findFirst().get();
		
		System.out.println(res);		
	}
	
	private static void ques4(String s){
		// 04 Find the 2nd highest length word in the given sentence
		
		
		int k = Arrays.stream(s.split(" ")).map(String::length).sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		
		System.out.println(k);		
	}
	
	private static void ques5(String s){
		// 05 Given a sentence, find the occurrence of each word
		Map<String, Long> ans = Arrays.stream(s.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		System.out.println(ans);
	}
	
	private static void ques7(List<Integer> list){
		// 07 Divide given integer list into lists of even and odd numbers
		
		Map<Boolean, List<Integer>> ans = list.stream().collect(Collectors.partitioningBy(n -> n%2 == 0, Collectors.toList()));
		Map<Integer, List<Integer>> ans1 = list.stream().collect(Collectors.groupingBy(n -> n%2, Collectors.toList()));
		
		
		System.out.println(ans);		
		System.out.println(ans1);			
	}
	
	private static void ques8(String s){
		//  08 Given a word, find the occurrence of each character
		
		Map<String, Long> ans = Arrays.stream(s.split("")).map(String::new).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(ans);
	}
	
	private static void ques9(int[] arr){
		// 09 Arrange the numbers in Descending/Ascending Order
		String ans = Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).map(String::valueOf).collect(Collectors.joining());
		System.out.println(ans);
	}
	
	private static void ques10(int[] arr){
		// 10 Given an array, find the sum of unique elements
		
		int ans = Arrays.stream(arr).distinct().sum();
		
		System.out.println(ans);
	}
	
	private static void ques11(String s){
		// 11 Given a string, find the first non-repeated character
		
		char c = s.chars().mapToObj(t -> (char)t).filter(t -> s.indexOf(t) == s.lastIndexOf(t)).findFirst().get();
		System.out.println("'" + c + "'");
		System.out.println(s.chars().mapToObj(p -> (char)p).collect(Collectors.groupingBy((String c) -> c, LinkedHashMap::new, Collectors.counting())));
		//System.out.println(s.chars().mapToObj(t -> (char)t).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())));
	}
	
}