import java.util.*;
import java.util.stream.*;
import java.util.function.*;

class StreamPractice{

	public static void main(String[] args){
		String s = "I am learning streams API in Java";
		// q1(s);
		// q2("defehggjlkjxo");
		// q3(s);
		// q4(s);
		// q5("I I am am am learning streams API in in Java Java");
		q7(new int[]{1,2,3,4,5,6,7,8,9});
	}
	
	private static void q1(String s){
		String t = Arrays.stream(s.split(" ")).sorted(Comparator.comparingInt(String::length).reversed()).findFirst().get();
		String k = Arrays.stream(s.split(" ")).max(Comparator.comparing(String::length)).get();
		System.out.println(t);
		System.out.println(k);
	}
	
	private static void q2(String s){
		String t = s.chars().distinct().mapToObj(k -> String.valueOf((char)k)).collect(Collectors.joining(""));
		String r = Arrays.stream(s.split("")).distinct().collect(Collectors.joining());
		System.out.println(r);
	}
	
	private static void q3(String s){
		String t = Arrays.stream(s.split(" ")).sorted(Comparator.comparing(String::length).reversed()).skip(1).findFirst().get();
		System.out.println(t);
	}
	
	private static void q4(String s){
		String t = Arrays.stream(s.split(" ")).sorted(Comparator.comparingInt(String::length).reversed()).skip(1).findFirst().get();
		System.out.println(t.length());
	}
	
	private static void q5(String s){
		Map<String,Long> t = Arrays.stream(s.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(t);
	}
	
	
	private static void q7(int[] a){
		// Map<Boolean,List<Integer>> mapPB = Arrays.stream(a).boxed().collect(Collectors.partitioningBy(k -> k % 2 == 0, Collectors.toList())); 
		Map<Integer,List<Integer>> mapGB = Arrays.stream(a).boxed().collect(Collectors.groupingBy(k -> k % 2, Collectors.toList()));
		System.out.println(mapGB);
	}
	
	
	
	
}