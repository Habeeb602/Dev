

abstract class Burger{
	protected int productId;
	protected String addOns;
	
	public Burger(int productId, String addOns){
		this.productId = productId;
		this.addOns = addOns;
	}
	
	public abstract void prepare();
}

class VeggieBurger extends Burger{
	
	boolean combo;
	public VeggieBurger(int id, String addOns, boolean combo){
		super(id, addOns);
		this.combo = combo;
	}
	
	@Override
	public void prepare(){
		System.out.println(String.format("Preparing %s", this));
	}
	
	@Override
	public String toString(){
		return String.format("VeggieBurger: [id: %d, addOns: %s, combo: %s]", productId, addOns, combo);
	}
	
}



class BeefBurger extends Burger{
	boolean angus;
	
	public BeefBurger(int id, String addOns, boolean combo){
		super(id, addOns);
		this.angus = angus;	
	}
	
	@Override
	public void prepare(){
		System.out.println(String.format("Preparing %s", this));
	}
	
	
	@Override
	public String toString(){
		return String.format("BeefBurger: [id: %d, addOns: %s, angus: %s]", productId, addOns, angus);
	}	
}




abstract class Restaurant{
	Burger burger;
	
	public Burger orderBurger(String addOns, boolean combo){
		burger = createBurger(addOns, combo);
		burger.prepare();
		return burger;
	}
	
	public abstract Burger createBurger(String addOns, boolean combo);
}


class VeggieBurgerRestaurant extends Restaurant{
	@Override
	public Burger createBurger(String addOns, boolean combo){
		Burger burger = new VeggieBurger(1, addOns, combo);
		return burger;
	}	
}

class BeefBurgerRestaurant extends Restaurant{
	@Override
	public Burger createBurger(String addOns, boolean angus){
		Burger burger = new BeefBurger(2, addOns, angus);
		return burger;
	}
}


public class FactoryMain{
	public static void main(String[] args){
		// VeggieBurger
		Restaurant veg = new VeggieBurgerRestaurant();
		veg.orderBurger("Salad", true);
		
		// BeefBurger
		Restaurant nonveg = new BeefBurgerRestaurant();
		nonveg.orderBurger("Mayonise", true);
	}
}