import java.util.*;

public class FizzBuzzThread{
	
	public static void main(String[] args){
		
		FizzBuzz fb = new FizzBuzz();
		
		Thread fizz = new Thread(() -> fb.fizz());
		Thread buzz = new Thread(() -> fb.buzz());
		Thread fizzBuzz = new Thread(() -> fb.fizzBuzz());
		Thread notFizzBuzz = new Thread(() -> fb.notFizzBuzz());
		
		buzz.start();
		fizz.start();
		fizzBuzz.start();
		notFizzBuzz.start();
	}
}


class FizzBuzz{
	
	private int counter = 1;
	private final int MAX = 50;
	private boolean checkMulOf3And5(){
		return counter % 3 == 0 && counter % 5 == 0;
	}
	
	private boolean checkNotMulOf3And5(){
		return counter % 3 != 0 && counter % 5 != 0;
	}
	
	private boolean checkMulOf3(){
		return counter % 3 == 0;
	}
	
	private boolean checkMulOf5(){
		return counter % 5 == 0;
	}
	
	
	public synchronized void fizz(){
		while(counter <= MAX){
			//while(checkMulOf3And5() && !checkMulOf3()){
			while(counter % 3 != 0 || counter % 5 == 0){
				try{
					wait();
					//Thread.sleep(1000);
				}
				catch(InterruptedException ex){
					Thread.currentThread().interrupt();
				}
			}
			System.out.println(counter + " Fizz - / by 3");
			counter++;
			notifyAll();
		}
	}
	
	public synchronized void buzz(){
		while(counter <= MAX){
			//while(checkMulOf3And5() && !checkMulOf5()){
			while(counter % 5 != 0 || counter % 3 == 0){
				try{
					wait();
					//Thread.sleep(1000);
				}
				catch(InterruptedException ex){
					Thread.currentThread().interrupt();
				}
			}
			System.out.println(counter + " Buzz - / by 5");
			counter++;
			notifyAll();
		}
	}
	
	
	public synchronized void fizzBuzz(){
		while(counter <= MAX){
			//while(checkNotMulOf3And5()){
			while(counter % 3 != 0 || counter % 5 != 0){
				try{
					wait();
					//Thread.sleep(1000);
				}
				catch(InterruptedException ex){
					Thread.currentThread().interrupt();
				}
			}
			System.out.println(counter + " FizzBuzz - / by 3 & 5");
			counter++;
			notifyAll();
		}
	}
	
	
	public synchronized void notFizzBuzz(){
		while(counter <= MAX){
			//while(checkMulOf3And5()){
			while((counter % 3 == 0 || counter % 5 == 0)){
				try{
					wait();
					//Thread.sleep(1000);
				}
				catch(InterruptedException ex){
					Thread.currentThread().interrupt();
				}
			}
			System.out.println(counter + " - Not / by 3 & 5");
			counter++;
			notifyAll();
		}
	}
	
}