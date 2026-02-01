public class BuilderMain{
	public static void main(String[] args){
		Car car = new Car.Builder()
					.brand("Toyota")
					.model("Innova")
					.color("White")
					.id(1)
					.nbrDoors(4)
					.screenType("Fiber")
					.height(1.5)
					.weight(0.7)
					.build();


		System.out.println(car);
	}
}


class Car{
	private final int id;
	private final String brand;
	private final String model;
	private final String color;
	private final int nbrDoors;
	private final String screenType;
	private final double weight;
	private final double height;

	private Car(Builder builder){
		this.id = builder.id;
		this.brand = builder.brand;
		this.model = builder.model;
		this.color = builder.color;
		this.nbrDoors = builder.nbrDoors;
		this.screenType = builder.screenType;
		this.weight = builder.weight;
		this.height = builder.height;
	}

	
	
	@Override
	public String toString() {
		return "Car [id=" + id + ", brand=" + brand + ", model=" + model + ", color=" + color + ", nbrDoors=" + nbrDoors
				+ ", screenType=" + screenType + ", weight=" + weight + ", height=" + height + "]";
	}



	public static class Builder{
		
		int id;
		String brand;
		String model;
		String color;
		int nbrDoors;
		String screenType;
		double weight;
		double height;
		
		
		public Builder id(int id){
			this.id = id;
			return this;
		}
		
		public Builder brand(String brand){
			this.brand = brand;
			return this;
		}
		
		public Builder model(String model){
			this.model = model;
			return this;
		}
		
		public Builder color(String color){
			this.color = color;
			return this;
		}
		
		public Builder nbrDoors(int nbrDoors){
			this.nbrDoors = nbrDoors;
			return this;
		}
		
		public Builder screenType(String screenType){
			this.screenType = screenType;
			return this;
		}
		
		public Builder weight(double weight){
			this.weight = weight;
			return this;
		}
		
		public Builder height(double height){
			this.height = height;
			return this;
		}

		public Car build(){
			return new Car(this);
		}
	}
}