package generics;

public class Printer<T> {
    private T value;

    public Printer(){}


    public Printer(T value){
        this.value = value;
    }

    public void print(){
        System.out.println(value);
    }

    public void print(T value){
        this.value = value;
        print();
    }

}
