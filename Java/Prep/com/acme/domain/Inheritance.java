package com.acme.domain;

public class Inheritance {
    public static void main(String[] args){
        Vehicle v = new Car();
        v.ride();
    }
}



class Vehicle{
    void ride(){
        System.out.println("Riding vehicle");
    }
}

class Car extends Vehicle{
    void ride(){
        System.out.println("Driving Car");
    }
}
