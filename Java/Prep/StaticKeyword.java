public class StaticKeyword {

    String firstName;

    static StaticKeyword setFirstName(String fname){
        StaticKeyword sk = new StaticKeyword();
        sk.firstName = fname;
        return sk;
    }


    public static void main(String args[]){
        StaticKeyword sk = new StaticKeyword();
        sk = sk.setFirstName("Habeeb");
        System.out.println(sk.firstName);
    }
}
