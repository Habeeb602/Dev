package generics;

import generics.animal.Animal;


// This generic only takes animal classes and it's subclasses as type
// This is also called as bounded-generic
public class AnimalPrinter <T extends Animal>{

    private T anyAnimal;

    public AnimalPrinter(){}

    public AnimalPrinter(T anyAnimal){
        this.anyAnimal = anyAnimal;
    }

    public void print(){
        System.out.println(anyAnimal);
    }

    public void print(T anyAnimal){
        this.anyAnimal = anyAnimal;
        print();
    }


}
