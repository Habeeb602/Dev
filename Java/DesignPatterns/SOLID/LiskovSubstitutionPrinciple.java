

/*
 * In this code we are trying to violate Liskov Substitution principle
 * This principle states that 
 * If a class B is a child of class A, then you should be able to use B anywhere you use A — and everything should still work correctly.
 * Subtypes should behave like their parent types, without causing bugs or unexpected results.
 */
public class LiskovSubstitutionPrinciple {
    public static void main(String[] args) {

        Rectangle r = new Rectangle(5, 10);
        System.out.println(String.format("Area of Rectangle is %f * %f = %f", r.width, r.height, r.findArea()));;



        Rectangle s = new Square();
        s.setHeight(10);
        double height = s.getHeight();
        s.setWidth(20);
        double width = s.getWidth();
        System.out.println(String.format("height = %f, width = %f - Expected: %f, but actual o/p: %f", height, width, height* width, s.findArea()));
        // s.findArea();
    }
}


class Rectangle{
    double width;
    double height;
    public Rectangle() {
    }
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    @Override
    public String toString() {
        return "Rectangle [width=" + width + ", height=" + height + "]";
    }

    // public void findArea(){
    //     System.out.println(String.format("Area of Rectangle is %f * %f = %f", width, height, width * height));;
    // }

    public double findArea(){
        // System.out.println(String.format("Area of Rectangle is %f * %f = %f", width, height, width * height));;
        return width * height;
    }
}


class Square extends Rectangle{
    @Override
    public void setHeight(double height) {
        this.height = height;
        this.width = height;
    }
    @Override
    public void setWidth(double width) {
        this.width = width;
        this.height = width;
    }
}   