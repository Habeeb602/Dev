import java.util.HashMap;
import java.util.Map;

class Database{
    Map<String,String> creds = new HashMap<>();

    public Database(){
        creds.put("admin_username", "admin_password");
        creds.put("user_username", "user_password");
    }

    public boolean isValidUsername(String username){
        return creds.containsKey(username);
    }

}

public class ChainOfResponsibilityMain {
    
}
