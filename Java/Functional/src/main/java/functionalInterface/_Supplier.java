package functionalInterface;


import java.util.function.Supplier;

public class _Supplier {

    public static void main(String[] args) {

        System.out.println("Normal function");
        System.out.println(getDBConnectionUrl());

        System.out.println("Using Supplier");
        System.out.println(getDBConnectionUrlSupplier);
    }

    // Supplier is used to return result/value, nothing else
    static Supplier<String> getDBConnectionUrlSupplier = () -> "spring:jdbc://localhost:3306/student-management-system";

    static String getDBConnectionUrl(){
        return "spring:jdbc://localhost:3306/student-management-system";
    }

}
