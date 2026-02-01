import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PrototypeMain {
    public static void main(String[] args) {
        

        List<Vehicle> vehicles = new ArrayList<>();

        for(int i=0;i<=10;i++){
            if(i % 2 == 0){
                vehicles.add(
                    new Car("Car-" + i, "Model-" + i, 4)
                );
            }
            else{
                vehicles.add(
                    new Bus("Bus-" + i, "Model-" + i, 8)
                );
            }
        }


        for(Vehicle vehicle: vehicles){
            
            Vehicle copy = vehicle.clone();
            System.out.println("Original: " + vehicle);
            System.out.println("Copy: " + copy);
        }

    }
}

abstract class Vehicle{
    String brand;
    String model;
    UUID chassisNbr;

    public Vehicle(String brand, String model){
        this.brand = brand;
        this.model = model;
        chassisNbr = UUID.randomUUID();
    }

    public abstract Vehicle clone();


}


class Car extends Vehicle{
    int nbrDoors;

    public Car(String brand, String model, int nbrDoors){
        super(brand, model);
        this.nbrDoors = nbrDoors;
    }
    
    public Car(Car car){
        super(car.brand, car.model);
        this.nbrDoors = car.nbrDoors;
    }

    @Override
    public Vehicle clone(){
        return new Car(this);
    }

    @Override
    public String toString() {
        return "Car [brand=" + brand + ", model=" + model + ", chassisNbr=" + chassisNbr + ", nbrDoors=" + nbrDoors
                + "]";
    }

    
}

class Bus extends Vehicle{

    int nbrWheels;

    public Bus(String brand, String model, int nbrWheels){
        super(brand, model);
        this.nbrWheels = nbrWheels;
    }

    public Bus(Bus bus){
        super(bus.brand, bus.model);
        this.nbrWheels = bus.nbrWheels;
    }

    @Override
    public Vehicle clone(){
        return new Bus(this);
    }

    @Override
    public String toString() {
        return "Bus [brand=" + brand + ", model=" + model + ", chassisNbr=" + chassisNbr + ", nbrWheels=" + nbrWheels
                + "]";
    }
}
