import greeting.*;


class Sample{
    public static void main(String args[]){
        Hello hello = new Hello();
        hello.SayHello();
        ArithmeticOps ao = new ArithmeticOps();
        System.out.println(ao.add(3, 6));
    }
}