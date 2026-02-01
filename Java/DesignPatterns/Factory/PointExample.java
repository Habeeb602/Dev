import java.util.*;

public class PointExample{
	public static void main(String[] args){
		
		System.out.println(Point.Factory.newCartesianPoint(10, 5).toString());
		System.out.println(Point.Factory.newPolarPoint(10, 5).toString());
		
	}
}


class Point{
	
	private double a;
	private double b;
	
	
	private Point(double a, double b){
		this.a = a;
		this.b = b;
	}
	
	public static class Factory{
		public static Point newCartesianPoint(double x, double y){
			return new Point(x, y);
		}
		
		public static Point newPolarPoint(double rho, double theta){
			return new Point(rho * Math.cos(theta), rho * Math.sin(theta));
		}
	}
	
	
	public String toString(){
		return String.format("Point: A:%.2f, B:%.2f", a, b);
	}
	
}