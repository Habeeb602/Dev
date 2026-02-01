import java.util.*;

public class PrintOddEven{

	static class OddEvenThread{
		int counter = 0;
		final int MAX = 20;
		public synchronized void printOdd(){
			while(counter < MAX){
				while(counter % 2 == 0) { // Even's turn
					try{
						wait();
						Thread.sleep(1000);
					}
					catch(InterruptedException ex){
						Thread.currentThread().interrupt();
					}
				}
				System.out.println("Odd: " + counter);
				counter++;
				notify();
			}
		}
		
		public synchronized void printEven(){
			
			while(counter < MAX){
				while(counter % 2 != 0) { // Odd's turn
					try{
						wait();
						Thread.sleep(1000);
					}
					catch(InterruptedException ex){
						Thread.currentThread().interrupt();
					}
				}
				System.out.println("Even: " + counter);
				counter++;
				notify();
			}
		}
		
	}

	public static void main(String[] args) throws InterruptedException{
		
		OddEvenThread oe = new OddEvenThread();
		
		Thread odd = new Thread(() -> oe.printOdd());
		Thread even = new Thread(() -> oe.printEven());
		
		odd.start();
		even.start();
		
	}
}