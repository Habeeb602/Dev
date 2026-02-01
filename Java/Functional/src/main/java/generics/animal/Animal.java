package generics.animal;

public class Animal {

    public void eat(){
        System.out.println("Eating!");
    }

    @Override
    public String toString(){
        return "Animal";
    }
}
