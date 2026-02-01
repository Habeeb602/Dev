import java.util.*;
import java.util.stream.*;
import java.util.function.*;

class StreamQuestionsReview2_0{
	
	public static void main(String args[]){
		//q1("I am learning java streams");
		//q2("I am learning java streams");
		//q3("I am learning java streams");
		//q4("I am learning java streams");
		//q5("I I I am am learning java java streams");
		//q7(Arrays.asList(1,2,3,4,5,6,7,8,9));
		//q8("I am learning java streams");
	
		test("I am learning java streams");
	}
	
	private static void q1(String s){
		String ans = Arrays.stream(s.split(" ")).sorted(Comparator.comparing(String::length).reversed()).findFirst().get();
		System.out.println(ans);
	}
	
	private static void q2(String s){
		String ans = Arrays.stream(s.split("")).distinct().collect(Collectors.joining());
		System.out.println(ans);
	}
	
	private static void q3(String s){
		String ans = Arrays.stream(s.split(" ")).sorted(Comparator.comparingInt(String::length).reversed()).skip(1).findFirst().get();
		System.out.println(ans);
	}
	
	private static void q4(String s){
		int ans = Arrays.stream(s.split(" ")).map(String::length).sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		System.out.println(ans);
	}
	
	private static void q5(String s){
		Map<String, Long> fre = Arrays.stream(s.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(fre);
	}
	
	private static void q7(List<Integer> list){
		Collection<List<Integer>> ans = list.stream().collect(Collectors.groupingBy(i -> i % 2,Collectors.toList())).values();
		Collection<List<Integer>> ans2 = list.stream().collect(Collectors.groupingBy(i -> i % 2 == 0,Collectors.toList())).values();
		System.out.println(ans);
		System.out.println(ans2);
	}
	
	private static void q8(String s){
		Map<Character,Long> ans = s.toLowerCase().chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(ans);
	}
	
	
	private static void test(String s){
		Arrays.stream(s.split(" ")).map(k -> k.chars()).sorted().forEach(System.out::println);
		//System.out.println(ans);
	}
}