
public class CarMain {
    public static void main(String[] args){
        NewCar newCar = new NewCar("White", "Innova", "EV");
        System.out.println(newCar.toString());
    }
}


class NewCar{
    String color, model, fuelType;
    int serialNum;
    static int carCount;
    NewCar(){
        this.serialNum = ++carCount;
    }

    NewCar(String color, String model){
        // If we need to call another constructor, it should be on the first line.
        // THe constructor should be called with the keyword "this()"
        this();
        this.color = color;
        this.model = model;
    }

    NewCar(String color, String model, String fuelType){
        this(color, model);
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "NewCar{" +
                "color='" + color + '\'' +
                ", model='" + model + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", serialNum=" + serialNum +
                '}';
    }
}
