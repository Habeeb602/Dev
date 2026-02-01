public class Objects {

    public static void main(String[] args){
        Point a = new Point();
        System.out.println(a);
        a = new Point(15, 25);
        System.out.println(a);
        Car car = new Car();
        car.print();
    }
}


class Point{
    int x;
    int y;

    Point(){}
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class Car{

    {
        color = "Green";
    }

    String color = "black";
    String model;

    void print(){
        int k = 10;
        System.out.println(color + " " + model + " " + k);
    }

}

/*

public class TestMyDate{
public static void main(String[] args){
MyDate date1 = new MyDate(11,11,1918);
MyDate date2 = new MyDate();
date2.day = 11;
date2.month = 11;
date2.year = 1918;
MyDate date3 = new MyDate();
date3.setDate(4,21,1968);
String str1 = date1.toString();
String str2 = date2.toString();
String str3 = date3.toString();
System.out.println(str1);
System.out.println(str2);
System.out.println(str3);
 */