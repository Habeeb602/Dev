class Singleton{
	private static volatile Singleton instance;
	private String data;
	
	private Singleton(String data){
		this.data = data;
	}
	
	public void printData(){
		System.out.println("SingletonData: " + data);
	}
	
	public static Singleton getInstance(String data){
		Singleton result = instance;
		if(result == null){
			synchronized(Singleton.class){
				result = instance;
				if(result == null)
					instance = result = new Singleton(data);
			}
		}
		
		return result;
		
	}
}

class BillPughSingleton{
	private String data;
	
	
	private BillPughSingleton(){
		data = "Default BillPughSingleton";
	}

	
	private static class Holder{
		private static final BillPughSingleton INSTANCE = new BillPughSingleton();
	}
	
	public static BillPughSingleton getInstance(){
		return Holder.INSTANCE;
	}
	
	public void printData(){
		System.out.println("BillPughSingletonData: " + data);
	}
	public String getData(){
		return data;
	}
	
	public void setData(String data){
		this.data = data;
	}
}


public class SingletonMain{
	public static void main(String[] args){
		
		for(int i=0;i<10;i++){
			// Singleton st = Singleton.getInstance(String.format("Instance %d", i));
			// st.printData();
			BillPughSingleton bpst = BillPughSingleton.getInstance();
			bpst.setData(String.format("data: %d", i));
			System.out.println(String.format("Instance %s, %s", bpst, bpst.getData()));
		}
		
	}
}