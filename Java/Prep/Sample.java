import java.util.HashMap;
import java.util.Map;

public class Sample {
    public static void main(String[] args) {
    	Map<String, String> map = new HashMap<>();
    	
    	map.put("Hello", "Hi");
    	
    	System.out.println(map.get("Hi"));
    	
    }
}