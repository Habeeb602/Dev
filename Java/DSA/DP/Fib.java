public class Fib{
	public static void main(String[] args){
		int n = 40;
		int[] memo = new int[n+1];
		
		System.out.println(String.format("Fibonacci of %d is %d", n, fibonacci(n, memo)));
	}
	
	static int fibonacci(int n, int[] memo){
		if(n < 2) return 1;
		if(memo[n] != 0) return memo[n];
		
		memo[n] = fibonacci(n-1, memo) + fibonacci(n-2, memo);
		return memo[n];
	}
}